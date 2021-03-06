/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.domain.Item;
import com.example.demo.domain.Location;
import com.example.demo.domain.Unit;
import com.example.demo.service.ItemService;
import com.example.demo.service.LocationService;
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
@RequestMapping("/location")
public class LocationController {
    
    
    LocationService service;

    public LocationService getService() {
        return service;
    }
    @Autowired
    public void setService(LocationService service) {
        this.service = service;
    }
        
    @RequestMapping(value="/add",method=RequestMethod.GET)
        public String add(HttpServletRequest httpServletRequest,Model model) {
        
        //logger.debug("ItemController.add()");
        //System.out.println("com.example.demo.controller.homecontroller.add()");
        
        //String msg = httpServletRequest.getParameter("msg");
        //if(msg==null)msg="Hello world!";
        
        //model.addAttribute("msg",msg);
        
        
        
        return  "addLocation";        
    }
            @RequestMapping(value="/add",method=RequestMethod.POST)
        public String added(HttpServletRequest httpServletRequest,Model model) {
        
        //logger.debug("ItemController.add()");
        //System.out.println("com.example.demo.controller.homecontroller.add()");
        
        String name = httpServletRequest.getParameter("name");        
        String description = httpServletRequest.getParameter("description");
        float building = Float.valueOf(httpServletRequest.getParameter("building"));
        float room = Float.valueOf(httpServletRequest.getParameter("room"));
        int floor = Integer.valueOf(httpServletRequest.getParameter("floor"));
        
        
        //sending object to model&view
        //Item i = new Item();i.setCode("codeOfTheItem");
        //model.addAttribute("obj",i);
        //<h1 th:text="${obj.code}"></h1><br>
        
        //validation in code and in html
        
        
        
                //System.out.println("Successfully validated. Adding to database...");
                //System.out.println(name +" "+ code+" "+description);
                service.save(new Location(name, description, building, room, floor));
        
        return  "addItem";        
    }
        
                    @RequestMapping(value="/showAll",method=RequestMethod.GET)
        public String showAll(HttpServletRequest httpServletRequest,Model model) {  
            model.addAttribute("iterable", service.getAll());
        return  "showLocations";        
    }
                                @RequestMapping(value="/chosenByUser/{id}",method=RequestMethod.GET)
        public String showById(HttpServletRequest httpServletRequest,Model model,@PathVariable("id") int id) {
            model.addAttribute("el", service.getById(id));
            //model.addAttribute("unit", new Unit());
        return  "showLocation";        
    }
        
                                    @RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
        public String deleteById(HttpServletRequest httpServletRequest,Model model,@PathVariable("id") int id) {
            //model.addAttribute("el", service.getById(id));
            service.deleteById(id);
        return  "home"; 
        }
                                            @RequestMapping(value="/save",method=RequestMethod.GET)
        public String save(HttpServletRequest httpServletRequest,Model model ) {            
            String id = httpServletRequest.getParameter("id");
            String name = httpServletRequest.getParameter("name");
            String description = httpServletRequest.getParameter("description");
            float building = Float.valueOf(httpServletRequest.getParameter("building"));
            float room = Float.valueOf(httpServletRequest.getParameter("room"));
            int floor = Integer.valueOf(httpServletRequest.getParameter("floor"));
            
            Location location=new Location(name,description , building, room, floor);location.setId(Integer.valueOf(id));
            service.save(location);
            
        return  "home";        
    }
}
