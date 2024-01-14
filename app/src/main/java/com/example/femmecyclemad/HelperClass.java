package com.example.femmecyclemad;


public class HelperClass {

    String name, email, gender, password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String username) {
        this.gender = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HelperClass(String name, String email, String gender, String password) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }

    public HelperClass() {
    }
}