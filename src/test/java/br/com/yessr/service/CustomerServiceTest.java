package br.com.yessr.service;

import br.com.yessr.domain.Person;
import br.com.yessr.domain.collections.PersonCollection;
import br.com.yessr.domain.exceptions.InvalidDocument;
import br.com.yessr.domain.exceptions.InvalidEmail;
import br.com.yessr.domain.exceptions.InvalidPhone;
import br.com.yessr.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private CustomerService customerService;

    private static Person createSamplePerson() {
        final var updatedAt = LocalDateTime.of(2024, 5, 12, 0, 45, 23, 736242400);
        final var birthDate = LocalDateTime.of(2024, 5, 12, 0, 42, 52, 37881900);
        return new Person("Wodoa Inrer Irpledei Zeous", "17333479099", "17333479099@uol.com.br", "(11)98563-0123", null, "Agostinho", "Sao Paulo", "Sao Paulo", "08000-000", "Brasil", updatedAt, birthDate, "female", null);
    }

    private static Person createSamplePerson_WithInvalidDocument() {
        final var updatedAt = LocalDateTime.of(2024, 5, 12, 0, 45, 23, 736242400);
        final var birthDate = LocalDateTime.of(2024, 5, 12, 0, 42, 52, 37881900);
        return new Person("Wodoa Inrer Irpledei Zeous", "123", "17333479099@uol.com.br", "(11)98563-0123", null, "Agostinho", "Sao Paulo", "Sao Paulo", "08000-000", "Brasil", updatedAt, birthDate, "female", null);
    }

    private static Person createSamplePerson_WithInvalidEmail() {
        final var updatedAt = LocalDateTime.of(2024, 5, 12, 0, 45, 23, 736242400);
        final var birthDate = LocalDateTime.of(2024, 5, 12, 0, 42, 52, 37881900);
        return new Person("Wodoa Inrer Irpledei Zeous", "17333479099", "17333479099uol.com.", "(-0123", null, "Agostinho", "Sao Paulo", "Sao Paulo", "08000-000", "Brasil", updatedAt, birthDate, "female", null);
    }

    private static Person createSamplePerson_WithInvalidPhone() {
        final var updatedAt = LocalDateTime.of(2024, 5, 12, 0, 45, 23, 736242400);
        final var birthDate = LocalDateTime.of(2024, 5, 12, 0, 42, 52, 37881900);
        return new Person("Wodoa Inrer Irpledei Zeous", "17333479099", "17333479099@uol.com.br", "(-0123", null, "Agostinho", "Sao Paulo", "Sao Paulo", "08000-000", "Brasil", updatedAt, birthDate, "female", null);
    }

    private static Person convertToPerson(PersonCollection personCollection) {
        return new Person(personCollection.name(), personCollection.document(), personCollection.email(), personCollection.phone(), personCollection.tier(), personCollection.address(), personCollection.city(), personCollection.state(), personCollection.zipCode(), personCollection.country(), personCollection.updatedAt(), personCollection.birthDate(), personCollection.gender(), personCollection.purchases());
    }

    private static PersonCollection getDefaultPersonCollection() {
        final var createdAt = LocalDateTime.of(2024, 5, 12, 0, 0, 0, 0);
        final var updatedAt = LocalDateTime.of(2024, 5, 12, 0, 45, 23, 736242400);
        final var birthDate = LocalDateTime.of(2024, 5, 12, 0, 42, 52, 37881900);
        return new PersonCollection("Default Name", "Default Document", "Default Email", "Default Phone", null, "Default Address", "Default City", "Default State", "Default ZipCode", "Default Country", createdAt, updatedAt, birthDate, "Default Gender", null);
    }

    private static PersonCollection getDefaultPersonCollectionWithData() {
        final var createdAt = LocalDateTime.of(2024, 5, 12, 0, 0, 0, 0);
        final var updatedAt = LocalDateTime.of(2024, 5, 12, 0, 45, 23, 736242400);
        final var birthDate = LocalDateTime.of(2024, 5, 12, 0, 42, 52, 37881900);
        return new PersonCollection("Wodoa Inrer Irpledei Zeous", "17333479099", "17333479099@uol.com.br", "(11)98563-0123", null, "Agostinho", "Sao Paulo", "Sao Paulo", "08000-000", "Brasil", createdAt, updatedAt, birthDate, "female", null);
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetCustomerByDocument() {
        final var document = "17333479099";
        final var defaultPersonCollection = getDefaultPersonCollection();
        when(personRepository.findByDocument(document)).thenReturn(of(defaultPersonCollection));
        final var retrievedPersonOptional = customerService.getCustomerByDocument(document);
        final var expectedPerson = convertToPerson(defaultPersonCollection);
        assertEquals(expectedPerson, retrievedPersonOptional.orElse(null));
    }

    @Test
    void testGetCustomerByDocument_WithReturnDifferent() {
        final var document = "17333479099";
        final var defaultPersonCollection = getDefaultPersonCollection();
        when(personRepository.findByDocument(document)).thenReturn(of(defaultPersonCollection));
        final var retrievedPersonOptional = customerService.getCustomerByDocument(document);
        final var expectedPerson = createSamplePerson();
        assertNotEquals(expectedPerson, retrievedPersonOptional.orElse(null));
    }

    @Test
    void testValidationPersonalData_InvalidCPF() {
        final var person = createSamplePerson_WithInvalidDocument();
        assertThrows(InvalidDocument.class, () -> customerService.validationPersonalData(person));
    }

    @Test
    void testValidationPersonalData_InvalidEmail() {
        final var person = createSamplePerson_WithInvalidEmail();
        assertThrows(InvalidEmail.class, () -> customerService.validationPersonalData(person));
    }

    @Test
    void testValidationPersonalData_InvalidPhone() {
        final var person = createSamplePerson_WithInvalidPhone();
        assertThrows(InvalidPhone.class, () -> customerService.validationPersonalData(person));
    }

    @Test
    void testGetPersonCollection_NonExistingPerson() {
        final var person = createSamplePerson();
        final var result = customerService.getPersonCollection(person);
        assertEquals(person.name(), result.name());
        assertEquals(person.document(), result.document());
        assertEquals(person.email(), result.email());
        assertEquals(person.phone(), result.phone());
        assertEquals(person.tier(), result.tier());
        assertEquals(person.address(), result.address());
        assertEquals(person.city(), result.city());
        assertEquals(person.state(), result.state());
        assertEquals(person.zipCode(), result.zipCode());
        assertEquals(person.country(), result.country());
        assertEquals(person.birthDate(), result.birthDate());
    }

    @Test
    void testSaveOrUpdateCustomer() {
        final var person = createSamplePerson();
        final var existingPersonCollection = getDefaultPersonCollectionWithData();
        when(personRepository.findByDocument(person.document())).thenReturn(of(existingPersonCollection));
        when(personRepository.save(any(PersonCollection.class))).thenReturn(existingPersonCollection);
        final var result = customerService.saveOrUpdateCustomer(person);
        verify(personRepository, times(1)).findByDocument(person.document());
        verify(personRepository, times(1)).save(any(PersonCollection.class));
        assertEquals(existingPersonCollection.name(), result.name());

    }

}
