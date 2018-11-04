package co.uk.boot.guru.recipeapp.repositories;

import co.uk.boot.guru.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
