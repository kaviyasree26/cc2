package com.example.login.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.login.model.Product;
import com.example.login.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository pRepository;
    public Product saveProduct(Product product)
    {
        return pRepository.save(product);
    }

    public List<Product> getProduct()
    
    {
        return pRepository.findAll();
    }

    

    public String deleteString(Integer id) {
        pRepository.deleteById(id);
        return "deleted successfully";
    }

    public String putmethodName(Product product ,int id)
    {
        product.setId(id);
        pRepository.save(product);
        return "update";
    }
    public List<String> findPrice(double a)
    {
        return pRepository.findByProductPrice(a);
    }

    public List<Product> getBypage(int pg,int sz,String sor)
    {
        Page<Product> p =pRepository.findAll(PageRequest.of(pg, sz, Sort.by(sor)));
        return p.getContent();
    }


}
