package br.com.yessr.domain.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TierCollectionTest {

    @Test
    void testValidTierCollection() {
        final var tier = new TierCollection("1", "1", "silver", 100, "2024-05-10T00:00:05.876Z");
        assertNotNull(tier);
    }

}
