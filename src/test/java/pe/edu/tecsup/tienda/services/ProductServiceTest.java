package pe.edu.tecsup.tienda.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.tienda.entities.Category;
import pe.edu.tecsup.tienda.entities.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void save() throws Exception {
        log.info("Testing ProductService.save()");

        List<Product> products = productService.findAll();
        int totalBeforeInsert = products.size();

        Product product = new Product();

        Category category = new Category();
        category.setId(1L);
        product.setCategory(category);

        product.setName("AMD");
        product.setDescription("AMD X10");
        product.setPrice(280.0);
        product.setStock(6);
        product.setState(1);

        productService.save(product);

        product = productService.findById(product.getId());
        System.out.printf("Product saved in the DB:\n%s\n", product);

        products = productService.findAll();
        int totalAfterInsert = products.size();
        assertEquals(totalBeforeInsert + 1, totalAfterInsert);
    }

    @Test
    void findAll() throws Exception {
        log.info("Testing ProductService.getProducts()");

        List<Product> products = productService.findAll();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        assertFalse(products.contains(null));

        products.forEach(System.out::println);
    }

    @Test
    void findByName() throws Exception {
        log.info("Testing ProductService.getProductsByName()");

        List<Product> products = productService.findByName("Test");
        assertNotNull(products);
        assertFalse(products.isEmpty());
        assertFalse(products.contains(null));

        products.forEach(System.out::println);
    }

    @Test
    void findById() throws Exception {
        log.info("Testing ProductService.getProductById()");

        String EXPECTED_NAME = "NVIDIA";
        Long id = 20L;
        Product product = productService.findById(id);

        assertNotNull(product);
        assertEquals(EXPECTED_NAME, product.getName());

        System.out.println(product);
    }

    @Test
    void update() throws Exception {
        log.info("Testing ProductService.update()");

        Long id = 20L;
        String ORIGINAL_NAME = "NVIDIA";
        String UPDATED_NAME = "NVIDIA UPDATED";
        Product product;

        product = productService.findById(id);
        product.setName(UPDATED_NAME);

        productService.update(product);
        System.out.printf("Updated name: %s\n", product.getName());

        product = productService.findById(id);
        assertEquals(UPDATED_NAME, product.getName());

        product.setName(ORIGINAL_NAME);

        productService.update(product);
        System.out.printf("Original name: %s\n", product.getName());

        product = productService.findById(id);
        assertEquals(ORIGINAL_NAME, product.getName());
    }

    @Test
    void deleteById() throws Exception {
        log.info("Testing ProductService.deleteById()");

        List<Product> products = productService.findAll();
        int totalBeforeDelete = products.size();

        if (products.isEmpty())
            return;

        Product lastProduct = products.get(products.size() - 1);
        productService.deleteById(lastProduct.getId());

        System.out.printf("Product deleted from the DB:\n%s\n", lastProduct);

        products = productService.findAll();
        int totalAfterDelete = products.size();
        assertEquals(totalBeforeDelete - 1, totalAfterDelete);
    }
}