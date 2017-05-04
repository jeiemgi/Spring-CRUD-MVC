/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Connection;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author josemiguel
 */

@Controller
public class ReadController {
    
    private Connection myConnection = new Connection();
    private JdbcTemplate JDBCT = new JdbcTemplate(myConnection.getDataSource());

    public ReadController() {
        
    }
    
    @RequestMapping("read.htm")
    public ModelAndView read() {
 
        ModelAndView mav = new ModelAndView();
        
        String query = "SELECT * FROM USERS_DATA";
        List usersData = this.JDBCT.queryForList(query);
        
        mav.setViewName("read");
        mav.addObject("usersData", usersData);
        
        return mav;
    }
  
}
  
// HttpServletRequest sirve para recabar los parametros desde la URL
// HttpServletRequest $request

// String id = $request.getParameter("id");
