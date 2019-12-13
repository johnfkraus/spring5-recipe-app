package guru.springframework.controllers;

import ch.qos.logback.classic.pattern.ClassNameOnlyAbbreviator;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.RecipeService;
import guru.springframework.services.RecipeServiceImpl;
import org.h2.index.Index;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    IndexController controller;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        // recipeService = new RecipeServiceImpl(recipeRepository);
        controller = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {
        String viewName = controller.getIndexPage(model);
        assertEquals("index", viewName);
        verify(recipeService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }
}
