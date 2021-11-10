package com.library.hibernateEntities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
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
    private String phoneN0;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "username",
            cascade = {CascadeType.DETACH,CascadeType.MERGE,
                    CascadeType.PERSIST,CascadeType.REFRESH})

    private List<Record> recordList;

    public User(){}

    public User(Register register) {
        this.username=register.getUsername();
        this.password=register.getPassword();
        this.role=register.getRole();
        this.firstName=register.getFirstName();
        this.lastName=register.getLastName();
        this.phoneN0= register.getPhoneNo();;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
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

    public String getPhoneN0() {
        return phoneN0;
    }

    public void setPhoneN0(String phoneN0) {
        this.phoneN0 = phoneN0;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneN0='" + phoneN0 + '\'' +
                ", recordList=" + recordList +
                '}';
    }
}
