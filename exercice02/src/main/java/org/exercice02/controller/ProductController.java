package org.exercice02.controller;


import org.exercice02.model.Product;
import org.exercice02.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/detail/{productId}")
    public String detail(@PathVariable("productId") UUID productId, Model model) {
        Product product = productService.getProduct(productId);
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "search") String search, Model model) {
        List<Product> products = productService.searchProducts(search);

        if (products.isEmpty()){
            return "home";
        }else{
            model.addAttribute("products", products);
            return "list";
        }

    }
}
