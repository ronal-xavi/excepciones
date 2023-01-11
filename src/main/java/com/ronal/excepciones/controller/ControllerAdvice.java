package com.ronal.excepciones.controller;

import com.ronal.excepciones.dto.ErrorDTO;
import com.ronal.excepciones.exception.BusinessException;
import com.ronal.excepciones.exception.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    // DEFINIR QUE TIPO DE EXCEPCIONES QUEREMOS CONTROLAR

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDTO>runtimeExceptionHamdler(RuntimeException ex){
     ErrorDTO errorDTO = ErrorDTO.builder().code("P-500").mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorDTO>requestExceptionHamdler(RequestException ex){
     ErrorDTO errorDTO = ErrorDTO.builder().code(ex.getCode()).mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorDTO>businessExceptionHamdler(BusinessException ex){
     ErrorDTO errorDTO = ErrorDTO.builder().code(ex.getCode()).mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, ex.getStatus());
    }







}
