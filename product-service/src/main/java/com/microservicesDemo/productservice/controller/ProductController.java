package com.microservicesDemo.productservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microservicesDemo.productservice.entity.Product;
import com.microservicesDemo.productservice.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product) {
        logger.debug("Saving product");
        return productService.saveProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        logger.debug("Get all products");
        return productService.fetchAllProducts();
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        logger.debug("Updating product");
        return productService.updateProductById(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        logger.debug("Deleting product");
        return productService.deleteProductById(id);
    }
}
