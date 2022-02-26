package com.example.workshop_ecommerce.User;

import com.example.workshop_ecommerce.Product.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class UserControllerAdvice {
    @ExceptionHandler(UserIDNotFoundException.class)
    @ResponseBody
    public ResponseEntity<Object> productNotFound(UserIDNotFoundException e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        String ErrorMassage = "UserId : " + e.getMessage() + " Not found";
        ApiException apiException = new ApiException(ErrorMassage, notFound, ZonedDateTime.now(ZoneId.of("Asia/Jakarta")));
        return new ResponseEntity<>(apiException,notFound);
    }
}
