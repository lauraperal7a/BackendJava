package com.example.clinicaOdontologica.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DniException.class)
    public ResponseEntity<?> DniException(Exception ex, WebRequest req){

        logger.error(ex.getMessage());
        return new ResponseEntity("DNI ya registrado", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest req){

        logger.error(ex.getMessage());
        return new ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
