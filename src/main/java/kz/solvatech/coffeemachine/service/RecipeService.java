package kz.solvatech.coffeemachine.service;

import kz.solvatech.coffeemachine.dto.RecipeDTO;

import kz.solvatech.coffeemachine.model.RecipeEntity;
import org.springframework.stereotype.Service;

@Service
public interface RecipeService {
    RecipeEntity addRecipe(RecipeDTO recipeDTO);
}
