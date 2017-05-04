/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Connection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author josemiguel
 */

public class DeleteController {
    private Connection myConnection = new Connection();
    private JdbcTemplate JDBCT = new JdbcTemplate(myConnection.getDataSource());
    
    public DeleteController(){
        
        
    }
    @RequestMapping("delete.htm")
    public ModelAndView home(HttpServletRequest request) 
    {
        int id=Integer.parseInt(request.getParameter("id"));
        this.JDBCT.update(
                "DELETE FROM USERS_DATA"
                + " where "
                + "id=? ",
        id);
        
        return new ModelAndView("redirect:/read.htm");
    }
    
}
