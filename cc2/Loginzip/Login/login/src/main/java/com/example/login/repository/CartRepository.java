package com.example.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login.model.CartModel;

@Repository
public interface CartRepository extends JpaRepository<CartModel,Integer>
{

    //Object findByProdName(String pname);

    //Object findByProdName(String pname);
    
}