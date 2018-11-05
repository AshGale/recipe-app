package co.uk.boot.guru.recipeapp.controllers;

import co.uk.boot.guru.recipeapp.Services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index", "/templates/index.html"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes",recipeService.getRecipes());

        return "index";
    }


}
