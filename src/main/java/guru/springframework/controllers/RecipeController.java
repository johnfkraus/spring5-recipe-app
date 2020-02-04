package guru.springframework.controllers;

import guru.springframework.commands.RecipeCommand;
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
//@RequestMapping("/recipe")
public class RecipeController {

    private RecipeService recipeService;
//    private RecipeRepository recipeRepository;
//    private UnitOfMeasureRepository unitOfMeasureRepository;
//    private CategoryRepository categoryRepository;

//    public RecipeController(RecipeService recipeService, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
//        this.recipeService = recipeService;
//        this.recipeRepository = recipeRepository;
//        this.unitOfMeasureRepository = unitOfMeasureRepository;
//        this.categoryRepository = categoryRepository;
//    }

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    //public RecipeController () {}

    //    @RequestMapping({"", "/", "/index", "/index.html"})
//    public String listRecipes(Model model) {
//        //Optional<Category> optionalCategory = categoryRepository.findByDescription("American");
//        //Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");
//        //System.out.println("Category id is " + optionalCategory.get().getId() + ", " + optionalCategory.get().getDescription());
//        //System.out.println("Unit of measure id is " + optionalUnitOfMeasure.get().getId());
//        model.addAttribute("recipes", recipeRepository.findAll());
//        return "recipes/index";
//    }
    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }

    @GetMapping("recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }

    @GetMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeform";
    }

    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @GetMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable String id) {
        log.debug("Deleting id = " + id);
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception) {
        log.error("Handling not found exception");
        log.error(exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
/*
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView numberFormatException(Exception exception) {
        log.error("Handling number format exception");
        log.error(exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("400error");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }

 */
}
