package com.aston.orderservice.repositories;

import com.aston.orderservice.domain.CustomerTable;
import org.springframework.data.repository.CrudRepository;

public interface TableRepository extends CrudRepository<CustomerTable, Integer> {


}
