package br.com.yessr.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public record Purchase(String id, double amount, LocalDateTime purchaseDate) implements Serializable {
}
