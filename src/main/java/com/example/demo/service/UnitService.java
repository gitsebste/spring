/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.domain.Unit;
import com.example.demo.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author device02
 */

@Service
public class UnitService {
    
    UnitRepository unitRepository;

    public UnitRepository getUnitRepository() {
        return unitRepository;
    }

    @Autowired
    public void setUnitRepository(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }
    
        public Iterable<Unit> getAll(){
return unitRepository.findAll();
    }

    public void save(Unit unit) {
        unitRepository.save(unit);
    }
        public Unit getByShortName(String name) {
        return unitRepository.findByShortName(name);
    }

    public Object getById(int id) {
        return unitRepository.findById(id);
    }

    public void deleteById(int id) {
        unitRepository.deleteById(id);
    }
}
