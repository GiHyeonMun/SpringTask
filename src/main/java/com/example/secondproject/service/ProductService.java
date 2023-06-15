package com.example.secondproject.service;

import com.example.secondproject.dto.ProductDto;
import com.example.secondproject.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto getProduct(Long number);
    List<ProductResponseDto> getProductByName(String name);
    Long countByPrice(int price);
    boolean existsByNumber(Long number);
    ProductResponseDto getProductByNameAndPrice(String name, int price);
    List<ProductResponseDto> listProductByName(String name);
    List<ProductResponseDto> getListAllProductByPriceAsc();
    ProductResponseDto saveProduct(ProductDto productDto);
    List<ProductResponseDto> listByStock(int stock);
    List<ProductResponseDto> allProduct();
    ProductResponseDto changeProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;
}
