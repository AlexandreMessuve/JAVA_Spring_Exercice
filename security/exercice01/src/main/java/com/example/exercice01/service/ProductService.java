package com.example.exercice01.service;

import com.example.exercice01.entity.Product;
import com.example.exercice01.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
    }
    public Product updateProduct(int id, Product productUpdated) {
        Product product = getProductById(id);
        product.setName(productUpdated.getName());
        product.setPrice(productUpdated.getPrice());
        productRepository.save(product);
        return product;
    }

    public boolean deleteProduct(int id) {
        productRepository.deleteById(id);
        return true;
    }
}
