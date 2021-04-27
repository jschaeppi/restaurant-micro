package com.aston.orderservice.repositories;

import com.aston.orderservice.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {


}
