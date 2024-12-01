package pe.edu.tecsup.tienda.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.tecsup.tienda.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
