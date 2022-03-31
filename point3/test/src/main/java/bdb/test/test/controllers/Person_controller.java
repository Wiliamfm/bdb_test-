package bdb.test.test.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bdb.test.test.pojos.Person;
import bdb.test.test.repositories.Person_repository;

@RestController
@RequestMapping("/persons")
@CrossOrigin
public class Person_controller {

    private Person_repository personRepository;

    @Autowired
    public void setPersonRepository(Person_repository person_repository){
        personRepository= person_repository;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPersons(){
        List<Person> persons= new ArrayList<Person>();
        personRepository.findAll().forEach(persons::add);
        return ResponseEntity.status(HttpStatus.OK).body(persons);
    }

    @GetMapping("/{fullName}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable("fullName") String fullName){
        Optional<List<Person>> optional= personRepository.findByFullName(fullName);
        List<Person> person= optional.isPresent() ? optional.get():null;
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Map<String, Object> data){
        String id= data.get("document").toString().toLowerCase().trim();
        String fullName= data.get("full_name").toString().toLowerCase().trim();
        String birth_date= data.get("birth_date").toString().toLowerCase().trim();
        String fatherDocument= "";
        String motherDocument= "";
        if(data.get("father") != null){
            fatherDocument= data.get("father").toString().toLowerCase().trim();
        }
        Optional<Person> optionalFather= personRepository.findById(fatherDocument);
        Person father= optionalFather.isPresent()? optionalFather.get():null;
        if(data.get("mother") != null){
            motherDocument= data.get("mother").toString().toLowerCase().trim();
        }
        Optional<Person> optionalMother= personRepository.findById(motherDocument);
        Person mother= optionalMother.isPresent()? optionalMother.get():null;
        Person person= personRepository.save(new Person(id, fullName, LocalDate.parse(birth_date), father, mother));
        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }
    
}
