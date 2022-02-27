package com.example.workshop_ecommerce.Cart;

import com.example.workshop_ecommerce.ExceptionModel.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class CartConreollerAdvice {
    @ExceptionHandler(CartNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> CartNotFound(CartNotFoundException e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        String ErrorMassage = "Cart Not Found";
        ApiException apiException = new ApiException(ErrorMassage, notFound, ZonedDateTime.now(ZoneId.of("Asia/Jakarta")));
        return new ResponseEntity<>(apiException,notFound);

    }

    @ExceptionHandler(CartItemNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> CartItemNotFound(CartItemNotFoundException e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        String ErrorMassage = e.getMessage();
        ApiException apiException = new ApiException(ErrorMassage, notFound, ZonedDateTime.now(ZoneId.of("Asia/Jakarta")));
        return new ResponseEntity<>(apiException,notFound);

    }
}
