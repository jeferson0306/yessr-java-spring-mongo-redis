package br.com.yessr.domain.collections;

import br.com.yessr.domain.Purchase;
import br.com.yessr.domain.Tier;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonCollectionTest {

    @Test
    void testValidPersonCollection() {
        final var tier = new Tier("1", "silver", 100, "2024-05-10T00:00:05.876Z");
        final var purchase = new Purchase("1", 99, LocalDateTime.parse("2024-05-10T00:00:05.876"));
        final var personCollection = new PersonCollection("1", "Wodoa Inrer Irpledei Zeous", "17333479099", "17333479099@uol.com.br", "(11)98563-0123", tier, "Agostinho", "Sao Paulo", "Sao Paulo", "08000-000", "Brasil", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), "female", Collections.singletonList(purchase));
        assertNotNull(personCollection);
    }

}
