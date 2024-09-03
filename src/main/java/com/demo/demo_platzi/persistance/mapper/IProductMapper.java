package com.demo.demo_platzi.persistance.mapper;

import com.demo.demo_platzi.domain.ProductDTO;
import com.demo.demo_platzi.persistance.entities.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ICategoryMapper.class })
public interface IProductMapper {
    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "sellPrice", target = "price"),
            @Mapping(source = "stockQuantity", target = "stock"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "category", target = "category")
    })
    ProductDTO toProductDto(Product product);
    List<ProductDTO> toProductsDto(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    Product toProduct(ProductDTO product);
}
