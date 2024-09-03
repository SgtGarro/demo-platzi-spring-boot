package com.demo.demo_platzi.domain.repository;

import com.demo.demo_platzi.domain.OrderDTO;

import java.util.List;
import java.util.Optional;

public interface IOrderRepository {
    List<OrderDTO> getAll();
    Optional<List<OrderDTO>> getByClient(String clientId);
    OrderDTO save(OrderDTO order);
}
