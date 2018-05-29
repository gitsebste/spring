/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.domain.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author device02
 */

@Controller
@RequestMapping("/item")
public class homecontroller {
    
    @RequestMapping("/add")
        public ModelAndView add() {
        
        //logger.debug("ItemController.add()");
        
        System.out.println("com.example.demo.controller.homecontroller.add()");
        
        ModelAndView model = new ModelAndView("addItem");
        
        //Person p = new Person();p.setName("Name");
        model.addObject("item", new Item());
        
        return model;
    }
    
}
