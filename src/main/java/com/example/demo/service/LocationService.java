/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.domain.Item;
import com.example.demo.domain.Location;
import com.example.demo.domain.Person;
import com.example.demo.domain.Unit;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author device02
 */

@Service
public class LocationService {
    
    LocationRepository locationRepository;

    @Autowired
//setter
    public void setLocationRepository(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
   
        public Iterable<Location> getAll(){
return locationRepository.findAll();
    }
}
