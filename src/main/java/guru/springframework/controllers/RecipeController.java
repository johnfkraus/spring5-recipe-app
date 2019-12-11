package guru.springframework.controllers;

    import guru.springframework.domain.Category;
    import guru.springframework.domain.UnitOfMeasure;
    import guru.springframework.repositories.CategoryRepository;
    import guru.springframework.repositories.RecipeRepository;
    import guru.springframework.repositories.UnitOfMeasureRepository;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.RequestMapping;

    import java.util.Optional;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private CategoryRepository categoryRepository;

    public RecipeController(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listRecipes(Model model){
        //Optional<Category> optionalCategory = categoryRepository.findByDescription("American");
        //Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");
        //System.out.println("Category id is " + optionalCategory.get().getId() + ", " + optionalCategory.get().getDescription());
        //System.out.println("Unit of measure id is " + optionalUnitOfMeasure.get().getId());
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/index";
    }
}
