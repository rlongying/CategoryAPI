package learn.spring.categoryapi.bootstrap;

import learn.spring.categoryapi.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;

public class Bootstrap implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public Bootstrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
