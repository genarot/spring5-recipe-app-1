package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class RecipesController {

    private String getRecipesIndex(Model model) {
        return "recipes/index";
    }
}
