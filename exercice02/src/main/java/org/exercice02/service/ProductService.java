package org.exercice02.service;

import org.exercice02.model.Category;
import org.exercice02.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private final Map<UUID, Product> products;

    public ProductService() {
        this.products = new HashMap<>();

        Product product1 = Product.builder()
                .id(UUID.randomUUID())
                .name("Iphone 15")
                .category(Category.ELECTRONICS)
                .price(1999.99)
                .build();
        Product product2 = Product.builder()
                .id(UUID.randomUUID())
                .name("Mascara")
                .category(Category.BEAUTY)
                .price(39.99)
                .build();
        Product product3 = Product.builder()
                .id(UUID.randomUUID())
                .name("Intel Core i9 13600K")
                .category(Category.ELECTRONICS)
                .price(1999.99)
                .build();
        Product product4 = Product.builder()
                .id(UUID.randomUUID())
                .name("Pizza")
                .category(Category.FOOD)
                .price(9.99)
                .build();
        Product product5 = Product.builder()
                .id(UUID.randomUUID())
                .name("Coca Cola")
                .category(Category.FOOD)
                .price(1.75)
                .build();
        Product product6 = Product.builder()
                .id(UUID.randomUUID())
                .name("Dress")
                .category(Category.FASHION)
                .price(199.99)
                .build();
        Product product7 = Product.builder()
                .id(UUID.randomUUID())
                .name("Pants")
                .category(Category.FASHION)
                .price(26.99)
                .build();
        Product product8 = Product.builder()
                .id(UUID.randomUUID())
                .name("Printer")
                .category(Category.INDUSTRIAL)
                .price(259999.99)
                .build();

        products.put(product1.getId(), product1);
        products.put(product2.getId(), product2);
        products.put(product3.getId(), product3);
        products.put(product4.getId(), product4);
        products.put(product5.getId(), product5);
        products.put(product6.getId(), product6);
        products.put(product7.getId(), product7);
        products.put(product8.getId(), product8);
    }

    public List<Product> getProducts() {
        return products.values().stream().toList();
    }

    public Product getProduct(UUID id) {
        return products.get(id);
    }

    public List<Product> searchProducts(String search) {
        List<Product> list = new ArrayList<>();
        boolean isDouble = false;
        double price = 0.0;
        try {
            price = Double.parseDouble(search);
            isDouble = true;
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
        if (isDouble){
            double finalPrice = price;
            list =  products.values().stream().filter(p -> p.getPrice() <= finalPrice).toList();
        }else{
            try {
                Category category = Category.valueOf(search.toUpperCase());
                list = products.values().stream().filter(p -> p.getCategory().equals(category)).toList();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return list;
    }
}
