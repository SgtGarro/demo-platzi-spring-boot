package com.demo.demo_platzi.persistance.mapper;

import com.demo.demo_platzi.domain.OrderDTO;
import com.demo.demo_platzi.persistance.entities.Order;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { IOrderItemMapper.class })
public interface IOrderMapper {
    @Mappings({
            @Mapping(source = "idOrder", target = "purchaseId"),
            @Mapping(source = "idClient", target = "clientId"),
            @Mapping(source = "ordersProductList", target = "orderList")
    })
    OrderDTO toOrderDTO(Order order);
    List<OrderDTO> toOrdersDTO(List<Order> orderList);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Order toOrder(OrderDTO order);
}
