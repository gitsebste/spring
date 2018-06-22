/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.domain.Item;
import com.example.demo.domain.Person;
import com.example.demo.service.ItemService;
import com.example.demo.service.LocationService;
import com.example.demo.service.PersonService;
import com.example.demo.service.UnitService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author device02
 */
@Controller
@RequestMapping("/item")
public class ItemController {
    
    
    ItemService service;UnitService uservice;PersonService pservice ;LocationService lservice ;

    @Autowired
    public void setLservice(LocationService lservice) {
        this.lservice = lservice;
    }

    @Autowired
    public void setPservice(PersonService pservice) {
        this.pservice = pservice;
    }

    @Autowired
    public void setUservice(UnitService uservice) {
        this.uservice = uservice;
    }

    public ItemService getService() {
        return service;
    }
    @Autowired
    public void setService(ItemService service) {
        this.service = service;
    }
        
    @RequestMapping(value="/add",method=RequestMethod.GET)
        public String add(HttpServletRequest httpServletRequest,Model model) {
        
        //logger.debug("ItemController.add()");
        //System.out.println("com.example.demo.controller.homecontroller.add()");
        
        //String msg = httpServletRequest.getParameter("msg");
        //if(msg==null)msg="Hello world!";
        
        //model.addAttribute("msg",msg);
        
        
        
        return  "addItem";        
    }
            @RequestMapping(value="/add",method=RequestMethod.POST)
        public String added(HttpServletRequest httpServletRequest,Model model) {
        
        //logger.debug("ItemController.add()");
        //System.out.println("com.example.demo.controller.homecontroller.add()");
        
        String name = httpServletRequest.getParameter("name");
        String code = httpServletRequest.getParameter("code");
        String description = httpServletRequest.getParameter("description");
        
        
        //sending object to model&view
        //Item i = new Item();i.setCode("codeOfTheItem");
        //model.addAttribute("obj",i);
        //<h1 th:text="${obj.code}"></h1><br>
        
        //validation in code and in html
        
        
        
                //System.out.println("Successfully validated. Adding to database...");
                //System.out.println(name +" "+ code+" "+description);
                service.save(new Item(code, name, description));
        
        return  "addItem";        
    }
                            @RequestMapping(value="/showAll",method=RequestMethod.GET)
        public String showAll(HttpServletRequest httpServletRequest,Model model) {  
            model.addAttribute("iterable", service.getAll());
        return  "showItems";        
    }
        @RequestMapping(value="/showByUnitShortName",method=RequestMethod.GET)
        public String showByUnitShortName(HttpServletRequest httpServletRequest,Model model) {
            String shortName = httpServletRequest.getParameter("shortName");
            model.addAttribute("iterable", service.getByUnitShortName(shortName));
        return  "showItems";        
    }
        @RequestMapping(value="/connectToUnit",method=RequestMethod.GET)
        public String connectToUnit(HttpServletRequest httpServletRequest,Model model) {
            String shortName = httpServletRequest.getParameter("shortName");
            String id = httpServletRequest.getParameter("id");
        Item item = service.getById(Integer.valueOf(id));
        item.setUnit(uservice.getByShortName(shortName));
        service.save(item);
        return  "home";        
    }    
                @RequestMapping(value="/connectToPerson",method=RequestMethod.GET)
        public String connectToPerson(HttpServletRequest httpServletRequest,Model model) {
            String personId = httpServletRequest.getParameter("personId");
            String id = httpServletRequest.getParameter("id");
        Item item = service.getById(Integer.valueOf(id));
        item.setPerson(pservice.getById(Integer.valueOf(personId)));
        service.save(item);
        return  "home";        
    }
                @RequestMapping(value="/connectToLocation",method=RequestMethod.GET)
        public String connectToLocation(HttpServletRequest httpServletRequest,Model model) {
            String locationId = httpServletRequest.getParameter("locationId");
            String id = httpServletRequest.getParameter("id");
        Item item = service.getById(Integer.valueOf(id));
        item.setLocation(lservice.getById(Integer.valueOf(locationId)));
        service.save(item);
        return  "home";        
    }        
        @RequestMapping(value="/chosenByUser/{id}",method=RequestMethod.GET)
        public String showById(HttpServletRequest httpServletRequest,Model model,@PathVariable("id") int id) {
            model.addAttribute("el", service.getById(id));
        return  "showItem";
    }
        @RequestMapping(value="/save",method=RequestMethod.GET)
        public String save(HttpServletRequest httpServletRequest,Model model ) {            
            String id = httpServletRequest.getParameter("id");
            String name = httpServletRequest.getParameter("name");
            String code = httpServletRequest.getParameter("code");
            String description = httpServletRequest.getParameter("description");
            String unit = httpServletRequest.getParameter("unit");
            String person = httpServletRequest.getParameter("person");
            String location = httpServletRequest.getParameter("location");
            
        Item item = new Item(code, name, description);
        if(unit.equals("") || unit==null)item.setUnit(null);
            item.setId(Integer.valueOf(id));
        if(person.equals("") || person==null)item.setPerson(null);
            item.setId(Integer.valueOf(id));
        if(location.equals("") || location==null)item.setLocation(null);
            item.setId(Integer.valueOf(id));            
            service.save(item);
            
        return  "home";        
    }
}
