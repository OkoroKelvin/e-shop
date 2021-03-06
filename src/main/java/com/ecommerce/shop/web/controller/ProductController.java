package com.ecommerce.shop.web.controller;

import com.ecommerce.shop.data.dto.ProductDto;
import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.service.ProductService;
import com.ecommerce.shop.web.exception.ProductDoesNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productServiceImpl;


    @GetMapping("/")
    public List<Product> getAll(){
        return productServiceImpl.finAll();
    }


    @GetMapping("/{id}")
    public Product getNative(@PathVariable("id") Long id){
        return productServiceImpl.findById(id);
    }


    @PostMapping("/")
    public Product save(@RequestBody Product product){
        log.info("Product request -> {}", product);
        return productServiceImpl.save(product);
    }


    @PostMapping("/saveAll")
    public List<Product> saveAll(@RequestBody List<Product> products){
        return productServiceImpl.saveAll(products);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody ProductDto productDto){
        Product product = null;
        try{
           product =  productServiceImpl.update(id, productDto);
        }
        catch
        (ProductDoesNotExistException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok().body(product);
    }

}
