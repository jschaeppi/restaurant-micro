package com.aston.orderservice.services.implementations;

import com.aston.orderservice.domain.TableOrder;
import com.aston.orderservice.repositories.OrderRepository;
import com.aston.orderservice.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<TableOrder> getOrders() {
        List<TableOrder> orders = new ArrayList<>();
        this.orderRepository.findAll().iterator().forEachRemaining(orders::add);
        return orders;
    }

    @Override
    public TableOrder getOrder(Integer id) {
        return this.orderRepository.findById(id).orElse(null);
    }

    @Override
    public TableOrder addOrder(TableOrder order) {
        return this.orderRepository.save(order);
    }

    @Override
    public List<TableOrder> addOrders(Iterable<TableOrder> ordersIterable) {
        List<TableOrder> orders = new ArrayList<>();
        this.orderRepository.saveAll(ordersIterable).iterator().forEachRemaining(orders::add);
        return orders;
    }

    @Override
    public TableOrder updateOrder(TableOrder order) {
        return this.orderRepository.save(order);
    }

    @Override
    public boolean deleteOrder(TableOrder order) {
        try {
            this.orderRepository.save(order);
            return true;
        } catch(NullPointerException ex) {
            log.warn("No order was found!");
            return false;
        }
    }
}
