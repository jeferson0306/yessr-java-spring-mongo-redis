package br.com.yessr.controller;

import br.com.yessr.domain.Person;
import br.com.yessr.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testSaveOrUpdateCustomer() {
        final var person = createSamplePerson();
        when(customerService.saveOrUpdateCustomer(any(Person.class))).thenReturn(person);
        final var responseEntity = customerController.saveOrUpdateCustomer(person);
        assertEquals(OK, responseEntity.getStatusCode());
        assertEquals(person, responseEntity.getBody());
    }

    @Test
    void testGetCustomerByDocument() {
        final var document = "17333479099";
        final var person = createSamplePerson();
        when(customerService.getCustomerByDocument(document)).thenReturn(Optional.of(person));
        final var responseEntity = customerController.getCustomerByDocument(document);
        assertEquals(OK, responseEntity.getStatusCode());
        assertEquals(person, responseEntity.getBody());
    }

    private Person createSamplePerson() {
        return new Person("Wodoa Inrer Irpledei Zeous", "17333479099", "17333479099@uol.com.br", "(11)98563-0123", null, "Agostinho", "Sao Paulo", "Sao Paulo", "08000-000", "Brasil", LocalDateTime.now(), LocalDateTime.now(), "female", null);
    }

    @Test
    void testGetCustomerByDocument_CustomerNotFound() {
        final var document = "78348970045";
        when(customerService.getCustomerByDocument(anyString())).thenReturn(empty());
        final var responseEntity = customerController.getCustomerByDocument(document);
        assertEquals(NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }
}
