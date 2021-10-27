package com.ecommerce.shop.service;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplMockTest {
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productServiceImpl;

    @BeforeEach
    void setUp() {
        productServiceImpl = new ProductServiceImpl();
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void saveProductMockTest(){
        Product product = new Product();
        when(productServiceImpl.save(product)).thenReturn(product);
        productServiceImpl.save(product);
        verify(productRepository,times(1)).save(product);
    }
    @Test
    void updateProductMockTest(){
        Product product = new Product();
        when(productServiceImpl.save(product)).thenReturn(product);
        Product prod = productServiceImpl.save(product);
        prod.setPrice(200.0);
        prod.setId(1L);
        assertThat(prod.getPrice()).isEqualTo(200.0);

        Product prod2 = new Product();
        prod2.setPrice(400.0);




        verify(productRepository, times(1)).save(prod);
        assertThat(prod.getPrice()).isEqualTo(400.00);






    }
}