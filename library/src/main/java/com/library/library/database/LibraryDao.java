package com.library.database;

import com.library.hibernateEntities.*;
import com.library.hibernateEntities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryDao {
    SessionFactory factory;
    public LibraryDao() {
        Configuration cfg = new Configuration();
        factory=cfg.configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Register.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Record.class)
                .addAnnotatedClass(rubView1.class)
                .addAnnotatedClass(Quantity.class)
                .buildSessionFactory();
    }

    public String getRole(String username,String password){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        User user=(User)session.get(User.class,username);
        user.toString();
        transaction.commit();
        session.close();
        if(user.getPassword().equals(password)) return user.getRole();
        return "error";
    }

    public void addRegister(Register register){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        session.save(register);
        transaction.commit();
        session.close();
    }

    public void addRecord(Record record){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        session.save(record);
        transaction.commit();
        session.close();

    }

    public List<Book> getAllBooks(){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        List<Book> books= session.createQuery("from Book",Book.class).getResultList();
        transaction.commit();
        session.close();
        return books;
    }

    public List<rubView1> getRubViewList(String username){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        List<rubView1> rubViewList=session.createQuery("select v from rubView1 v where username = '"+ username+"' and had= 'no'", rubView1.class).getResultList();
        transaction.commit();
        session.close();
        return rubViewList;
    }

    public List<rubView1> getUserBook(String username){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        List<rubView1> rubViewList=session.createQuery("select v from rubView1 v where username = '"+ username+"'"+" and have='yes' ", rubView1.class).getResultList();
        transaction.commit();
        session.close();
        return rubViewList;
    }

    public List<Register> getRegisterList(){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        List<Register> registers= session.createQuery("from Register").getResultList();
        transaction.commit();
        session.close();
        if(registers==null)return new ArrayList<Register>();
        return registers;
    }

    public void acceptRegister(String username){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        Register register=(Register) session.get(Register.class,username);
        User user=new User(register);
        session.save(user);
        session.delete(register);
        transaction.commit();
        session.close();
    }

    public void denyRegister(String username){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        Register register=(Register) session.get(Register.class,username);
        session.delete(register);
        transaction.commit();
        session.close();
    }

    public User getUser(String username){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        User user =(User)session.get(User.class,username);
        transaction.commit();
        session.close();
        return user;
    }

    public List<rubView1> bookRequestList(){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        List<rubView1> recordList=session.createQuery("select v from rubView1 v where permission = 'no'").getResultList();
        transaction.commit();
        session.close();
        return recordList;
    }

    public void addBook(Book book){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public void barrowBook(String recordId){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        Record record=(Record)session.get(Record.class,recordId);
        Quantity bookQuantity=session.get(Quantity.class,Integer.parseInt(record.getBookId()));
        bookQuantity.givingBook();
        session.update(bookQuantity);
        record.setHave("yes");
        record.setHad("yes");
        session.update(record);
        transaction.commit();
        session.close();

    }

    public void returnBook(String recordId){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        Record record=(Record)session.get(Record.class,recordId);
        Quantity bookQuantity=session.get(Quantity.class,Integer.parseInt(record.getBookId()));
        bookQuantity.returnedBook();
        session.update(bookQuantity);
        record.setHave("no");
        session.update(record);
        transaction.commit();
        session.close();
    }

    public void givePermissionForBook(String recordId){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        Record record=(Record)session.get(Record.class,recordId);
        record.setPermission("yes");
        session.update(record);
        transaction.commit();
        session.close();
    }

    public void rejectPermissionForBook(String recordId){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        Record record=(Record)session.get(Record.class,recordId);
        session.delete(record);
        transaction.commit();
        session.close();
    }
}
