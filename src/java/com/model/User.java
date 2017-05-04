/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author josemiguel
 */
public class User {

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User(String first_name, String las_name, String email, String phone_number, String gender) {
        this.first_name = first_name;
        this.last_name = las_name;
        this.email = email;
        this.phone_number = phone_number;
        this.gender = gender;
    }

    public User(int id, String first_name, String las_name, String email, String phone_number, String gender) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = las_name;
        this.email = email;
        this.phone_number = phone_number;
        this.gender = gender;
    }

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String gender;

}
