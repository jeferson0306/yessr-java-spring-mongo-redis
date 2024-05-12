package br.com.yessr.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class PersonTest {

    @Test
    void testValidPerson() {
        final var tier = new Tier("1", "silver", 100, "2024-05-10T00:00:05.876Z");
        final var purchase = new Purchase("1", 99, LocalDateTime.parse("2024-05-10T00:00:05.876"));
        final var person = new Person("Wodoa Inrer Irpledei Zeous", "17333479099", "17333479099@uol.com.br", "(11)98563-0123", tier, "Agostinho", "Sao Paulo", "Sao Paulo", "08000-000", "Brasil", LocalDateTime.parse("2024-05-10T00:00:05.876"), LocalDateTime.parse("2024-05-10T00:00:05.876"), "female", Collections.singletonList(purchase));
        assertNotNull(person);
    }

    @Test
    void testNullDocument() {
        final var tier = new Tier("1", "silver", 100, "2024-05-10T00:00:05.876Z");
        final var purchase = new Purchase("1", 99, LocalDateTime.parse("2024-05-10T00:00:05.876"));
        final var person = new Person("Wodoa Inrer Irpledei Zeous", null, "17333479099@uol.com.br", "(11)98563-0123", tier, "Agostinho", "Sao Paulo", "Sao Paulo", "08000-000", "Brasil", LocalDateTime.parse("2024-05-10T00:00:05.876"), LocalDateTime.parse("2024-05-10T00:00:05.876"), "female", Collections.singletonList(purchase));
        assertNotNull(tier);
        assertNotNull(purchase);
        assertNotNull(person);
        assertNull(person.document());
    }

}