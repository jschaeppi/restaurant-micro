package com.aston.orderservice.rest;

import com.aston.orderservice.domain.CustomerTable;
import com.aston.orderservice.services.TableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/v1/table")
public class TableRest {

    Logger log = LoggerFactory.getLogger(TableRest.class);

    private TableService tableService;

    public TableRest(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/")
    public ResponseEntity<List<CustomerTable>> findTables() {
        List<CustomerTable> tables= this.tableService.getTables();
        if (tables.size() == 0) {
            log.warn("No orders found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<CustomerTable>());
        }
        return ResponseEntity.ok().body(tables);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerTable> findTable(@PathVariable Integer id) {
        CustomerTable table = this.tableService.getTable(id);
        if (table == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomerTable());
        }
        return ResponseEntity.ok().body(table);
    }

    @PostMapping("/list")
    public ResponseEntity<List<CustomerTable>> addTables(@RequestBody Iterable<CustomerTable> tableIterable) {
        List<CustomerTable> tables= this.tableService.addTables(tableIterable);
        if (tables.size() == 0) {
            log.warn("No orders found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<CustomerTable>());
        }
        return ResponseEntity.ok().body(tables);
    }

    @PostMapping("/")
    public ResponseEntity<CustomerTable> addTable(@RequestBody CustomerTable table) {
        CustomerTable savedTable = this.tableService.addTable(table);
        if (table == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomerTable());
        }
        return ResponseEntity.ok().body(savedTable);
    }

    @PutMapping("/")
    public ResponseEntity<CustomerTable> updateTable(@RequestBody CustomerTable table) {
        CustomerTable savedTable = this.tableService.addTable(table);
        if (table == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomerTable());
        }
        return ResponseEntity.ok().body(savedTable);
    }

    @PutMapping("/remove")
    public ResponseEntity<Boolean> deleteTable(@RequestBody CustomerTable table) {
        try {
            this.tableService.deleteTable(table);
            log.warn("DELETION SUCCESSFUL!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(true);
        } catch(NullPointerException ex) {
            log.warn("DELETION FAILED!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
