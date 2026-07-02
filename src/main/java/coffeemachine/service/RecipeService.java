package coffeemachine.service;

import coffeemachine.dto.RecipeDTO;

import coffeemachine.model.RecipeEntity;
import org.springframework.stereotype.Service;

@Service
public interface RecipeService {
    RecipeEntity addRecipe(RecipeDTO recipeDTO);
}
