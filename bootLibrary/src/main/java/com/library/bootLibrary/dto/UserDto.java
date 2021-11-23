package com.library.bootLibrary.dto;

import com.library.bootLibrary.hibernateEntities.Book;
import com.library.bootLibrary.hibernateEntities.RubView1;
import com.library.bootLibrary.formEntities.LoginPojo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Component
public class UserDto {
    private String username;
    private String password;
    private String role;
    private String date;
    private List<Book> bookList;
    private Map<RubView1,String> havingBook;
    private List<RubView1> history;

    public UserDto(){
        this.date= LocalDate.now().toString();
    }

    public UserDto(LoginPojo loginPojo){
        this.username=loginPojo.getUsernameLogin();
        this.password=loginPojo.getPasswordLogin();
        this.date= LocalDate.now().toString();
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

    public Map<RubView1, String> getHavingBook() {
        return havingBook;
    }

    public void setHavingBook(Map<RubView1, String> havingBook) {
        this.havingBook = havingBook;
    }

    public List<RubView1> getHistory() {
        return history;
    }

    public void setHistory(List<RubView1> history) {
        this.history = history;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "userDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", bookList=" + bookList +
                ", havingBook=" + havingBook +
                ", history=" + history +
                '}';
    }
}
