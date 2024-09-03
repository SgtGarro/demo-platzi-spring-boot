package com.demo.demo_platzi.persistance;

import com.demo.demo_platzi.domain.OrderDTO;
import com.demo.demo_platzi.domain.repository.IOrderRepository;
import com.demo.demo_platzi.persistance.crud.IOrderCrudRepository;
import com.demo.demo_platzi.persistance.entities.Order;
import com.demo.demo_platzi.persistance.mapper.IOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository implements IOrderRepository {

    @Autowired
    private IOrderCrudRepository orderCrudRepository;

    @Autowired
    private IOrderMapper mapper;


    @Override
    public List<OrderDTO> getAll() {
        return mapper.toOrdersDTO((List<Order>) orderCrudRepository.findAll());
    }

    @Override
    public Optional<List<OrderDTO>> getByClient(String clientId) {
        return orderCrudRepository.findByIdClient(clientId).map(mapper::toOrdersDTO);
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Order order = mapper.toOrder(orderDTO);
        order.getOrdersProductList().forEach(product -> product.setOrder(order));

        return mapper.toOrderDTO(orderCrudRepository.save(order));
    }
}
