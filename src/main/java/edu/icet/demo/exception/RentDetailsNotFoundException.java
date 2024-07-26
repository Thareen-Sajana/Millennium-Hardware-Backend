package edu.icet.demo.exception;

public class RentDetailsNotFoundException extends RuntimeException{

    public RentDetailsNotFoundException(String message){
        super(message);
    }
}
