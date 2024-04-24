package com.example.login.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.login.model.LoginModel;
import com.example.login.repository.LoginRepository;

@Service
public class LoginService {
    
    private LoginRepository LoginRepository;
    public LoginService(LoginRepository LoginRepository)
    {
        this.LoginRepository=LoginRepository;
    }
    public List<LoginModel> gModels(){
        return LoginRepository.findAll();
    }
    public LoginModel create(@RequestBody LoginModel m)
    {
        LoginRepository.save(m); 
        return m;

   }
    public LoginModel get(Integer id)
    {
        return LoginRepository.findById(id).orElse(null); 
    }
    public String delete(Integer id) { 
        LoginRepository.deleteById(id); 
        return "deleted successfully"; 
        } 
        public String update(LoginModel m, Integer id) { 
            m.setId(id); 
            LoginRepository.save(m); 
            return "updated";
        }

        public Page<LoginModel> pagenationSort(int pg, int si) {
           
            return LoginRepository.findAll(PageRequest.of(pg, si));
        }
        public Page<LoginModel> pagenation(int pg, int si) {
            
            return LoginRepository.findAll(PageRequest.of(pg, si));
        }
}
