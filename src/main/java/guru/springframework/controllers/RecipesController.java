package guru.springframework.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Slf4j
@Controller
public class RecipesController {

    private String getRecipesIndex(Model model) {
        log.debug("Getting Index page");
        return "recipes/index";
    }
}
