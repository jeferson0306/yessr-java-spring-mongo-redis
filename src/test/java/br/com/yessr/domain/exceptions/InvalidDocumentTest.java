package br.com.yessr.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvalidDocumentTest {

    @Test
    void testInvalidDocumentMessage() {
        final var errorMessage = "Invalid document error message";
        final var exception = new InvalidDocument(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
