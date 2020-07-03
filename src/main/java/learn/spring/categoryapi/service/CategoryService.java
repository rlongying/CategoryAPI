package learn.spring.categoryapi.service;

import learn.spring.categoryapi.api.v1.model.CategoryDTO;
import learn.spring.categoryapi.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
