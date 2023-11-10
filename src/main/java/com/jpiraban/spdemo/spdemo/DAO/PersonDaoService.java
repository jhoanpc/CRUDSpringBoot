package com.jpiraban.spdemo.spdemo.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.jpiraban.spdemo.spdemo.model.Person;

@Repository("fakeDao")
public class PersonDaoService  implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertDao(UUID id, Person person) {
     
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getPeople() {
        return DB;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        
        return DB.stream().filter(person ->{
            return person.getId().equals(id);
        }).findFirst();
    }

    @Override
    public int updatePerson(UUID id, Person personUpdate) {
        Optional<Person> temp = getPersonById(id);

        if (!temp.isPresent()){
            return 0;
        }
        return temp.map(person -> {
            int indexPerson = DB.indexOf(person);
            if(indexPerson >= 0){
                DB.set(indexPerson, personUpdate);

                return 1;
            }
            return 0;
        }).orElse(0);

        
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> temp = getPersonById(id);

        if (!temp.isPresent()){
            return 0;
        }
        DB.remove(temp.get());
        return 1;
    }
    
}
