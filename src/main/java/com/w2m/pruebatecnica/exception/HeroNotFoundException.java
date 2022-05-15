package com.w2m.pruebatecnica.exception;

public class HeroNotFoundException extends RuntimeException{
    public HeroNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
