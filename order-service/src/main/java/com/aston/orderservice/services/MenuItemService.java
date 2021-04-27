package com.aston.orderservice.services;

import com.aston.orderservice.domain.MenuItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MenuItemService {

    public List<MenuItem> getMenuItems();

    public MenuItem getMenuItem(@PathVariable Integer id);

    public MenuItem addMenuItem(@RequestBody MenuItem menuItem);

    public List<MenuItem> addMenuItems(@RequestBody Iterable<MenuItem> menuItems);

    public MenuItem updateMenuItem(@RequestBody MenuItem menuItem);

    public boolean deleteMenuItem(@RequestBody MenuItem menuItem);
}
