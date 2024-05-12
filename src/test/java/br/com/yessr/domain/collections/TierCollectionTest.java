package br.com.yessr.domain.collections;

import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.mapping.Document;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TierCollectionTest {

    @Test
    void testValidTierCollection() {
        final var tier = new TierCollection("1", "1", "silver", 100, "2024-05-10T00:00:05.876Z");
        assertNotNull(tier);
    }

}