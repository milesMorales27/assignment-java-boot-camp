package com.example.workshop_ecommerce.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products/")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void insertProduct(){
        Product[] products = new Product[5];
        products[0] = new Product("AMD","Sport Shoe",4500,300,50);
        products[1] = new Product("Yeezy","Sneaker",6500,1000,10);
        products[2] = new Product("Jordan","Sport Shore",5500,200,20);
        products[3] = new Product("992 ","Sneaker",8900,0,32);
        products[4] = new Product("Converse","Casual Shore",3500,200,28);
        for (int i = 0; i < products.length; i ++) {
            productRepository.save(products[i]);
        }
    }

    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Product> GetAllProduct(){
        return productService.getAllProduct();
    }
    @GetMapping("/search/{name}")
    public List<Product> GetProduct(@PathVariable String name){
        return productService.searchProduct(name);
    }
    @GetMapping("/id/{id}")
    public Product GetProduct(@PathVariable int id){
        return productService.getProductById(id);
    }
}
