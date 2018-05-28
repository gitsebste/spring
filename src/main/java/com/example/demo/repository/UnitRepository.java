/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.domain.Unit;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author device02
 */

public interface UnitRepository extends CrudRepository<Unit, Integer>{
    public Unit findById(int id);
    public Unit findByShortName(String shortName);
}
