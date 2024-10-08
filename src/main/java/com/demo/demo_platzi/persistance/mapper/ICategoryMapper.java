package com.demo.demo_platzi.persistance.mapper;


import com.demo.demo_platzi.domain.CategoryDTO;
import com.demo.demo_platzi.persistance.entities.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "status", target = "active"),

    })
    CategoryDTO toCategoryDomain(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategoryEntity(CategoryDTO category);


}
