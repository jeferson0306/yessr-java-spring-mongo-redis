package br.com.yessr.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvalidEmailTest {

    @Test
    void testInvalidEmailMessage() {
        final var errorMessage = "Invalid email error message";
        final var exception = new InvalidEmail(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }

}