package br.com.yessr.domain.collections;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PurchaseCollectionTest {

    @Test
    void testValidPurchaseCollection() {
        final var purchase = new PurchaseCollection("1", "1", 99, LocalDateTime.parse("2024-05-10T00:00:05.876"));
        assertNotNull(purchase);
    }

}