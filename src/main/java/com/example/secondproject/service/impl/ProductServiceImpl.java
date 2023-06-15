package com.example.secondproject.service.impl;

import com.example.secondproject.dao.ProductDAO;
import com.example.secondproject.dto.ProductDto;
import com.example.secondproject.dto.ProductResponseDto;
import com.example.secondproject.entity.Product;
import com.example.secondproject.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDao;

    public ProductServiceImpl(ProductDAO productDao) {
        this.productDao = productDao;
    }


    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDao.selectProduct(number);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(product.getName());
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }

    @Override
    public List<ProductResponseDto> getProductByName(String name) {
        List<Product> product = productDao.selectProductByName(name);
        List<ProductResponseDto> productResponseDtoList = product.stream().
                map(ProductResponseDto::new).collect(Collectors.toList());
        return productResponseDtoList;
    }

    @Override
    public List<ProductResponseDto> listByStock(int stock) {
        List<Product> product = productDao.listByStock(stock);
        List<ProductResponseDto> productResponseDtoList = product.stream().
                map(ProductResponseDto::new).collect(Collectors.toList());
        return productResponseDtoList;
    }

    @Override
    public List<ProductResponseDto> allProduct() {
        List<Product> product = productDao.allProduct();
        List<ProductResponseDto> productResponseDtoList = product.stream().
                map(ProductResponseDto::new).collect(Collectors.toList());
        return productResponseDtoList;
    }

    public Long countByPrice(int price) {
        return productDao.countByPrice(price);
    }

    @Override
    public boolean existsByNumber(Long number) {
        return productDao.existsByNumber(number);
    }

    @Override
    public ProductResponseDto getProductByNameAndPrice(String name, int price) {
        Product product = productDao.selectProductByNameAndPrice(name, price);
        return new ProductResponseDto(product);
    }

    @Override
    public List<ProductResponseDto> getListAllProductByPriceAsc() {
        List<Product> products = productDao.listAllProductByName();
        List<ProductResponseDto> productResponseDtoList = products.stream().
                map(ProductResponseDto::new).collect(Collectors.toList());
        return productResponseDtoList;
    }

    @Override
    public List<ProductResponseDto> listProductByName(String name) {
        List<Product> products = productDao.listProductByName(name);
        List<ProductResponseDto> productResponseDtoList = products.stream().
                map(ProductResponseDto::new).collect(Collectors.toList());
        return productResponseDtoList;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product saveProduct = productDao.insertProduct(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(saveProduct.getName());
        productResponseDto.setNumber(saveProduct.getNumber());
        productResponseDto.setPrice(saveProduct.getPrice());
        productResponseDto.setStock(saveProduct.getStock());
        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product changeProduct = productDao.updateProductName(number, name);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(changeProduct.getNumber());
        productResponseDto.setName(changeProduct.getName());
        productResponseDto.setPrice(changeProduct.getPrice());
        productResponseDto.setStock(changeProduct.getStock());
        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDao.deleteProduct(number);
    }
}