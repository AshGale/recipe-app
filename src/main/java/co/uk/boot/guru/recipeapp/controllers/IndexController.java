package co.uk.boot.guru.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","/index", "/templates/index.html"})
    public String getIndexPage(){
        System.out.println("home page asfssdf");

        return "index";
    }
}
