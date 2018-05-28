/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.domain.Location;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author device02
 */

public interface LocationRepository extends CrudRepository<Location, Integer>{
    public Location findById(int id);
    public Location findByName(String name);
    
}
