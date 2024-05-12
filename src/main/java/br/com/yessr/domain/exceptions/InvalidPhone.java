package br.com.yessr.domain.exceptions;

public class InvalidPhone extends RuntimeException {

    public InvalidPhone(String message) {
        super(message);
    }

}