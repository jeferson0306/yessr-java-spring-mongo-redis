package br.com.yessr.domain;

import java.io.Serializable;

public record Tier(String id, String name, double averagePurchasePrice, String purchaseDate) implements Serializable {
}
