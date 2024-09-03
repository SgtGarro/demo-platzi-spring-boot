package com.demo.demo_platzi.persistance.crud;

import com.demo.demo_platzi.persistance.entities.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IOrderCrudRepository extends CrudRepository<Order, Integer> {
    Optional<List<Order>> findByIdClient(String idClient);
}
