package guru.springframework.converters;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.commands.NotesCommand;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {

    //public static final Recipe RECIPE = new Recipe();
    private static final BigDecimal AMOUNT = new BigDecimal("1");
    private static final String INGREDIENT_DESCRIPTION = "Cheeseburger";
    private static final Long UOM_ID = Long.valueOf(2L);
    private static final String UOM_DESCRIPTION = "Shitload";
    private static final Long INGREDIENT_ID = Long.valueOf(1L);

    IngredientToIngredientCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void convert() {
        // given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);
        uom.setDescription(UOM_DESCRIPTION);
        Ingredient ingredient = new Ingredient();
        ingredient.setId(INGREDIENT_ID);
        ingredient.setDescription(INGREDIENT_DESCRIPTION);
        ingredient.setAmount(AMOUNT);
        ingredient.setUom(uom);
        // when
        IngredientCommand command = converter.convert(ingredient);
        // then
        assertEquals(INGREDIENT_ID, command.getId());
        assertNotNull(command.getUnitOfMeasure());
        assertEquals(UOM_ID, command.getUnitOfMeasure().getId());
        assertEquals(AMOUNT, command.getAmount());
        assertEquals(INGREDIENT_DESCRIPTION, command.getDescription());
        assertEquals(UOM_DESCRIPTION, command.getUnitOfMeasure().getDescription());

    }
    @Test
    public void convertWithNullUom() {
        // given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(INGREDIENT_ID);
        ingredient.setDescription(INGREDIENT_DESCRIPTION);
        ingredient.setAmount(AMOUNT);
        //ingredient.setUom(uom);
        // when
        IngredientCommand command = converter.convert(ingredient);
        // then
        assertNull(command.getUnitOfMeasure());
        assertEquals(INGREDIENT_ID, command.getId());
        // assertNotNull(command.getUnitOfMeasure());
        //assertEquals(UOM_ID, command.getUnitOfMeasure().getId());
        assertEquals(AMOUNT, command.getAmount());
        assertEquals(INGREDIENT_DESCRIPTION, command.getDescription());

    }
}
