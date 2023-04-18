package com.hibernate.hibernateconfig.dao;

import com.hibernate.hibernateconfig.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void createUser(User user){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Long id = (Long)session.save(user);
            System.out.println("Created with id :" + id);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
