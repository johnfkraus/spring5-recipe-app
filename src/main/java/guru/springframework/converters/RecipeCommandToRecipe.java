package guru.springframework.converters;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConverter, IngredientCommandToIngredient ingredientConverter, NotesCommandToNotes notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand command) {
        if (command == null) {
            return null;
        }
        Recipe recipe = new Recipe();
        recipe.setDescription(command.getDescription());
        recipe.setId(command.getId());
        recipe.setPrepTime(command.getPrepTime());
        recipe.setCookTime(command.getCookTime());
        recipe.setServings(command.getServings());
        recipe.setDirections(command.getDirections());
        recipe.setSource(command.getSource());
        recipe.setUrl(command.getUrl());
        recipe.setDifficulty(command.getDifficulty());
        Notes notes = notesConverter.convert(command.getNotes());
        recipe.setNotes(notes);
        //recipe.setNotes(notesConverter.convert(command.getNotes()));
        if (command.getIngredients() != null && command.getIngredients().size() > 0) {
            command.getIngredients().forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
        }
        if (command.getCategories() != null && command.getCategories().size() > 0) {
            command.getCategories().forEach(category -> recipe.getCategories().add(categoryConverter.convert(category)));
        }

        return recipe;
    }
}
