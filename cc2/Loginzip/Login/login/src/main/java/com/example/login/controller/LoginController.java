package com.example.login.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.model.LoginModel;
import com.example.login.service.LoginService;


@RestController
@RequestMapping("/log")
public class LoginController {
    private LoginService LoginService;
    public LoginController( LoginService LoginService)
    {
        this.LoginService=LoginService;
    }
    
    @GetMapping("/login")
    public List <LoginModel> display(){
        return LoginService.gModels();
    }

    @GetMapping("/login/{id}")
    public LoginModel display(@PathVariable Integer id){
        return LoginService.get(id);
    }
    
    @GetMapping("/login/{pg}/{si}")
    public Page<LoginModel> getMethodName(@PathVariable("pg") int pg, @PathVariable("si") int si) {
        return LoginService.pagenation(pg,si);
    }

    @PostMapping("/login")
    public LoginModel create(@RequestBody LoginModel m)
    {
        return LoginService.create(m);

    }
    @PutMapping("/login/{id}")
    public ResponseEntity <String>update(@RequestBody LoginModel m,@PathVariable Integer id){
         LoginService.update(m, id);
         return new ResponseEntity<>("Updated",HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/login/{id}")
    public String delete(@PathVariable Integer id)
    {
        return LoginService.delete(id);
    }

}