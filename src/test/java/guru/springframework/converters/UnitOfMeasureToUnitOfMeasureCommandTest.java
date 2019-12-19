package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = Long.valueOf(1L);
    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }
    @Test
    public void testNullParameter() {
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() {
        converter.convert(new UnitOfMeasure());
    }

    @Test
    public void convert() {
        // given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription(DESCRIPTION);
        unitOfMeasure.setId(LONG_VALUE);
        // when
        UnitOfMeasureCommand uomc = converter.convert(unitOfMeasure);
        // then
        assertEquals(DESCRIPTION, uomc.getDescription());
        assertEquals(LONG_VALUE, uomc.getId());

    }
}
