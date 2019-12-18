package guru.springframework.services;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.converters.RecipeCommandToRecipe;
import guru.springframework.converters.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIT {
    public static final String NEW_DESCRIPTION = "New Description";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
//    }
    @Transactional // needed because you are accessing lazily-loaded properties; to keep it inside of the context
    @Test
    public void testSaveOfDescription() throws Exception {
        // given
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe testRecipe = recipes.iterator().next();
        assertNotNull(testRecipe);
        //System.out.println(testRecipe.toString());
        RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);
        assertNotNull(testRecipeCommand);

        // when
        testRecipeCommand.setDescription(NEW_DESCRIPTION);
        // save it using spring data jpa
        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);
        assertNotNull(savedRecipeCommand);
        // then
        assertEquals(NEW_DESCRIPTION, savedRecipeCommand.getDescription());
        assertEquals(testRecipe.getId(), savedRecipeCommand.getId());
        assertEquals(testRecipe.getCategories().size(), savedRecipeCommand.getCategories().size());
        assertEquals(testRecipe.getIngredients().size(), savedRecipeCommand.getIngredients().size());

    }

//    @Test
//    public void getRecipeByIdTest() {
//        Recipe recipe = Recipe.builder().id(1L).build();
//        Optional<Recipe> recipeOptional = Optional.of(recipe);
//        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
//
//        Recipe recipeReturned = recipeService.findById(1L);
//        assertNotNull("Null recipe received.", recipeReturned);
//        verify(recipeRepository, times(1)).findById(anyLong());
//        verify(recipeRepository, never()).findAll();
//    }
//
//    @Test
//    public void findAll() {
//        Recipe recipe = Recipe.builder().build();
//        HashSet recipesData = new HashSet();
//        recipesData.add(recipe);
//        when(recipeRepository.findAll()).thenReturn(recipesData);
//        Set<Recipe> recipes = recipeService.findAll();
//        assertEquals(recipes.size(), 1);
//        verify(recipeRepository, times(1)).findAll();
//
//    }
}
