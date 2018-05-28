/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.domain.Person;
import java.util.List;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author device02
 */

public interface PersonRepository extends CrudRepository<Person, Integer>{
    public Person findById(int id);
    public Person findByEmail(String email);
    public List<Person> findByUnitShortName(String unitShortName);
    public List<Person> findByUnitId(Integer unitId);
}
