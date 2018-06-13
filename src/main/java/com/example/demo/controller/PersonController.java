/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.domain.Item;
import com.example.demo.domain.Person;
import com.example.demo.domain.Unit;
import com.example.demo.service.ItemService;
import com.example.demo.service.PersonService;
import com.example.demo.service.UnitService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author device02
 */
@Controller
@RequestMapping("/person")
public class PersonController {
    
    
    PersonService service;UnitService uservice;

    public PersonService getService() {
        return service;
    }
    @Autowired
    public void setService(PersonService service) {
        this.service = service;
    }
        
    @RequestMapping(value="/add",method=RequestMethod.GET)
        public String add(HttpServletRequest httpServletRequest,Model model) {
        
        //logger.debug("ItemController.add()");
        //System.out.println("com.example.demo.controller.homecontroller.add()");
        
        //String msg = httpServletRequest.getParameter("msg");
        //if(msg==null)msg="Hello world!";
        
        //model.addAttribute("msg",msg);
        
        
        
        return  "addPerson";        
    }
            @RequestMapping(value="/add",method=RequestMethod.POST)
        public String added(HttpServletRequest httpServletRequest,Model model) {
        
        //logger.debug("ItemController.add()");
        //System.out.println("com.example.demo.controller.homecontroller.add()");
        
        String name = httpServletRequest.getParameter("name");
        String lastName = httpServletRequest.getParameter("lastName");
        String email = httpServletRequest.getParameter("email");
        String unitShortName = httpServletRequest.getParameter("unitShortName");
        
        
        //sending object to model&view
        //Item i = new Item();i.setCode("codeOfTheItem");
        //model.addAttribute("obj",i);
        //<h1 th:text="${obj.code}"></h1><br>
        
        //validation in code and in html
        //System.out.println("Successfully validated. Adding to database...");
        //System.out.println(name +" "+ code+" "+description);
        //for(int i=0;i<3;i++)System.out.println(); 
        //System.out.println(unitShortName);   
        Unit unit = uservice.getByShortName(unitShortName);
        //System.out.println(unit);   
        //for(int i=0;i<3;i++)System.out.println(); 
        
        service.save(new Person(name, lastName, email,unit));
        
        return  "addPerson";        
    }
    
}
