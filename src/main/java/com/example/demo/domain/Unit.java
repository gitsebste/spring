/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author device02
 */
@Entity
public class Unit implements Serializable {
        @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotEmpty @Column(unique=true)
    private String name;
    @NotEmpty @Column(unique=true)
    private String shortName; 

    public Unit(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public Unit() {
    }

    @Override
    public String toString() {
        return "Unit{" + "id=" + id + ", name=" + name + ", shortName=" + shortName + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    
}
