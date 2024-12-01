package pe.edu.tecsup.tienda.services;


import pe.edu.tecsup.tienda.entities.Product;

import java.util.List;

public interface ProductService {
    void save(Product product) throws Exception;

    List<Product> findAll() throws Exception;

    List<Product> findByName(String name) throws Exception;

    Product findById(Long id) throws Exception;

    void deleteById(Long id) throws Exception;

    void update(Product product) throws Exception;
}
