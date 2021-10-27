package com.ecommerce.shop.service;

import com.ecommerce.shop.data.dto.ProductDto;
import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.web.exception.ProductDoesNotExistException;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> saveAll(List<Product> products);
    List<Product> finAll();
    Product findById(Long id);
    void deleteById(Long id);
    Product update(Long id, ProductDto productDto) throws ProductDoesNotExistException;
}
