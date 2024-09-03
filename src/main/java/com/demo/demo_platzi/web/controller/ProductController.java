package com.demo.demo_platzi.web.controller;

import com.demo.demo_platzi.domain.ProductDTO;
import com.demo.demo_platzi.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") int productId) {
        return productService
                .getProduct(productId).map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDTO>> getByCategory(@PathVariable("id") int categoryId) {
        return productService
                .getByCategoryId(categoryId).map(productDTOS -> new ResponseEntity<>(productDTOS, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.save(productDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int productId) {
        if (productService.delete(productId))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
