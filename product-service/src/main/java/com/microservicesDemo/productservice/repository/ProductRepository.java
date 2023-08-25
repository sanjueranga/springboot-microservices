package com.microservicesDemo.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservicesDemo.productservice.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
