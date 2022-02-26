package com.example.workshop_ecommerce.Product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> productNotFound(ProductNotFoundException e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        String ErrorMassage = "Product : " + e.getMessage() + " Not found";
        ApiException apiException = new ApiException(ErrorMassage, notFound, ZonedDateTime.now(ZoneId.of("Asia/Jakarta")));
        return new ResponseEntity<>(apiException,notFound);

    }
    @ExceptionHandler(ProductIDNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> productIdNotFound(ProductIDNotFoundException e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        String ErrorMassage = "Product Not found";
        ApiException apiException = new ApiException(ErrorMassage, notFound, ZonedDateTime.now(ZoneId.of("Asia/Jakarta")));
        return new ResponseEntity<>(apiException,notFound);
    }
}
