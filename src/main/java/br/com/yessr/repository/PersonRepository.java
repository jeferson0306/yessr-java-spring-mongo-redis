package br.com.yessr.repository;

import br.com.yessr.domain.collections.PersonCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends MongoRepository<PersonCollection, String> {

    Optional<PersonCollection> findById(String id);
    Optional<PersonCollection> findByDocument(String document);

}
