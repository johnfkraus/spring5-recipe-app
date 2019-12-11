package guru.springframework.services;

import guru.springframework.domain.Recipe;
import org.springframework.stereotype.Service;

@Service
public interface RecipeService extends CrudService<Recipe, Long> {

}
