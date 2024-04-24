package com.example.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.model.Product;
import com.example.login.model.ProductDescription;
import com.example.login.repository.ProductDescriptionrepo;
import com.example.login.service.ProductDescriptionser;
import com.example.login.service.ProductService;




@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
   private ProductDescriptionser productDescriptionser;
   @Autowired
   public ProductDescriptionrepo productDescriptionrepo;
   @Autowired
    private ProductService pService;
    public ProductController(ProductService pService)
    {
        this.pService=pService;
    }

    @PostMapping("/post")
    public Product postMethodName(@RequestBody Product product ) {
        
       return pService.saveProduct(product);
        

    }
    @GetMapping("/path")
    public List<Product> getMethodName() {
        return pService.getProduct() ;
    }
    
   @PutMapping("/product/{id}")
   public String putMethodName( @RequestBody Product uProduct,@PathVariable int id) {
    pService.putmethodName(uProduct,id);
    return "update";

   }

@DeleteMapping("/product/{id}")
public String deleteString(@PathVariable Integer id)
{
     return pService.deleteString(id);
}


    @PostMapping("/postd")
    public String postMethodName(@RequestBody ProductDescription productDescription)
    {
        productDescriptionser.savepro(productDescription);
        return "saved";
    }


@GetMapping("/product/Byprice")
public ResponseEntity<List<String>> getProduct(@RequestParam double price)
{
     List<String> s = pService.findPrice(price);
     if(s!=null)
     {
        return new ResponseEntity<>(s,HttpStatus.FOUND);
     }
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

@GetMapping("/pages/{pg}/{sz}/{field}")
public List<Product> getsPage(@PathVariable("pg") int a,@PathVariable("sz") int b,@PathVariable("field") String c)
{
    return pService.getBypage(a, b, c);
}

}
