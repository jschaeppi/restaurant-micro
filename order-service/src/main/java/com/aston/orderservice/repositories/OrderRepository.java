package com.aston.orderservice.repositories;

import com.aston.orderservice.domain.TableOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TableOrder, Integer> {


}
