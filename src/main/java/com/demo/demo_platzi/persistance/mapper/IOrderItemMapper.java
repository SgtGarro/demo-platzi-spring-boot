package com.demo.demo_platzi.persistance.mapper;

import com.demo.demo_platzi.domain.OrderItemDTO;
import com.demo.demo_platzi.persistance.entities.OrdersProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { IProductMapper.class })
public interface IOrderItemMapper {
    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "status", target = "active")
    })
    OrderItemDTO toOrderItemDTO(OrdersProduct ordersProduct);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "order", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idOrder", ignore = true)
    })
    OrdersProduct toOrdersProduct(OrderItemDTO order);
}
