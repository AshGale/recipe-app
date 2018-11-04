package co.uk.boot.guru.recipeapp.repositories;

import co.uk.boot.guru.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
