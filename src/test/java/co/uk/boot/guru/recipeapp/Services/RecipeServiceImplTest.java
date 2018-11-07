package co.uk.boot.guru.recipeapp.Services;

import co.uk.boot.guru.recipeapp.domain.Recipe;
import co.uk.boot.guru.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setup() throws Exception{
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipeHashSet = new HashSet<>();
        recipeHashSet.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipeHashSet);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(),1);
        verify(recipeRepository, times(1)).findAll();
    }
}