package com.aston.orderservice.rest;

import com.aston.orderservice.domain.MenuItem;
import com.aston.orderservice.services.MenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/v1/menuitem")
public class MenuItemRest {

    Logger log = LoggerFactory.getLogger(MenuItemRest.class);

        private MenuItemService menuItemService;


        public MenuItemRest(MenuItemService menuItemService) {
                this.menuItemService = menuItemService;
        }

        @GetMapping("/")
        public ResponseEntity<List<MenuItem>> findMenuItems() {
                List<MenuItem> orders = this.menuItemService.getMenuItems();
                if (orders.size() == 0) {
                        log.warn("No orders found!");
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<MenuItem>());
                }
                return ResponseEntity.ok().body(orders);
        }

        @GetMapping("/{id}")
        public ResponseEntity<MenuItem> findMenuItem(@PathVariable Integer id) {
                MenuItem order = this.menuItemService.getMenuItem(id);
                if (order == null) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MenuItem());
                }
                return ResponseEntity.ok().body(order);
        }

        @PostMapping("/list")
        public ResponseEntity<List<MenuItem>> addMenuItems(@RequestBody Iterable<MenuItem> tableIterable) {
                List<MenuItem> tables= this.menuItemService.addMenuItems(tableIterable);
                if (tables.size() == 0) {
                        log.warn("No orders found!");
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<MenuItem>());
                }
                return ResponseEntity.ok().body(tables);
        }

        @PostMapping("/")
        public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem table) {
                MenuItem savedMenuItem = this.menuItemService.addMenuItem(table);
                if (table == null) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MenuItem());
                }
                return ResponseEntity.ok().body(savedMenuItem);
        }

        @PutMapping("/")
        public ResponseEntity<MenuItem> updateMenuItem(@RequestBody MenuItem table) {
                MenuItem savedMenuItem = this.menuItemService.addMenuItem(table);
                if (table == null) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MenuItem());
                }
                return ResponseEntity.ok().body(savedMenuItem);
        }

        @PutMapping("/remove")
        public ResponseEntity<Boolean> deleteMenuItem(@RequestBody MenuItem table) {
                try {
                        this.menuItemService.deleteMenuItem(table);
                        log.warn("DELETION SUCCESSFUL!");
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(true);
                } catch(NullPointerException ex) {
                        log.warn("DELETION FAILED!");
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
                }
        }
}
