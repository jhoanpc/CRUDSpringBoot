package com.jpiraban.spdemo.spdemo.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.jpiraban.spdemo.spdemo.model.Person;
import com.jpiraban.spdemo.spdemo.services.PersonServiceJPA;

@RestController
@RequestMapping("api/v2")
public class PersonControllerJPA {
    

    @Autowired
    public PersonServiceJPA personServiceJPA;

    @GetMapping("/people")
    public ResponseEntity<List<Person>> getAllPeople(){
        
        try {
                List<Person> peopleList = new ArrayList<>();
            
                 personServiceJPA.getAllPeople().forEach(peopleList::add);
                if (peopleList.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

            return new ResponseEntity<>(peopleList, HttpStatus.OK);
        } catch (Exception e) {
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/people")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){

        try {
            Person _Person = personServiceJPA.addPerson(person);


        return new ResponseEntity<>(_Person, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
