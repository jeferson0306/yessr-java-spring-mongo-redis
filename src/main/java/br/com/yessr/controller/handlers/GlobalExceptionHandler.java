package br.com.yessr.controller.handlers;

import br.com.yessr.domain.exceptions.InvalidDocument;
import br.com.yessr.domain.exceptions.InvalidEmail;
import br.com.yessr.domain.exceptions.InvalidPhone;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler({InvalidDocument.class, InvalidEmail.class, InvalidPhone.class})
    public ResponseEntity<String> handleValidationException(final RuntimeException e) {
        log.error("erro de validacao de dados: {}", e.getMessage());
        return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
    }
}
