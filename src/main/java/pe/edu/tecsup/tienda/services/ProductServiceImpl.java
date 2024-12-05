package pe.edu.tecsup.tienda.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.tienda.entities.Product;
import pe.edu.tecsup.tienda.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        log.info("ProductServiceImpl.save()");

        productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        log.info("ProductServiceImpl.getProducts()");

        return productRepository.findAll();
    }

    @Override
    public List<Product> findByName(String name) throws Exception {
        log.info("ProductServiceImpl.findByName()");

        return productRepository.findByName(name);
    }

    @Override
    public Product findById(Long id) throws Exception {
        log.info("ProductServiceImpl.findById()");

        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent())
            return product.get();
        else
            throw new Exception("Product not found");
    }

    @Override
    public void update(Product product) {
        log.info("ProductServiceImpl.update()");

        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        log.info("ProductServiceImpl.deleteById()");
        productRepository.deleteById(id);
    }
}
