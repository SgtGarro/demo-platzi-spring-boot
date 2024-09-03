package com.demo.demo_platzi.persistance;

import com.demo.demo_platzi.domain.ProductDTO;
import com.demo.demo_platzi.domain.repository.IProductRepository;
import com.demo.demo_platzi.persistance.crud.IProductCrudRepository;
import com.demo.demo_platzi.persistance.entities.Product;
import com.demo.demo_platzi.persistance.mapper.IProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ProductRepository implements IProductRepository {
    @Autowired
    private IProductCrudRepository productCrudRepository;

    @Autowired
    private IProductMapper mapper;

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProductsDto(products);
    }

    @Override
    public Optional<List<ProductDTO>> getByCategoryId(int categoryId) {
        List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProductsDto(products));
    }


    @Override
    public Optional<List<ProductDTO>> getScarceProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockQuantityLessThanAndStatus(quantity, true);

        return products.map(product -> mapper.toProductsDto(product));
    }

    public Optional<ProductDTO> getProduct(int idProduct) {
        Optional<Product> product = productCrudRepository.findById(idProduct);
        return product.map(product1 -> mapper.toProductDto(product1));
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = mapper.toProduct(productDTO);

        return mapper.toProductDto(productCrudRepository.save(product));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
