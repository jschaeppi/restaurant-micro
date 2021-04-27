package com.aston.orderservice.services.implementations;

import com.aston.orderservice.domain.IngredientType;
import com.aston.orderservice.repositories.IngredientTypeRepository;
import com.aston.orderservice.services.IngredientTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientTypeServiceImpl implements IngredientTypeService {

    Logger log = LoggerFactory.getLogger(IngredientTypeServiceImpl.class);

    private IngredientTypeRepository ingredientTypeRepository;

    public IngredientTypeServiceImpl(IngredientTypeRepository ingredientTypeRepository) {
        this.ingredientTypeRepository = ingredientTypeRepository;
    }

    @Override
    public List<IngredientType> getIngredientTypes() {
        List<IngredientType> ingredientTypes = new ArrayList<>();
        this.ingredientTypeRepository.findAll().iterator().forEachRemaining(ingredientTypes::add);
        return ingredientTypes;
    }

    @Override
    public IngredientType getIngredientType(Integer id) {
        return this.ingredientTypeRepository.findById(id).orElse(null);
    }

    @Override
    public IngredientType addIngredientType(IngredientType ingredientType) {
        return this.ingredientTypeRepository.save(ingredientType);
    }

    @Override
    public List<IngredientType> addIngredientTypes(Iterable<IngredientType> ingredientTypes) {
        List<IngredientType> savedIngredientTYpes = new ArrayList<>();
        this.ingredientTypeRepository.saveAll(ingredientTypes).iterator().forEachRemaining(savedIngredientTYpes::add);
        return savedIngredientTYpes;
    }

    @Override
    public IngredientType updateIngredientType(IngredientType ingredientType) {
        return this.ingredientTypeRepository.save(ingredientType);
    }

    @Override
    public boolean deleteIngredientType(IngredientType ingredientType) {
        try {
            this.ingredientTypeRepository.save(ingredientType);
            log.info("DISABLED SUCCESSFULL!");
            return true;
        } catch(NullPointerException nullEx) {
            log.warn("DISABLE FAILED! " + nullEx);
            return false;
        }
    }
}
