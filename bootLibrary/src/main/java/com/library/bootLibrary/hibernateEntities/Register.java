package com.library.bootLibrary.hibernateEntities;

import com.library.bootLibrary.formEntities.RegisterPojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "register")
public class Register {
    @Id
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="role")
    private String role;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="phoneNo")
    private String phoneNo;

    public Register(){}

    public Register(RegisterPojo registerPojo) {
        this.username = registerPojo.getUsername();
        this.password = registerPojo.getPassword();
        this.role = "user";
        this.firstName = registerPojo.getFirstName();
        this.lastName = registerPojo.getLastName();
        this.phoneNo = registerPojo.getPhoneNo();
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
