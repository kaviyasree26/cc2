package com.example.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.model.CartModel;
import com.example.login.repository.CartRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    CartModel cartModel;

    public CartModel addItems(CartModel cartModel)
    {
       return cartRepository.save(cartModel);
    }
    public List<CartModel> getItems()
    {
       return cartRepository.findAll();
    }
    public CartModel updateItems(int pid,CartModel cartm)
    {
       CartModel check=cartRepository.findById(pid).orElse(null);
       if(check!=null)
       {
          //check.setProdId(prodId);
          check.setProdName(cartm.getProdName());
          check.setProdQuantity(cartm.getProdQuantity());
          return cartRepository.saveAndFlush(check);
       }
       else 
        return null;
    }
    public void deleteItems(int pid)
    {
       cartRepository.deleteById(pid);
    }
}

