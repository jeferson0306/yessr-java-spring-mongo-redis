package br.com.yessr.domain.collections;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TIER")
public record TierCollection(String tierId, String personId, String name, double averagePurchasePrice,
                             String purchaseDate) {
}

