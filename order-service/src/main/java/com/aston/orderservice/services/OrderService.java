package com.aston.orderservice.services;

import com.aston.orderservice.domain.TableOrder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderService {

    public List<TableOrder> getOrders();

    public TableOrder getOrder(@PathVariable Integer id);

    public TableOrder addOrder(@RequestBody TableOrder order);

    public List<TableOrder> addOrders(@RequestBody Iterable<TableOrder> orders);

    public TableOrder updateOrder(@RequestBody TableOrder order);

    public boolean deleteOrder(@RequestBody TableOrder order);
}
