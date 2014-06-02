package com.healthycode.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.healthycode.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

   	@Autowired
   	private ProductService productService;

    @RequestMapping("/add/{name}/{price}")
    public String add(@PathVariable String name,@PathVariable double price) {
        productService.addProduct(name,"",price);
        return "Added succesfully";
    }
}