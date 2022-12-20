package com.herb.bankapp.handler;

import com.herb.bankapp.dto.response.ExceptionResponseDTO;
import com.herb.bankapp.error.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException exception) {
        ExceptionResponseDTO error = new ExceptionResponseDTO();
        error.setError(CustomException.class.getSimpleName());
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException() {
        ExceptionResponseDTO error = new ExceptionResponseDTO();
        error.setError(Exception.class.getSimpleName());
        error.setMessage("Unknown error");
        error.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
