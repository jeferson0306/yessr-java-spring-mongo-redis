package br.com.yessr.domain;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@NotNull
public record Person(String name, @NotNull String document, String email, String phone, Tier tier, String address,
                     String city, String state, String zipCode, String country, LocalDateTime updatedAt,
                     LocalDateTime birthDate, String gender, List<Purchase> purchases) implements Serializable {
}
