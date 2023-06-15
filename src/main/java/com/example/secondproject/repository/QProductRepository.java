package com.example.secondproject.repository;

import com.example.secondproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;
import java.util.function.Predicate;

public interface QProductRepository extends
        JpaRepository<Product, Long>, QuerydslPredicateExecutor<Product> {
    Optional<Product> findOne(Predicate predicate);
}
