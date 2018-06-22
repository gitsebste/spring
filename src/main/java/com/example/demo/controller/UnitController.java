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
            return  "addUnit";        
    }
            @RequestMapping(value="/add",method=RequestMethod.POST)
        public String added(HttpServletRequest httpServletRequest,Model model) {
            String name = httpServletRequest.getParameter("name");
            String shortName = httpServletRequest.getParameter("shortName");
            service.save(new Unit(name, shortName));        
            return  "home";        
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
        public String showById(HttpServletRequest httpServletRequest,Model model,@PathVariable("id") int id) {
            model.addAttribute("el", service.getById(id));
        return  "showUnit";        
    }
        @RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
        public String deleteById(HttpServletRequest httpServletRequest,Model model,@PathVariable("id") int id) {
            service.deleteById(id);
        return  "home";        
    }
        @RequestMapping(value="/save",method=RequestMethod.GET)
        public String save(HttpServletRequest httpServletRequest,Model model ) {                        
            String id = httpServletRequest.getParameter("id");
            String name = httpServletRequest.getParameter("name");
            String shortName = httpServletRequest.getParameter("shortName");           
            Unit unit=new Unit(name, shortName);unit.setId(Integer.valueOf(id));
            service.save(unit);
            
        return  "home";        
    }
    
}
