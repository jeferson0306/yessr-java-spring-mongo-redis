package br.com.yessr.controller;

import br.com.yessr.domain.Person;
import br.com.yessr.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<Person> saveOrUpdateCustomer(@RequestBody final Person person) {
        log.info("......starts the process to save or update customer {}", person);
        final var customer = customerService.saveOrUpdateCustomer(person);
        log.info("finishes the process to save or update customer {}", person);
        return ok(customer);
    }

    @GetMapping("/{document}")
    public ResponseEntity<Person> getCustomerByDocument(@PathVariable final String document) {
        log.info("......starts fetching customer data with document: {}", document);
        return customerService.getCustomerByDocument(document).map(ResponseEntity::ok).orElseGet(() -> {
            log.info("finishes fetching customer with no one found for document {}", document);
            return notFound().build();
        });
    }
}
