package com.library.bootLibrary.formEntities;


public class registerPojo {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNo;

    public registerPojo(){}

    public registerPojo(String username, String password, String firstName, String lastName, String phoneN0) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneN0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneN0) {
        this.phoneNo = phoneN0;
    }
}
