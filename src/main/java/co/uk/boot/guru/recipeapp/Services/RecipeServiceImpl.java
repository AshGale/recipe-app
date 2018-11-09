package co.uk.boot.guru.recipeapp.Services;

import co.uk.boot.guru.recipeapp.domain.Recipe;
import co.uk.boot.guru.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {

        Set<Recipe> recipeSet = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    public Recipe findById(long id) {

        Optional<Recipe> recipe = recipeRepository.findById(id);

        if (!recipe.isPresent()){
            throw  new RuntimeException("Recipe with now found with id: " + id);
        }

        return recipe.get();
    }
}
