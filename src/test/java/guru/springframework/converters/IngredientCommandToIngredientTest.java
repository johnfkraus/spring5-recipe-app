package guru.springframework.converters;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.Ingredient;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientCommandToIngredientTest {

    private static final BigDecimal AMOUNT = new BigDecimal("1");
    private static final String INGREDIENT_DESCRIPTION = "Cheeseburger";
    private static final Long UOM_ID = Long.valueOf(2L);
    private static final String UOM_DESCRIPTION = "Shitload";
    private static final Long INGREDIENT_ID = Long.valueOf(1L);

    IngredientCommandToIngredient converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void convert() {
        // given
        IngredientCommand command = new IngredientCommand();
        command.setId(INGREDIENT_ID);
        command.setDescription(INGREDIENT_DESCRIPTION);
        command.setAmount(AMOUNT);
        UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
        uomCommand.setId(UOM_ID);
        uomCommand.setDescription(UOM_DESCRIPTION);
        command.setUom(uomCommand);
        // when
        Ingredient ingredient = converter.convert(command);

        // then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(UOM_ID, ingredient.getUom().getId());
        assertEquals(UOM_DESCRIPTION, ingredient.getUom().getDescription());
        assertEquals(INGREDIENT_ID, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(INGREDIENT_DESCRIPTION, ingredient.getDescription());

    }
    @Test
    public void convertWithNullUom() {
        // given
        IngredientCommand command = new IngredientCommand();
        command.setId(INGREDIENT_ID);
        command.setDescription(INGREDIENT_DESCRIPTION);
        command.setAmount(AMOUNT);
//        UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
//        uomCommand.setId(UOM_ID);
//        uomCommand.setDescription(UOM_DESCRIPTION);
//        command.setUnitOfMeasure(uomCommand);
        // when
        Ingredient ingredient = converter.convert(command);

        // then
        assertNotNull(ingredient);
        assertNull(ingredient.getUom());
        //assertEquals(UOM_ID, ingredient.getUom().getId());
        //assertEquals(UOM_DESCRIPTION, ingredient.getUom().getDescription());
        assertEquals(INGREDIENT_ID, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(INGREDIENT_DESCRIPTION, ingredient.getDescription());

    }
}
