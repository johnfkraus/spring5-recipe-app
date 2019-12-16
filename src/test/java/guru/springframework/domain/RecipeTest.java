package guru.springframework.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void givenBuilderWithDefaultValue_ThanDefaultValueIsPresent() {
        Recipe build = Recipe.builder()
            .build();
        assertNotNull(build.getIngredients());
        //assertTrue(build.isOriginal());
    }
    @Test
    public void givenBuilderWithDefaultValue_NoArgsWorksAlso() {
        Recipe build = Recipe.builder()
            .build();
        Recipe pojo = new Recipe();
        assertNotNull(pojo);
        //assertEquals(build.getName(), pojo.getName());
        //Assert.assertTrue(build.isOriginal() == pojo.isOriginal());
    }

    @Test
    public void addIngredient() {
    }

    @Test
    public void setNotes() {
    }

    @Test
    public void builder() {
    }

    @Test
    public void getId() {
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getPrepTime() {
    }

    @Test
    public void getCookTime() {
    }

    @Test
    public void getServings() {
    }
}
