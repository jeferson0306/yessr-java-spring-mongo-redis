package br.com.yessr.domain.exceptions;

public class InvalidEmail extends RuntimeException {

    public InvalidEmail(String message) {
        super(message);
    }

}