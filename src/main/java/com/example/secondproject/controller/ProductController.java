package com.example.secondproject.controller;

import com.example.secondproject.dto.ProductDto;
import com.example.secondproject.dto.ProductResponseDto;
import com.example.secondproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-api")
public class ProductController {
    public final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*@PostMapping("/product")
    public ProductDto product
            (@RequestParam String name,
             @RequestParam int price,
             @RequestParam int stock) {
        ProductResponseDto
    }*/
}
