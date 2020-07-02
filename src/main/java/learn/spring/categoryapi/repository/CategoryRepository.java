package learn.spring.categoryapi.repository;

import learn.spring.categoryapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
