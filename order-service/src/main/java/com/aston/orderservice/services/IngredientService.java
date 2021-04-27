package com.aston.orderservice.services;

import com.aston.orderservice.domain.Ingredient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IngredientService {

    public List<Ingredient> getIngredients();

    public Ingredient getIngredient(@PathVariable Integer id);

    public Ingredient addIngredient(@RequestBody Ingredient ingredient);

    public List<Ingredient> addIngredients(@RequestBody Iterable<Ingredient> ingredients);

    public Ingredient updateIngredient(@RequestBody Ingredient ingredient);

    public boolean deleteIngredient(@RequestBody Ingredient ingredient);
}
