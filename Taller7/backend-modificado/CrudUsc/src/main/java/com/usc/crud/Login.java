package com.usc.crud;

public class Login {
        public String email;
        public String password;
        // you need a zero argument constructor
        // maybe you have to add getter and setters

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
