package com.aston.orderservice.services.implementations;

import com.aston.orderservice.domain.CustomerTable;
import com.aston.orderservice.repositories.TableRepository;
import com.aston.orderservice.services.TableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableServiceImpl implements TableService {

    Logger log = LoggerFactory.getLogger(TableServiceImpl.class);

    private TableRepository tableRepository;

    public TableServiceImpl(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @Override
    public List<CustomerTable> getTables() {
        List<CustomerTable> tables = new ArrayList<>();
        this.tableRepository.findAll().iterator().forEachRemaining(tables::add);
        return tables;
    }

    @Override
    public CustomerTable getTable(Integer id) {
        return this.tableRepository.findById(id).orElse(null);
    }

    @Override
    public CustomerTable addTable(CustomerTable table) {
        return this.tableRepository.save(table);
    }

    @Override
    public List<CustomerTable> addTables(Iterable<CustomerTable> tablesList) {
        List<CustomerTable> tables = new ArrayList<>();
        this.tableRepository.saveAll(tablesList).iterator().forEachRemaining(tables::add);
        return tables;
    }

    @Override
    public CustomerTable updateTable(CustomerTable table) {
        return this.tableRepository.save(table);
    }

    @Override
    public boolean deleteTable(CustomerTable table) {
        try {
            this.tableRepository.save(table);
            return true;
        } catch(NullPointerException ex) {
            log.warn("No table was found");
            return false;
        }
    }
}
