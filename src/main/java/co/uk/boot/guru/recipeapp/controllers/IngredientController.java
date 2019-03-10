package co.uk.boot.guru.recipeapp.controllers;

import co.uk.boot.guru.recipeapp.Services.IngredientService;
import co.uk.boot.guru.recipeapp.Services.RecipeService;
import co.uk.boot.guru.recipeapp.Services.UnitOfMeasureService;
import co.uk.boot.guru.recipeapp.commands.IngredientCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private  final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping
    @RequestMapping("/recipe/{id}/ingredients")
    public String listIngredients(@PathVariable String id, Model model){
        log.debug("getting ingredients from recipe: " + id);
//        Set<Ingredient> ingredientSet = new HashSet<>();
//        ingredientSet = recipeService.findById(Long.valueOf(id)).getIngredients();
//
//        model.addAttribute("ingredients",ingredientSet);

        model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredient/{ingredientId}/show")
    public String showIngredient(@PathVariable String recipeId
            ,@PathVariable String ingredientId, Model model){

        model.addAttribute("ingredient",ingredientService
                .findByRecipeIdAndId(Long.valueOf(recipeId),Long.valueOf(ingredientId)));

        model.addAttribute("uomList",unitOfMeasureService.listAllUoms());

        return "recipe/ingredient/show";
    }

    @PostMapping
    @RequestMapping("/recipe/{recipeid}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command){
        IngredientCommand savedCommand = ingredientService.saveIngredient(command);

        log.debug("saved recipe id: " + savedCommand.getRecipeId());
        log.debug("saved ingredient id: " + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/show";
    }

}




