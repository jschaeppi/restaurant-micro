package com.aston.orderservice.rest;

import com.aston.orderservice.domain.Ingredient;
import com.aston.orderservice.services.IngredientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/v1/ingredient")
public class IngredientRest {

    Logger log = LoggerFactory.getLogger(IngredientRest.class);


    private IngredientService ingredientService;


    public IngredientRest(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Ingredient>> findIngredients() {
        List<Ingredient> orders = this.ingredientService.getIngredients();
        if (orders.size() == 0) {
            log.warn("No orders found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<Ingredient>());
        }
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> findIngredient(@PathVariable Integer id) {
        Ingredient order = this.ingredientService.getIngredient(id);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Ingredient());
        }
        return ResponseEntity.ok().body(order);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Ingredient>> addIngredients(@RequestBody Iterable<Ingredient> ingredientIterable) {
        List<Ingredient> ingredients = this.ingredientService.addIngredients(ingredientIterable);
        if (ingredients.size() == 0 || ingredients == null) {
            log.warn("No orders found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<Ingredient>());
        }
        return ResponseEntity.ok().body(ingredients);
    }

    @PostMapping("/")
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient table) {
        Ingredient savedIngredient = this.ingredientService.addIngredient(table);
        if (table == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Ingredient());
        }
        return ResponseEntity.ok().body(savedIngredient);
    }

    @PutMapping("/")
    public ResponseEntity<Ingredient> updateIngredient(@RequestBody Ingredient table) {
        Ingredient savedIngredient = this.ingredientService.addIngredient(table);
        if (table == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Ingredient());
        }
        return ResponseEntity.ok().body(savedIngredient);
    }

    @PutMapping("/remove")
    public ResponseEntity<Boolean> deleteIngredient(@RequestBody Ingredient table) {
        try {
            this.ingredientService.deleteIngredient(table);
            log.warn("DELETION SUCCESSFUL!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(true);
        } catch(NullPointerException ex) {
            log.warn("DELETION FAILED!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
