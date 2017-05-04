package com.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.model.Connection;
import com.model.User;
import com.model.UserValidation;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("add.htm")
public class AddController {
    
    private UserValidation usersToValidate;
    private Connection myConnection = new Connection();
    private JdbcTemplate JDBCT = new JdbcTemplate(myConnection.getDataSource());
    
    public AddController() 
    {
        this.usersToValidate = new UserValidation();
    }
    
    
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form() {
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("add");
        mav.addObject("user",new User());
        
        return mav;
        
    }
    
    //recibimos y validamos los datos de nuestro formulario
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
           @ModelAttribute("user") User u,
           BindingResult result,
           SessionStatus status
        )
    {
        this.usersToValidate.validate(u, result);
        
        if(result.hasErrors()) {

            ModelAndView mav= new ModelAndView();
            mav.setViewName("add");
            mav.addObject("user", new User());
            
            return mav;
        
        } else {
            this.JDBCT.update(
                    "INSERT INTO USERS_DATA (first_name, last_name, email, phone_number, gender) VALUES (?, ?, ?, ?, ?)",
                    u.getFirst_name(), u.getLast_name(), u.getEmail(), u.getPhone_number(), u.getGender());
                    return new ModelAndView("redirect:/read.htm");
        }
    }
    
    @ModelAttribute("genderList")
    public Map<String,String> listadoPaises()
    {
        Map<String,String> gender = new LinkedHashMap<>();
        gender.put("1","Masculino");
        gender.put("2","Femenino");
        return gender;
    }
    
}

