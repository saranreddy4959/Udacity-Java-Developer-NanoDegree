package com.saran.bootstrap_dogs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String Breed;
    private String Origin;

    public Dog(Long id,String name, String Breed, String Origin){
        this.id = id;
        this.name = name;
        this.Breed = Breed;
        this.Origin = Origin;
    }

    public Dog(){}
    public Dog(String name , String Breed){
        this.name = name ;
        this.Breed = Breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
