package br.com.yessr.controller.handlers;

import br.com.yessr.domain.exceptions.InvalidDocument;
import br.com.yessr.domain.exceptions.InvalidEmail;
import br.com.yessr.domain.exceptions.InvalidPhone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

    @Test
    void testHandleValidationException_InvalidDocument() {
        final var handler = new GlobalExceptionHandler();
        final var exception = new InvalidDocument("Invalid document");
        final var responseEntity = handler.handleValidationException(exception);
        assertEquals("Invalid document", responseEntity.getBody());
        assertEquals(400, responseEntity.getStatusCode().value());
    }

    @Test
    void testHandleValidationException_InvalidEmail() {
        final var handler = new GlobalExceptionHandler();
        final var exception = new InvalidEmail("Invalid email");
        final var responseEntity = handler.handleValidationException(exception);
        assertEquals("Invalid email", responseEntity.getBody());
        assertEquals(400, responseEntity.getStatusCode().value());
    }

    @Test
    void testHandleValidationException_InvalidPhone() {
        final var handler = new GlobalExceptionHandler();
        final var exception = new InvalidPhone("Invalid phone");
        final var responseEntity = handler.handleValidationException(exception);
        assertEquals("Invalid phone", responseEntity.getBody());
        assertEquals(400, responseEntity.getStatusCode().value());
    }
}
