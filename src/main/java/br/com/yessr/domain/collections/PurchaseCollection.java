package br.com.yessr.domain.collections;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "PURCHASE")
public record PurchaseCollection(String purchaseId, String personId, double amount, LocalDateTime purchaseDate) {
}