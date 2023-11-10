package com.jpiraban.spdemo.spdemo.DAO;



import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpiraban.spdemo.spdemo.model.Person;

@Repository("PerH2")
public interface PersonDaoServiceJPA   extends   JpaRepository<Person, Long>{

    
   // Person findPerson(String name);

   // Person findById(UUID id);

   // List<Person> findByNameContaining(String name);
    
}
