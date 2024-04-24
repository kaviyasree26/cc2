package com.example.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.login.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select n.name from Product  n where productPrice = ?1")
    List<String> findByProductPrice(double a);
}
