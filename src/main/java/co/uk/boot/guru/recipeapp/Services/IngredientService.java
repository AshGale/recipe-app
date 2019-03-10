package co.uk.boot.guru.recipeapp.Services;

import co.uk.boot.guru.recipeapp.commands.IngredientCommand;
import org.springframework.stereotype.Service;

@Service
public interface IngredientService {

    IngredientCommand findByRecipeIdAndId(Long id, Long aLong);

    IngredientCommand saveIngredient(IngredientCommand command);
}
