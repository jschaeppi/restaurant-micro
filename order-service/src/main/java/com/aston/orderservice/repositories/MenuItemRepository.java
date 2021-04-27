package com.aston.orderservice.repositories;

import com.aston.orderservice.domain.MenuItem;
import org.springframework.data.repository.CrudRepository;


public interface MenuItemRepository extends CrudRepository<MenuItem, Integer> {


}
