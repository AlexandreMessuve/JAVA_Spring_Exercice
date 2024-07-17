package com.example.exercice01.controller;

import com.example.exercice01.entity.Product;
import com.example.exercice01.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct() {
       return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/admin/add")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted with id: " + id);
    }
}
