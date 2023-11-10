package com.jpiraban.spdemo.spdemo.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    private UUID id ;

    

    public UUID getId() {
        return id;
    }
    @Column(name = "name")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person(){
        
    }
    public Person(UUID id, String name){
        this.id = id;
        this.name = name;
    }
}
