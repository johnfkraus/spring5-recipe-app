package guru.springframework.services;

import guru.springframework.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand FindByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

}
