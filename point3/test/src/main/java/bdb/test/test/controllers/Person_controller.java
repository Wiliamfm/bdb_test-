package bdb.test.test.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bdb.test.test.pojos.Person;
import bdb.test.test.services.PersonService;

@RestController
@RequestMapping("/persons")
@CrossOrigin
public class Person_controller {

    private PersonService personService;

    @Autowired
    public void setPersonRepository(PersonService personService){
        this.personService= personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPersons(){
        List<Person> persons= personService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(persons);
    }

    @GetMapping("/{fullName}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable("fullName") String fullName){
        List<Person> persons= personService.findByFullName(fullName);
        return ResponseEntity.status(HttpStatus.OK).body(persons);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Map<String, Object> data){
        try{
            String id= data.get("document").toString().toLowerCase().trim();
            String fullName= data.get("full_name").toString().toLowerCase().trim();
            String birth_date= data.get("birth_date").toString().toLowerCase().trim();
            String fatherDocument= "";
            String motherDocument= "";
            if(data.get("father") != null){
                fatherDocument= data.get("father").toString().toLowerCase().trim();
            }
            Person father= personService.findById(fatherDocument);
            if(data.get("mother") != null){
                motherDocument= data.get("mother").toString().toLowerCase().trim();
            }
            Person mother= personService.findById(motherDocument);
            Person person= personService.save(new Person(id, fullName, LocalDate.parse(birth_date), father, mother));
            return ResponseEntity.status(HttpStatus.CREATED).body(person);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id_child}")
    public ResponseEntity<Boolean> adoptPerson(@PathVariable("id_child") String idChild,  @RequestBody Map<String, String> data){
        try {
            String idFather= data.get("father_document");
            String idMother= data.get("mother_document");
            boolean f= false;
            boolean m= false;
            if(idFather.equals(idChild) || idFather.equals(idMother) || idMother.equals(idChild)){
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(false);
            }
            if(idFather != null){
                idFather.toString().toLowerCase().trim();
                f= personService.adopt(idFather, idChild, false);
            }
            if(idMother != null){
                idMother.toString().toLowerCase().trim();
                m= personService.adopt(idMother, idChild, true);
            }
            if(f || m){
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }else{
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(false);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
    
}
