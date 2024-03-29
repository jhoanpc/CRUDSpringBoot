package com.jpiraban.spdemo.spdemo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpiraban.spdemo.spdemo.model.Person;
import com.jpiraban.spdemo.spdemo.services.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPeople(){
       return  personService.getAllPeople();
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }
    @PutMapping(path = "/{id}")
    public void updatePerson(@PathVariable ("id")UUID id, @RequestBody Person person){
        personService.updatePerson(id, person);
    }

    @DeleteMapping(path = "/{id}")
    public int deletePersonById(@PathVariable("id") UUID id){
        return personService.deletePersonById(id);
    }
    
}
