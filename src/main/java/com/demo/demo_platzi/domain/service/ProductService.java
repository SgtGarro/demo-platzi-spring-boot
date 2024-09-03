package com.demo.demo_platzi.domain.service;

import com.demo.demo_platzi.domain.ProductDTO;
import com.demo.demo_platzi.domain.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;

    public List<ProductDTO> getAll() {
        return productRepository.getAll();
    }

    public Optional<ProductDTO> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<ProductDTO>> getByCategoryId(int categoryId) {
        return productRepository.getByCategoryId(categoryId);
    }

    public Optional<List<ProductDTO>> getScarceProducts(int quantity) {
        return productRepository.getScarceProducts(quantity);
    }

    public ProductDTO save(ProductDTO product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        if (getProduct(productId).isPresent()) {
            productRepository.delete(productId);
            return true;
        }

        return false;
    }

}
