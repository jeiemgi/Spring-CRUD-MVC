package com.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.model.Connection;
import com.model.User;
import com.model.UserValidation;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("edit.htm")
public class EditController {

    private UserValidation usersToValidate;
    private Connection myConnection = new Connection();
    private JdbcTemplate JDBCT = new JdbcTemplate(myConnection.getDataSource());

    public EditController() {
        this.usersToValidate = new UserValidation();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        User user_data = this.selectUser(id);

        mav.setViewName("edit");
        mav.addObject("user", new User(
                id,
                user_data.getFirst_name(),
                user_data.getLast_name(),
                user_data.getEmail(),
                user_data.getPhone_number(),
                user_data.getGender()
        ));
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("user") User u,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {
        this.usersToValidate.validate(u, result);
        if (result.hasErrors()) {
            
            ModelAndView mav = new ModelAndView();
            int id = Integer.parseInt(request.getParameter("id"));
            User user_data = this.selectUser(id);
            
            mav.setViewName("edit");
            mav.addObject("User", new User(
                id,
                user_data.getFirst_name(),
                user_data.getLast_name(),
                user_data.getEmail(),
                user_data.getPhone_number(),
                user_data.getGender()
            ));
            return mav;
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            this.JDBCT.update(
                    "UPDATE USERS_DATA "
                    + "set first_name=?,"
                    + "last_name=?,"
                    + "email=?,"
                    + "phone_number=?,"
                    + "gender=?"
                    + "WHERE "
                    + "id=?",
                u.getFirst_name(),
                u.getLast_name(),
                u.getEmail(),
                u.getPhone_number(),
                u.getGender(),
                id
            );
            return new ModelAndView("redirect:/read.htm");
        }

    }

    public User selectUser(int id) {
        final User user = new User();
        String query = "SELECT * FROM USERS_DATA WHERE id='" + id + "'";
        return (User) JDBCT.query(
                query, new ResultSetExtractor<User>() {
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    user.setFirst_name(rs.getString("first_name"));
                    user.setLast_name(rs.getString("last_name"));
                    user.setEmail(rs.getString("email"));
                    user.setPhone_number(rs.getString("phone_number"));
                    user.setGender(rs.getString("gender"));
                }
                return user;
            }
        }
        );
    }

}
