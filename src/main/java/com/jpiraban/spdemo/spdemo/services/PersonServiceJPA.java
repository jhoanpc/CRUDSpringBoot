package com.jpiraban.spdemo.spdemo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jpiraban.spdemo.spdemo.DAO.PersonDaoServiceJPA;
import com.jpiraban.spdemo.spdemo.model.Person;

@Service
public class PersonServiceJPA {
    
    @Autowired
    public @Qualifier("PerH2") PersonDaoServiceJPA personDaoServiceJPA;


    public List<Person> getAllPeople(){

         
             return   personDaoServiceJPA.findAll();
            
            
            /*else{
                personDaoServiceJPA.findByNameContaining(name).forEach(peopleList::add);
            }*/

       
    }

    public Person addPerson(Person person){

        UUID id = UUID.randomUUID();
        return personDaoServiceJPA.save(new Person(id, person.getName()));
    }   
}
