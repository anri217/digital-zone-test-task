package com.anri.digitalzonetesttask.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionsHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        ControllerException controllerException  = new ControllerException("Malformed JSON request");
        return new ResponseEntity<>(controllerException, status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        ControllerException controllerException = new ControllerException("Arguments are not valid");
        return new ResponseEntity<>(controllerException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAllExceptions() {
        ControllerException controllerException = new ControllerException("Internal Server Error");
        return new ResponseEntity<>(controllerException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
