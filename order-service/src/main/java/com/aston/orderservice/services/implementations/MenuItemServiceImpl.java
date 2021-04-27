package com.aston.orderservice.services.implementations;

import com.aston.orderservice.domain.MenuItem;
import com.aston.orderservice.repositories.MenuItemRepository;
import com.aston.orderservice.services.MenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    Logger log = LoggerFactory.getLogger(MenuItemServiceImpl.class);

    private MenuItemRepository menuItemRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        this.menuItemRepository.findAll().iterator().forEachRemaining(menuItems::add);
        return menuItems;
    }

    @Override
    public MenuItem getMenuItem(Integer id) {
        return this.menuItemRepository.findById(id).orElse(null);
    }

    @Override
    public MenuItem addMenuItem(MenuItem menuItem) {
        return this.menuItemRepository.save(menuItem);
    }

    @Override
    public List<MenuItem> addMenuItems(Iterable<MenuItem> menuItems) {
        List<MenuItem> savedMenuItems = new ArrayList<>();
        this.menuItemRepository.saveAll(menuItems).iterator().forEachRemaining(savedMenuItems::add);
        return savedMenuItems;
    }

    @Override
    public MenuItem updateMenuItem(MenuItem menuItem) {
        return this.menuItemRepository.save(menuItem);
    }

    @Override
    public boolean deleteMenuItem(MenuItem menuItem) {
        try {
            this.menuItemRepository.save(menuItem);
            log.info("DISABLED SUCCESSFULLY!");
            return true;
        } catch(NullPointerException nullEx) {
            log.warn("DISABLE FAILED! " + nullEx);
            return false;
        }
    }
}
