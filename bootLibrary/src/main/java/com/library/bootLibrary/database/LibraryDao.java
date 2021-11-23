package com.library.bootLibrary.database;


import com.library.bootLibrary.customException.OutOfBook;
import com.library.bootLibrary.hibernateEntities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibraryDao {
    SessionFactory factory;
    public LibraryDao() {
        Configuration cfg = new Configuration();
        factory=cfg.configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Register.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Record.class)
                .addAnnotatedClass(RubView1.class)
                .addAnnotatedClass(Quantity.class)
                .buildSessionFactory();
    }

    public String getRole(String username,String password){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        User user=session.get(User.class,username);
        transaction.commit();
        session.close();
        if(user==null) return "error";
        if(!password.equals(user.getPassword())) return "error";
        return user.getRole();
    }

    public void addRegister(Register register){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        session.save(register);
        transaction.commit();
        session.close();
    }

    public void addRecord(Record addRequest){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        session.save(addRequest);
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

    public List<RubView1> getRubViewList(String username){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        List<RubView1> rubViewList=session.createQuery("select v from rubView1 v where username = '"
                + username+"' and had= 'no'", RubView1.class).getResultList();
        transaction.commit();
        session.close();
        return rubViewList;
    }

    public List<RubView1> getUserBook(String username){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        List<RubView1> rubViewList=session.createQuery("select v from rubView1 v where username = '"+
                username+"'"+" and have='yes' ", RubView1.class).getResultList();
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
        if(registers==null)return new ArrayList<>();
        return registers;
    }

    public void acceptRegister(String username){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        Register register=session.get(Register.class,username);
        User user=new User(register);
        session.save(user);
        session.delete(register);
        transaction.commit();
        session.close();
    }

    public void denyRegister(String username){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        Register register=session.get(Register.class,username);
        session.delete(register);
        transaction.commit();
        session.close();
    }

    public User getUser(String username){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        User user =session.get(User.class,username);
        transaction.commit();
        session.close();
        return user;
    }

    public List<RubView1> bookRequestList(){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        List<RubView1> recordList=session.createQuery("select v from rubView1 v " +
                "where permission = 'no'").getResultList();
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

    public void barrowBook(String recordId) throws OutOfBook {
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        Record recordObj=session.get(Record.class,recordId);
        Quantity bookQuantity=session.get(Quantity.class,Integer.parseInt(recordObj.getBookId()));
        if(bookQuantity.getInLibrary()<1){
            transaction.commit();
            session.close();
            throw new OutOfBook("we don't have this book now");
        }
        bookQuantity.givingBook();
        session.update(bookQuantity);
        recordObj.setHave("yes");
        recordObj.setHad("yes");
        session.update(recordObj);
        transaction.commit();
        session.close();
    }

    public void returnBook(String recordId){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        Record recordObj=session.get(Record.class,recordId);
        Quantity bookQuantity=session.get(Quantity.class,Integer.parseInt(recordObj.getBookId()));
        bookQuantity.returnedBook();
        session.update(bookQuantity);
        recordObj.setHave("no");
        session.update(recordObj);
        transaction.commit();
        session.close();
    }

    public void givePermissionForBook(String recordId){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        Record recordObj=session.get(Record.class,recordId);
        recordObj.setPermission("yes");
        session.update(recordObj);
        transaction.commit();
        session.close();
    }

    public void rejectPermissionForBook(String recordId){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        Record recordObj=session.get(Record.class,recordId);
        session.delete(recordObj);
        transaction.commit();
        session.close();
    }
}
