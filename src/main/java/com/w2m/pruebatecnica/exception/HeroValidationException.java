package com.w2m.pruebatecnica.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class HeroValidationException {
    private final String message;
    private final HttpStatus httpStatus;
    private final LocalDateTime timestamp;
}
