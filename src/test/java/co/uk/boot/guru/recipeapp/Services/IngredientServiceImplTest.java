package co.uk.boot.guru.recipeapp.Services;

import co.uk.boot.guru.recipeapp.commands.IngredientCommand;
import co.uk.boot.guru.recipeapp.converters.IngredientToIngredientCommand;
import co.uk.boot.guru.recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import co.uk.boot.guru.recipeapp.domain.Ingredient;
import co.uk.boot.guru.recipeapp.domain.Recipe;
import co.uk.boot.guru.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class IngredientServiceImplTest {


    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    @Mock
    RecipeRepository recipeRepository;

    IngredientService ingredientService;

    public IngredientServiceImplTest( ) {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

         ingredientService = new IngredientServiceImpl(recipeRepository,ingredientToIngredientCommand);
    }

    @Test
    public void findByRecipeIdAndId() {

    }

    @Test
    public void findByRecipeIdAndIdHappyPath() {

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);

        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndId(1L,3L);

        assertEquals( Long.valueOf(3L),ingredientCommand.getId());
        assertEquals(Long.valueOf(1L),ingredientCommand.getRecipeId());
        verify(recipeRepository,times(1)).findById(anyLong());
    }
}