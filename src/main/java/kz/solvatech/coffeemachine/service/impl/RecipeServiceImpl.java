package kz.solvatech.coffeemachine.service.impl;

import kz.solvatech.coffeemachine.dto.RecipeDTO;
import kz.solvatech.coffeemachine.model.RecipeEntity;
import kz.solvatech.coffeemachine.repository.RecipeRepository;
import kz.solvatech.coffeemachine.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;
    @Override
    public RecipeEntity addRecipe(RecipeDTO recipeDTO) {

        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setName(recipeDTO.getName());

        return recipeRepository.save(recipeEntity);

    }
}
