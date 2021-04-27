package com.aston.orderservice.rest;

import com.aston.orderservice.domain.TableOrder;
import com.aston.orderservice.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/v1/order")
public class OrderRest {

    Logger log = LoggerFactory.getLogger(OrderRest.class);

    private OrderService orderService;


    public OrderRest(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public ResponseEntity<List<TableOrder>> findOrders() {
        List<TableOrder> orders = this.orderService.getOrders();
        if (orders.size() == 0) {
            log.warn("No orders found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<TableOrder>());
        }
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableOrder> findOrder(@PathVariable Integer id) {
        TableOrder order = this.orderService.getOrder(id);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TableOrder());
        }
        return ResponseEntity.ok().body(order);
    }
    
    @PostMapping("/list")
    public ResponseEntity<List<TableOrder>> addOrders(@RequestBody Iterable<TableOrder> tableIterable) {
        List<TableOrder> tables= this.orderService.addOrders(tableIterable);
        if (tables.size() == 0) {
            log.warn("No orders found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<TableOrder>());
        }
        return ResponseEntity.ok().body(tables);
    }

    @PostMapping("/")
    public ResponseEntity<TableOrder> addOrder(@RequestBody TableOrder table) {
        TableOrder savedOrder = this.orderService.addOrder(table);
        if (table == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TableOrder());
        }
        return ResponseEntity.ok().body(savedOrder);
    }

    @PutMapping("/")
    public ResponseEntity<TableOrder> updateOrder(@RequestBody TableOrder table) {
        TableOrder savedOrder = this.orderService.addOrder(table);
        if (table == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TableOrder());
        }
        return ResponseEntity.ok().body(savedOrder);
    }

    @PutMapping("/remove")
    public ResponseEntity<Boolean> deleteOrder(@RequestBody TableOrder table) {
        try {
            this.orderService.deleteOrder(table);
            log.warn("DELETION SUCCESSFUL!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(true);
        } catch(NullPointerException ex) {
            log.warn("DELETION FAILED!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
