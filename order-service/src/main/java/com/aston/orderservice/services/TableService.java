package com.aston.orderservice.services;

import com.aston.orderservice.domain.CustomerTable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TableService {

    public List<CustomerTable> getTables();

    public CustomerTable getTable(Integer id);

    public CustomerTable addTable(@RequestBody CustomerTable table);

    public List<CustomerTable> addTables(@RequestBody Iterable<CustomerTable> tablesList);

    public CustomerTable updateTable(@RequestBody CustomerTable table);

    public boolean deleteTable(@RequestBody CustomerTable table);
}
