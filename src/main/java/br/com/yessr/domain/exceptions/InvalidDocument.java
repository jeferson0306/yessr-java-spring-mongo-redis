package br.com.yessr.domain.exceptions;

public class InvalidDocument extends RuntimeException {

    public InvalidDocument(String message) {
        super(message);
    }

}