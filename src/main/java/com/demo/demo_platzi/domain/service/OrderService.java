package com.demo.demo_platzi.domain.service;

import com.demo.demo_platzi.domain.OrderDTO;
import com.demo.demo_platzi.persistance.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDTO> getAll() {
        return orderRepository.getAll();
    }

    public Optional<List<OrderDTO>> getByClient(String clientId) {
        return orderRepository.getByClient(clientId);
    }

    public OrderDTO save(OrderDTO purchase) {
        return orderRepository.save(purchase);
    }
}
