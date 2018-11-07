package co.uk.boot.guru.recipeapp.repositories;

import co.uk.boot.guru.recipeapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTestIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() {

        Optional<UnitOfMeasure> unitOfMeasure =
                unitOfMeasureRepository.findByDescription("Teaspoons");

        assertEquals("Teaspoons",unitOfMeasure.get().getDescription());
    }



    @Test
    public void findByDescriptionCup() {

        Optional<UnitOfMeasure> unitOfMeasure =
                unitOfMeasureRepository.findByDescription("Cups");

        assertEquals("Cups",unitOfMeasure.get().getDescription());
    }
}