package com.example.workshop_ecommerce.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.ElementCollection;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProduct(){
        List<Product> res =  productRepository.findAll();
        return res;
    }
    public List<Product> searchProduct(String text){
        List<Product> productResult =  productRepository.findByNameContainingIgnoreCase(text);
        if(!productResult.isEmpty()){
            return productResult;
        }
        throw new ProductNotFoundException(text);
    }
    public Product getProductById(int id){
        Optional<Product> result = productRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new ProductIDNotFoundException(id);
    }
}
