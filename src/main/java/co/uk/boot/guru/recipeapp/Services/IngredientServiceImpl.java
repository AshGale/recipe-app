package co.uk.boot.guru.recipeapp.Services;

import co.uk.boot.guru.recipeapp.commands.IngredientCommand;
import co.uk.boot.guru.recipeapp.converters.IngredientToIngredientCommand;
import co.uk.boot.guru.recipeapp.domain.Recipe;
import co.uk.boot.guru.recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService{

    private final RecipeRepository recipeRepository;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    public IngredientServiceImpl(RecipeRepository recipeRepository, IngredientToIngredientCommand ingredientToIngredientCommand) {
        this.recipeRepository = recipeRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    }

    @Override
    public IngredientCommand findByRecipeIdAndId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (recipeOptional.isPresent()){

        }else{
            log.error("Recipe Not found with id: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
        .filter(ingredient -> ingredient.getId().equals(ingredientId))
        .map( ingredient ->
                ingredientToIngredientCommand.convert(ingredient))
                .findFirst();

        if (!ingredientCommandOptional.isPresent()){
            log.error("Ingredient not found with id: " + ingredientId);

        }

        return ingredientCommandOptional.get();
    }

    @Override
    public IngredientCommand saveIngredient(IngredientCommand command) {
        return null;
    }
}
