package com.devskiller.cryptography.exception;

public class InvalidDataToDecryptException extends RuntimeException {

    public InvalidDataToDecryptException(Throwable cause) {
        super(cause);
    }


    public InvalidDataToDecryptException(String message) {
        super(message);
    }

}
