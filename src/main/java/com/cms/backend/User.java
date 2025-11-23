package com.cms.backend;

public class User {
    protected String username;
    protected String name;
    protected String email;
    protected int phoneNumber;

    public User(String username, String name, String email, int phoneNumber) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void enterUsername(String username) {
        this.username = username;
    }

    public void enterName (String name) {
        this.name = name;
    }

    public void enterEmail(String email) {
        this.email = email;
    }

    public void enterPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getName () {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

}