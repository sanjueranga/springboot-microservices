package com.microservicesDemo.productservice.service;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicesDemo.productservice.repository.ProductRepository;
import com.microservicesDemo.productservice.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        logger.debug("Saving product");
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts;
    }

    @Override
    public Product getProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }


    @Override
    public Product updateProductById(String id, Product updatedProduct) {
        logger.debug("Updating Product");
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            Product originalProduct = productOptional.get();

            if (updatedProduct.getName() != null) {
                originalProduct.setName(updatedProduct.getName());
            }
            if (updatedProduct.getQuantity() != null) {
                originalProduct.setQuantity(updatedProduct.getQuantity());
            }
            if (updatedProduct.getCategory() != null) {
                originalProduct.setCategory(updatedProduct.getCategory());
            }

            return productRepository.save(originalProduct);
        }
        return null;
    }


    @Override
    public String deleteProductById(String id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
            return "product deleted successfully";
        }
        return "No such product in the database";
    }

}