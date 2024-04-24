package com.example.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.model.ProductDescription;
import com.example.login.repository.ProductDescriptionrepo;

@Service
public class ProductDescriptionser {
    @Autowired
    private ProductDescriptionrepo productDescriptionrepo;


    public ProductDescription savepro(ProductDescription productDescription)
    {
        return productDescriptionrepo.save(productDescription);
    }
}
