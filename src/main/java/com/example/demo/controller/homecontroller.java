/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.domain.Item;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author device02
 */

@Controller
@RequestMapping("/")
public class homecontroller {

        @RequestMapping(value="/home",method=RequestMethod.GET)
        public String add(HttpServletRequest httpServletRequest,Model model) {

        return  "home";        
    }
    
}
