/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.domain.Item;
import com.example.demo.domain.Unit;
import com.example.demo.service.ItemService;
import com.example.demo.service.UnitService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author device02
 */
@Controller
@RequestMapping("/unit")
public class UnitController {
    
    
    UnitService service;

    public UnitService getService() {
        return service;
    }
    @Autowired
    public void setService(UnitService service) {
        this.service = service;
    }
        
    @RequestMapping(value="/add",method=RequestMethod.GET)
        public String add(HttpServletRequest httpServletRequest,Model model) {
        
        //logger.debug("ItemController.add()");
        //System.out.println("com.example.demo.controller.homecontroller.add()");
        
        //String msg = httpServletRequest.getParameter("msg");
        //if(msg==null)msg="Hello world!";
        
        //model.addAttribute("msg",msg);
        
        
        
        return  "addUnit";        
    }
            @RequestMapping(value="/add",method=RequestMethod.POST)
        public String added(HttpServletRequest httpServletRequest,Model model) {
        
        //logger.debug("ItemController.add()");
        //System.out.println("com.example.demo.controller.homecontroller.add()");
        
        String name = httpServletRequest.getParameter("name");
        String shortName = httpServletRequest.getParameter("shortName");
        
        
        
        //sending object to model&view
        //Item i = new Item();i.setCode("codeOfTheItem");
        //model.addAttribute("obj",i);
        //<h1 th:text="${obj.code}"></h1><br>
        
        //validation in code and in html
        
        
        
                //System.out.println("Successfully validated. Adding to database...");
                //System.out.println(new Unit(name, shortName));
                service.save(new Unit(name, shortName));
        
        return  "addUnit";        
    }
        
            @RequestMapping(value="/showAll",method=RequestMethod.GET)
        public String showAll(HttpServletRequest httpServletRequest,Model model) {  
            model.addAttribute("iterable", service.getAll());
        return  "showUnits";        
    }
        
                    @RequestMapping(value="/byShortName",method=RequestMethod.GET)
        public String showByShortName(HttpServletRequest httpServletRequest,Model model) {
            String shortName = httpServletRequest.getParameter("shortName");
            model.addAttribute("iterable", service.getByShortName(shortName));
        return  "showUnits";        
    }
                            @RequestMapping(value="/chosenByUser/{id}",method=RequestMethod.GET)
        public String showByShortName(HttpServletRequest httpServletRequest,Model model,@PathVariable("id") int id) {
            model.addAttribute("el", service.getById(id));
            //model.addAttribute("unit", new Unit());
        return  "showUnit";        
    }
        
                                    @RequestMapping(value="/save",method=RequestMethod.GET)
        public String save(HttpServletRequest httpServletRequest,Model model ) {            
            
            String id = httpServletRequest.getParameter("id");
            String name = httpServletRequest.getParameter("name");
            String shortName = httpServletRequest.getParameter("shortName");
            
            //System.out.println("'Saving' "+id+" "+name+" "+shortName);
            Unit unit=new Unit(name, shortName);unit.setId(Integer.valueOf(id));
            service.save(unit);
            
        return  "home";        
    }
    
}
