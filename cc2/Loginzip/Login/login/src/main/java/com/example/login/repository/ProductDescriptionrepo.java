package com.example.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login.model.ProductDescription;

@Repository
public interface ProductDescriptionrepo extends JpaRepository<ProductDescription,Integer>{

    // ProductDescription findByDescriptionEndsWith(String description);
}
