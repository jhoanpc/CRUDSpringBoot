package com.jpiraban.spdemo.spdemo.DAO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jpiraban.spdemo.spdemo.model.Person;

public interface PersonDao {

    

    public int insertDao(UUID id, Person person);
    
     List<Person>  getPeople();

     Optional<Person> getPersonById(UUID id);

     int updatePerson(UUID id, Person person);

     int deletePersonById(UUID id);

     default int insertPerson(Person person){

        UUID id = UUID.randomUUID();

        return insertDao(id, person);
    }

}
