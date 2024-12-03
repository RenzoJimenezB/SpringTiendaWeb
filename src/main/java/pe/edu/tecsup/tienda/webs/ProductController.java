package pe.edu.tecsup.tienda.webs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.tecsup.tienda.entities.Product;
import pe.edu.tecsup.tienda.services.CategoryService;
import pe.edu.tecsup.tienda.services.ProductService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/products")
public class ProductController {

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
}

