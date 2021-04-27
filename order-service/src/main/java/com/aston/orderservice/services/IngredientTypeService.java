package com.aston.orderservice.services;

import com.aston.orderservice.domain.IngredientType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IngredientTypeService {

    public List<IngredientType> getIngredientTypes();

    public IngredientType getIngredientType(@PathVariable Integer id);

    public IngredientType addIngredientType(@RequestBody IngredientType ingredientType);

    public List<IngredientType> addIngredientTypes(@RequestBody Iterable<IngredientType> ingredientTypes);

    public IngredientType updateIngredientType(@RequestBody IngredientType ingredientType);

    public boolean deleteIngredientType(@RequestBody IngredientType ingredientType);
}
