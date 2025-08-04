package kz.solvatech.coffeemachine.controller;

import kz.solvatech.coffeemachine.dto.OrderDTO;
import kz.solvatech.coffeemachine.dto.RecipeDTO;
import kz.solvatech.coffeemachine.model.RecipeEntity;
import kz.solvatech.coffeemachine.service.OrderService;
import kz.solvatech.coffeemachine.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CoffeeMachineController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/statistics/popular")
    public ResponseEntity<Long> popularRecipe(){

        return new ResponseEntity<>(orderService.findPopularRecipe(), HttpStatus.OK);
    }

    @PostMapping("/recipe")
    public ResponseEntity<RecipeEntity> addRecipe(@RequestBody RecipeDTO recipeDTO){
        RecipeEntity recipeEntity = recipeService.addRecipe(recipeDTO);
        return new ResponseEntity<>(recipeEntity, HttpStatus.CREATED);
    }

    @PostMapping("/order")
    public ResponseEntity<Object> addOrder(@RequestBody OrderDTO orderDTO){
        orderService.addOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
