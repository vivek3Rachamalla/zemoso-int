package com.library.hibernateEntities;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "record")
public class Record {
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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

    public String getHad() {
        return had;
    }

    public void setHad(String had) {
        this.had = had;
    }

    public String getHave() {
        return have;
    }

    public void setHave(String have) {
        this.have = have;
    }
}
