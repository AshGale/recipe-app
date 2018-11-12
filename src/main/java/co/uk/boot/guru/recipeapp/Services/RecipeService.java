package co.uk.boot.guru.recipeapp.Services;

import co.uk.boot.guru.recipeapp.commands.RecipeCommand;
import co.uk.boot.guru.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
