package pe.edu.tecsup.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.tecsup.tienda.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name) throws Exception;

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    List<Product> searchByNameLike(@Param("name") String name);
}
