package com.dal.entity;

import com.dal.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Ruben on 1/25/2015.
 */
public class TransactionManager {

    public List<UserEntity> getAll(){

        Session ses = HibernateUtil.getSessionFactory().openSession();
        ses.beginTransaction();

        String hql = "FROM UserEntity";
        Query query = ses.createQuery(hql);
        List<UserEntity> results = query.list();
        return results;
    }

    public void insertInto(String username){

        Session ses = HibernateUtil.getSessionFactory().openSession();
        ses.beginTransaction();
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        ses.save(userEntity);
        ses.getTransaction().commit();
        ses.close();
    }
}
