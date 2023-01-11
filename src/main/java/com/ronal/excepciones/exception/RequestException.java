package com.ronal.excepciones.exception;

import lombok.Getter;

@Getter
public class RequestException extends RuntimeException{
    private final  String  code;

    public RequestException(String message,String code) {
        super(message);
        this.code = code;
    }
}
