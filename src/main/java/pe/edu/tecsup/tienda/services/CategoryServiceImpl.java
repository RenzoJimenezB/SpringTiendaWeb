package pe.edu.tecsup.tienda.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.tienda.entities.Category;
import pe.edu.tecsup.tienda.repositories.CategoryRepository;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() throws Exception {
        log.info("CategoryServiceImpl.getCategories()");

        return categoryRepository.findAll();
    }
}
