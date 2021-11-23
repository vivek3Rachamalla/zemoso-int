package com.library.bootLibrary.dto;

import com.library.bootLibrary.formEntities.LoginPojo;
import com.library.bootLibrary.hibernateEntities.Book;
import com.library.bootLibrary.hibernateEntities.Register;
import com.library.bootLibrary.hibernateEntities.RubView1;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminDto {
    private String username;
    private String password;
    private String role;
    private List<Book> bookList;
    private List<Register> registerList;
    private List<RubView1> rubViewList;

    public AdminDto(){}

    public AdminDto(LoginPojo loginPojo){
        this.username=loginPojo.getUsernameLogin();
        this.password=loginPojo.getPasswordLogin();
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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Register> getRegisterList() {
        return registerList;
    }

    public void setRegisterList(List<Register> registerList) {
        this.registerList = registerList;
    }

    public List<RubView1> getRubViewList() {
        return rubViewList;
    }

    public void setRubViewList(List<RubView1> rubViewList) {
        this.rubViewList = rubViewList;
    }
}
