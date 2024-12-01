package pe.edu.tecsup.tienda.services;



import pe.edu.tecsup.tienda.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories() throws Exception;
}
