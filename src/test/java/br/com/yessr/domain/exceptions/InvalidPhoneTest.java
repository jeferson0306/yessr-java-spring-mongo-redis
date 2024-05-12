package br.com.yessr.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvalidPhoneTest {

    @Test
    void testInvalidPhoneMessage() {
        final var errorMessage = "Invalid phone error message";
        final var exception = new InvalidPhone(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }

}