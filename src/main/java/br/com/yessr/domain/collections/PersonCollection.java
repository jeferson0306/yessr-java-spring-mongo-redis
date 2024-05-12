package br.com.yessr.domain.collections;

import br.com.yessr.domain.Purchase;
import br.com.yessr.domain.Tier;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "PERSON")
public record PersonCollection(@Id String id, String name, String document, String email, String phone, Tier tier,
                               String address, String city, String state, String zipCode, String country,
                               LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime birthDate, String gender,
                               List<Purchase> purchases) {

    public PersonCollection(String name, String document, String email, String phone, Tier tier, String address, String city, String state, String zipCode, String country, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime birthDate, String gender, List<Purchase> purchases) {
        this(null, name, document, email, phone, tier, address, city, state, zipCode, country, createdAt, updatedAt, birthDate, gender, purchases);
    }

}
