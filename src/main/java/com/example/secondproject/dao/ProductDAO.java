package com.example.secondproject.dao;

import com.example.secondproject.entity.Product;

import java.util.List;

public interface ProductDAO {
    Product insertProduct(Product product);
    List<Product> selectProductByName(String name);
    Product selectProduct(Long number);
    Long countByPrice(int price);
    boolean existsByNumber(Long number);
    Product selectProductByNameAndPrice(String name, int price);
    List<Product> listProductByName(String name);
    List<Product> listAllProductByName();
    List<Product> allProduct();
    List<Product> listByStock(int stock);
    Product updateProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;
}
