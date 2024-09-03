package com.demo.demo_platzi.domain.repository;

import com.demo.demo_platzi.domain.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<ProductDTO> getAll();
    Optional<List<ProductDTO>> getByCategoryId(int categoryId);
    Optional<List<ProductDTO>> getScarceProducts(int quantity);
    Optional<ProductDTO> getProduct(int productId);
    ProductDTO save(ProductDTO product);
    void delete(int productId);
}
