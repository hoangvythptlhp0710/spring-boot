package com.learning.SpringBoot.controller;
// bao nhieu request thi se co bay nhieu method

import com.learning.SpringBoot.models.Product;
import com.learning.SpringBoot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products") //ánh xạ các request
public class ProductController {
    //DI = Dependency Injection
    @Autowired //doi tuong (Product Repository) se duoc tao ra ngay khi chuong trinh duoc tao => tao 1 lan duy nhat va duy tri trong suot qua trinh chay
    private ProductRepository productRepository;

    @GetMapping("")
    //this request is: http://localhost:8081/api/v1/products
    List<Product> getAllProducts(){
        return productRepository.findAll();
        // You can also send request by Postman
    }

    //get detail products
    @GetMapping("/{id}")
    Product findById(@PathVariable Long id){
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Cannot find product with id = " + id));
    }
}
