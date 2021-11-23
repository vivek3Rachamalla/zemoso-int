package com.library.bootLibrary.hibernateEntities;


import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Immutable
public class RubView1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recorsId")
    private String recordId;
    @Column(name="username")
    private String username;
    @Column(name="bookId")
    private String bookId;
    @Column(name="permission")
    private String permission;
    @Column(name="fromdate")
    private Date fromDate;
    @Column(name = "todate")
    private Date toDate;
    @Column(name = "have")
    private String have;
    @Column(name = "had")
    private String had;
    @Column(name="role")
    private String role;
    @Column(name = "name")
    private String name;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getHave() {
        return have;
    }

    public void setHave(String have) {
        this.have = have;
    }

    public String getHad() {
        return had;
    }

    public void setHad(String had) {
        this.had = had;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
