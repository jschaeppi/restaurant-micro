package com.aston.orderservice.services.implementations;

import com.aston.orderservice.domain.Ingredient;
import com.aston.orderservice.repositories.IngredientRepository;
import com.aston.orderservice.services.IngredientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    Logger log = LoggerFactory.getLogger(IngredientServiceImpl.class);

    private IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredientList = new ArrayList<>();
        this.ingredientRepository.findAll().iterator().forEachRemaining(ingredientList::add);
        return ingredientList;
    }

    @Override
    public Ingredient getIngredient(Integer id) {
        return this.ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        return this.ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> addIngredients(Iterable<Ingredient> ingredients) {
        List<Ingredient> addedIngredients = new ArrayList<>();
        this.ingredientRepository.saveAll(ingredients).iterator().forEachRemaining(addedIngredients::add);
        return addedIngredients;
    }

    @Override
    public Ingredient updateIngredient(Ingredient ingredient) {
        return this.ingredientRepository.save(ingredient);
    }

    @Override
    public boolean deleteIngredient(Ingredient ingredient) {
        try {
            this.ingredientRepository.save(ingredient);
            log.warn("DISABLED SUCCESSFULLY!");
            return true;
        } catch(NullPointerException nullEx) {
            log.warn("DELETION FAILED! " + nullEx);
            return false;
        }
    }
}
