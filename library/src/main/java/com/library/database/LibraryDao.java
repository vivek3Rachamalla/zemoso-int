package com.library.database;

import com.library.hibernateEntities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class LibraryDao {
    SessionFactory factory;
    public LibraryDao() {
        Configuration cfg = new Configuration();
        factory=cfg.configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Register.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Record.class)
                .addAnnotatedClass(rubView.class)
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

    public List<Book> getAllBooks(){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        List<Book> books= session.createQuery("from Book",Book.class).getResultList();
        transaction.commit();
        session.close();
        return books;
    }

    public List<rubView> getRubViewList(){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        List<rubView> rubViewList=session.createQuery("select v from rubView v",rubView.class).getResultList();
        return rubViewList;
    }

    public List<Register> getRegisterList(){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        List<Register> registers= session.createQuery("from Register").getResultList();
        transaction.commit();
        session.close();
        if(registers==null)new ArrayList<Register>();
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

        session.createQuery("delete Register where username = "+username);
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

    public List<Record> waitingRecordsList(){
        Session session = factory.getCurrentSession();
        Transaction transaction= session.beginTransaction();
        List<Record> recordList=session.createQuery("from Record where permission = 0").getResultList();
        transaction.commit();
        session.close();
        return recordList;
    }

    public void giveBook(){}

}
