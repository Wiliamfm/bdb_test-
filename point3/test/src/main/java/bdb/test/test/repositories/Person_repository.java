package bdb.test.test.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bdb.test.test.pojos.Person;

@Repository
public interface Person_repository extends CrudRepository<Person, String>{

    @Query(value = "SELECT ps FROM person ps WHERE ps.full_name = ?1")
    Optional<List<Person>> findByFullName(String fullName);

}
