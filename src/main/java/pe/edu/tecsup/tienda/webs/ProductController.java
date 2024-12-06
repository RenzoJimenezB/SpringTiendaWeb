package pe.edu.tecsup.tienda.webs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.tecsup.tienda.entities.Category;
import pe.edu.tecsup.tienda.entities.Product;
import pe.edu.tecsup.tienda.services.CategoryService;
import pe.edu.tecsup.tienda.services.ProductService;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/products")
public class ProductController {

    @Value("${app.storage.path}")
    private String storagePath;

    CategoryService categoryService;
    ProductService productService;

    public ProductController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping()
    public String index(Model model) throws Exception {
        log.info("call index()");

        List<Product> products = productService.findAll();
        products.forEach(System.out::println);

        model.addAttribute("products", products);
        return "products/index";
    }

    @GetMapping("/create")
    public String create(Model model) throws Exception {
        log.info("call create()");

        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);

        model.addAttribute("product", new Product());
        return "products/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute("product")
                        Product product, Errors errors,
                        @RequestParam("file") MultipartFile file,
                        RedirectAttributes redirectAttributes) throws Exception {
        log.info("call store(product: {})", product);

        if (file != null && !file.isEmpty()) {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            product.setImage_name(fileName);

            if (Files.notExists(Paths.get(storagePath))) {
                Files.createDirectories(Paths.get(storagePath));
            }

            Files.copy(file.getInputStream(),
                    Paths.get(storagePath).resolve(fileName),
                    StandardCopyOption.REPLACE_EXISTING);
        }

        product.setCreatedAt(new Date());
        product.setState(1);
        
        productService.save(product);

        redirectAttributes.addFlashAttribute("message", "Product created");
        return "redirect:/products/";
    }

}

