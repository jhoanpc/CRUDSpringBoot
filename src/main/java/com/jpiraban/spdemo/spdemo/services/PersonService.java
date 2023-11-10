package com.jpiraban.spdemo.spdemo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jpiraban.spdemo.spdemo.DAO.PersonDao;
import com.jpiraban.spdemo.spdemo.model.Person;

@Service
public class PersonService {
    
    private final PersonDao personDao;

    @Autowired
    public PersonService (@Qualifier("fakeDao") PersonDao personDao){
        this.personDao = personDao;
    }

    public List<Person> getAllPeople(){
        return personDao.getPeople();
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);

    }

    public int updatePerson(UUID id,Person person){
        return personDao.updatePerson(id, person);
    }

    public int deletePersonById(UUID id){
        return personDao.deletePersonById(id);
    }

    

}
