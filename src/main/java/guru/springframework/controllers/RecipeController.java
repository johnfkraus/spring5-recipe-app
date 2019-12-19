package guru.springframework.controllers;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("/recipe/{id}/show/")
    public String showById(@PathVariable String id, Model model) {
        System.out.println("RecipeController showById");
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/show2";
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }

    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return  "recipe/recipeform";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/show/" + savedCommand.getId();

    }

}
