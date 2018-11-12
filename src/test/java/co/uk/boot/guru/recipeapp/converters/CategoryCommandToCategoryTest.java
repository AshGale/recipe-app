package co.uk.boot.guru.recipeapp.converters;

import co.uk.boot.guru.recipeapp.commands.CategoryCommand;
import co.uk.boot.guru.recipeapp.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "description";
    CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject(){
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject(){
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() {

        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setDescription(DESCRIPTION);
        categoryCommand.setId(ID_VALUE);

        Category category = converter.convert(categoryCommand);

        assertEquals(category.getId(),ID_VALUE);
        assertEquals(category.getDescription(),DESCRIPTION);

    }
}