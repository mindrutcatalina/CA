package com.example.campuss;

public class User {
    private String firstname;
    private String lastname;



    public User(String firstname, String lastname){
         this.firstname = firstname;
         this.lastname = lastname;

     }
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

}
