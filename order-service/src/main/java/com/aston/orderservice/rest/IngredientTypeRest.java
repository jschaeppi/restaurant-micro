package com.aston.orderservice.rest;

import com.aston.orderservice.domain.IngredientType;
import com.aston.orderservice.services.IngredientTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/v1/ingredientType")
public class IngredientTypeRest {

    Logger log = LoggerFactory.getLogger(IngredientTypeRest.class);


    private IngredientTypeService ingredientTypeService;


    public IngredientTypeRest(IngredientTypeService ingredientTypeService) {
        this.ingredientTypeService = ingredientTypeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<IngredientType>> findIngredientTypes() {
        List<IngredientType> orders = this.ingredientTypeService.getIngredientTypes();
        if (orders.size() == 0) {
            log.warn("No orders found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<IngredientType>());
        }
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientType> findIngredientType(@PathVariable Integer id) {
        IngredientType order = this.ingredientTypeService.getIngredientType(id);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new IngredientType());
        }
        return ResponseEntity.ok().body(order);
    }

    @PostMapping("/list")
    public ResponseEntity<List<IngredientType>> addIngredientTypes(@RequestBody Iterable<IngredientType> tableIterable) {
        List<IngredientType> tables= this.ingredientTypeService.addIngredientTypes(tableIterable);
        if (tables.size() == 0) {
            log.warn("No orders found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<IngredientType>());
        }
        return ResponseEntity.ok().body(tables);
    }

    @PostMapping("/")
    public ResponseEntity<IngredientType> addIngredientType(@RequestBody IngredientType table) {
        IngredientType savedIngredientType = this.ingredientTypeService.addIngredientType(table);
        if (table == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new IngredientType());
        }
        return ResponseEntity.ok().body(savedIngredientType);
    }

    @PutMapping("/")
    public ResponseEntity<IngredientType> updateIngredientType(@RequestBody IngredientType table) {
        IngredientType savedIngredientType = this.ingredientTypeService.addIngredientType(table);
        if (table == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new IngredientType());
        }
        return ResponseEntity.ok().body(savedIngredientType);
    }

    @PutMapping("/remove")
    public ResponseEntity<Boolean> deleteIngredientType(@RequestBody IngredientType table) {
        try {
            this.ingredientTypeService.deleteIngredientType(table);
            log.warn("DELETION SUCCESSFUL!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(true);
        } catch(NullPointerException ex) {
            log.warn("DELETION FAILED!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
