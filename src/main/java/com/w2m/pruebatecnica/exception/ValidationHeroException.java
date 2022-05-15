package com.w2m.pruebatecnica.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ValidationHeroException {
    Map<String,String> errors;
    private final HttpStatus httpStatus;
    private final LocalDateTime timestamp;
}
