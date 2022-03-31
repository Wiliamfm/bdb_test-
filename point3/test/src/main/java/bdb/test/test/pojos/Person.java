package bdb.test.test.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "person")
public class Person{

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "full_name")
    private String full_name;
    @Column(name = "birth_date")
    private LocalDate birth_date;
    @ManyToOne
    @JoinColumn(name = "father", nullable = true, referencedColumnName = "id")
    private Person father;
    @ManyToOne
    @JoinColumn(name = "mother", nullable = true, referencedColumnName = "id")
    private Person mother;

    protected Person(){};

    public Person(String id, String full_name, LocalDate birth_date){
        this.id= id;
        this.full_name= full_name;
        this.birth_date= birth_date;
    }

    public Person(String id, String full_name, LocalDate birth_date, Person father, Person mother){
        this.id= id;
        this.full_name= full_name;
        this.birth_date= birth_date;
        this.father= father;
        this.mother= mother;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, FULL NAME: %s, FATHER: $s, MOTHER: %s",
        getId(), getFull_name(), getFather().getFull_name(), getMother().getFull_name());
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the full_name
     */
    public String getFull_name() {
        return full_name;
    }

    /**
     * @return the birth_date
     */
    public LocalDate getBirth_date() {
        return birth_date;
    }

    /**
     * @return the father
     */
    public Person getFather() {
        return father;
    }

    /**
     * @return the mother
     */
    public Person getMother() {
        return mother;
    }

    /**
     * @param father the father to set
     */
    public void setFather(Person father) {
        this.father = father;
    }

    /**
     * @param mother the mother to set
     */
    public void setMother(Person mother) {
        this.mother = mother;
    }
}
