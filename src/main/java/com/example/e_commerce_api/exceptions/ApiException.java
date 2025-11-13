package com.example.e_commerce_api.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiException extends RuntimeException {
    private final String code;

    public ApiException(String message, String code) {
        super(message); // call superclass constructor
        this.code = code;
    }
}
