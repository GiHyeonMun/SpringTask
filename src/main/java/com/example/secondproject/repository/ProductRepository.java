package com.example.secondproject.repository;

import com.example.secondproject.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name, Sort sort);

    Long countByPrice(int Price);

    boolean existsByNumber(Long number);

    Product findByNameAndPrice(String name, int price);

    List<Product> findByNameOrderByPriceDesc(String name);

    List<Product> findAllByOrderByPriceAsc();

    @Query("SELECT p FROM Product AS p WHERE p.stock = :stock")
    List<Product> listByStock(@Param("stock") int stock);
}
