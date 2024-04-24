package com.example.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.model.CartModel;
import com.example.login.service.CartService;

@RestController
public class CartController {
   @Autowired
    CartService cartService;

    @PostMapping("/post")
    public CartModel addItem(@RequestBody CartModel cartModel)
    {
      
       return cartService.addItems(cartModel);
    }
    @GetMapping("/get")
    public List<CartModel> getItem()
    {
      return cartService.getItems();
    }
    @PutMapping("put/{id}")
    public CartModel updateItem(@PathVariable("id") int pid,@RequestBody CartModel cm)
    {
      
      return cartService.updateItems(pid,cm);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable int id)
    {
      cartService.deleteItems(id);
    }
}

