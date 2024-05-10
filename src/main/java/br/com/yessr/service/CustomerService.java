package br.com.yessr.service;

import br.com.yessr.domain.Person;
import br.com.yessr.domain.collections.PersonCollection;
import br.com.yessr.repository.PersonRepository;
import br.com.yessr.utilty.ValidationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final PersonRepository personRepository;

    @CachePut(value = "customer", key = "#person.document")
    public Person saveOrUpdateCustomer(final Person person) {
        log.info("starting saving or updating customer data {}", person);
        validationPersonalData(person);
        final var personCollection = getPersonCollection(person);
        personRepository.save(personCollection);
        log.info("finishing saving or updating customer data for document {}", person.document());
        return convertToDomainModel(personCollection);
    }

    private void validationPersonalData(final Person person) {

        log.info("starting validation for document: {}, email: {}, phone: {}", person.document(), person.email(), person.phone());

        if (!ValidationUtils.isValidCPF(person.document())) {
            log.error("invalid document: {}", person.document());
            throw new IllegalArgumentException("Invalid document");
        }

        if (!ValidationUtils.isValidEmail(person.email())) {
            log.error("invalid email: {}", person.email());
            throw new IllegalArgumentException("Invalid email");
        }

        if (!ValidationUtils.isValidPhone(person.phone())) {
            log.error("invalid phone: {}", person.phone());
            throw new IllegalArgumentException("Invalid phone");
        }

        log.info("validation completed for document: {}, email: {}, phone: {}", person.document(), person.email(), person.phone());
    }

    private PersonCollection getPersonCollection(final Person person) {
        log.info("fetching customer data in database with document: {}", person.document());
        return personRepository.findByDocument(person.document()).map(existing -> new PersonCollection(existing.id(), person.name(), person.document(), person.email(), person.phone(), person.tier(), person.address(), person.city(), person.state(), person.zipCode(), person.country(), existing.createdAt(), LocalDateTime.now(), existing.birthDate(), person.gender(), person.purchases())).orElseGet(() -> new PersonCollection(null, person.name(), person.document(), person.email(), person.phone(), person.tier(), person.address(), person.city(), person.state(), person.zipCode(), person.country(), LocalDateTime.now(), LocalDateTime.now(), person.birthDate(), person.gender(), person.purchases()));
    }

    private Person convertToDomainModel(final PersonCollection personCollection) {
        log.info("converting customer data to domain model: {}", personCollection);
        return new Person(personCollection.name(), personCollection.document(), personCollection.email(), personCollection.phone(), personCollection.tier(), personCollection.address(), personCollection.city(), personCollection.state(), personCollection.zipCode(), personCollection.country(), personCollection.updatedAt(), personCollection.birthDate(), personCollection.gender(), personCollection.purchases());
    }

    @Cacheable(value = "customer", key = "#document")
    public Optional<Person> getCustomerByDocument(final String document) {
        log.info("fetching customer with document: {}", document);
        return personRepository.findByDocument(document).map(personCollection -> {
            log.info("customer data retrieved from database for document {}", document);
            return convertToDomainModel(personCollection);
        });
    }

}
