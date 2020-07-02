package learn.spring.categoryapi.api.v1.mapper;

import learn.spring.categoryapi.api.v1.model.CategoryDTO;
import learn.spring.categoryapi.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
