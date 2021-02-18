package guru.springframework.controllers;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Difficulty;
import guru.springframework.exceptions.NotFoundException;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class RecipesController {
    private final RecipeService recipeService;

    public RecipesController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    private String getRecipesIndex(Model model) {
        log.debug("Getting Index page");
        return "recipes/index";
    }

    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable("id") String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(Long.parseLong(id)));

        return "recipes/show";
    }

    @GetMapping("/recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        model.addAttribute("difficulties", Difficulty.values());
        return "recipes/recipeform";
    }

    @GetMapping("/recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        model.addAttribute("difficulties", Difficulty.values());

        return "recipes/recipeform";
    }


    @PostMapping("/recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @GetMapping("/recipe/{id}/delete")
    public String deleteRecipe(@PathVariable String id) {
        log.debug("Deleting id: " + id);

        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception) {
        log.error("Handling not found exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.setViewName("404error");

        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormatException(Exception exception) {
        log.error("Handling Number format exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.setViewName("400error");

        return modelAndView;
    }
}
