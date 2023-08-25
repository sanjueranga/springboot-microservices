package com.microservicesDemo.productservice.service;



import java.util.List;

import  com.microservicesDemo.productservice.entity.Product;
public interface ProductService {

    Product saveProduct(Product product);

    List<Product> fetchAllProducts();

    Product getProductById(String id);

    Product updateProductById(String id, Product product);

    String deleteProductById(String id);
}