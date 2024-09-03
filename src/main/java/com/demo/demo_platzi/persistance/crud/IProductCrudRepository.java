package com.demo.demo_platzi.persistance.crud;

import com.demo.demo_platzi.persistance.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProductCrudRepository extends CrudRepository<Product, Integer> {
    List<Product> findByIdCategory(int idCategory);

    Optional<List<Product>> findByStockQuantityLessThanAndStatus(int stockQuantity, boolean status);

    List<Product> findByIdCategoryOrderByNameAsc(int idCategory);

}
