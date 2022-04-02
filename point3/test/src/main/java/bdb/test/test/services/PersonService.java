package bdb.test.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bdb.test.test.pojos.Person;
import bdb.test.test.repositories.Person_repository;

@Service
public class PersonService{

    private Person_repository personRepository;

    @Autowired
    public void setPersonRepository(Person_repository person_repository){
        personRepository= person_repository;
    }

    public List<Person> findAll(){
        List<Person> persons= new ArrayList<Person>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    public List<Person> findByFullName(String fullName){
        Optional<List<Person>> optional= personRepository.findByFullName(fullName);
        List<Person> persons;
        if(optional.isPresent()){
            persons= optional.get();
        }else{
            persons= new ArrayList<Person>();
        }
        return persons;
    }

    public Person findById(String id){
        Optional<Person> optional= personRepository.findById(id);
        return optional.isPresent()? optional.get():null;
    }

    public Person save(Person newPerson){
        if(findById(newPerson.getId()) == null){
            return personRepository.save(newPerson);
        }
        return null;
    }

    @Transactional
    public boolean adopt(String id, String idChild, boolean isMother){
        Person parent= findById(id);
        Person child= findById(idChild);
        if(parent != null && child != null){
            if(!parent.getId().equalsIgnoreCase(child.getId())){
                if(!isParent(parent, child.getId())){
                    if(isMother){
                        if(child.getMother() == null){
                            child.setMother(parent);
                            personRepository.save(child);
                            return true;
                        }
                        return false;
                    }else{
                        if(child.getFather() == null){
                            child.setFather(parent);
                            personRepository.save(child);
                            return true;
                        }
                        return false;
                    }
                }
            }
        }
        return false;
    }

    private boolean isParent(Person person, String id) {
        if(person != null){
            if(person.getId().equalsIgnoreCase(id)){
                return true;
            }else {
                return isParent(person.getFather(), id) || isParent(person.getMother(), id);
            }
        }else{
            return false;
        }
    }
}
