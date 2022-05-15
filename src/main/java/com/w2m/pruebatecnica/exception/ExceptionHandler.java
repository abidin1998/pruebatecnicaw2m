package com.w2m.pruebatecnica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {HeroNotFoundException.class})
    public ResponseEntity<Object> handlerRequestException(HeroNotFoundException e) {
        HeroValidationException except = new HeroValidationException(e.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return new ResponseEntity<>(except,HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> validate(MethodArgumentNotValidException e) {
        Map<String,String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(
                f->{
                    String nombre = ((FieldError) f).getField();
                    String message = ((FieldError) f).getDefaultMessage();
                    errors.put(nombre,message);
                }
        );
        return  new ResponseEntity<>(new ValidationHeroException(errors,HttpStatus.BAD_REQUEST,
                LocalDateTime.now()),HttpStatus.BAD_REQUEST);
    }
}
