package co.uk.boot.guru.recipeapp.Services;

import co.uk.boot.guru.recipeapp.commands.UnitOfMeasureCommand;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
