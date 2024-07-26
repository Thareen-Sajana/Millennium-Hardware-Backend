package edu.icet.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException ex){

        HttpStatusCode statusCode = HttpStatus.BAD_REQUEST;
        String errorMessage = ex.getMessage();

        ErrorResponse build =
                ErrorResponse.builder(ex, statusCode, errorMessage).build();
        return ResponseEntity.ok().body(build);
    }

    @ExceptionHandler(RentDetailsNotFoundException.class)
    ResponseEntity<ErrorResponse> handelRentDetailsNotFoundException(RentDetailsNotFoundException ex){

        HttpStatusCode statusCode = HttpStatus.BAD_REQUEST;
        String errorMessage = ex.getMessage();

        ErrorResponse build =
                ErrorResponse.builder(ex, statusCode, errorMessage).build();
        return ResponseEntity.ok().body(build);
    }
}
