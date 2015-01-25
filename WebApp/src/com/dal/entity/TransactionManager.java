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

    public void insertInto(String username, String password, String firstname, String lastname){
        Session ses = HibernateUtil.getSessionFactory().openSession();
        ses.beginTransaction();
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setFirstname(firstname);
        userEntity.setLastname(lastname);
        ses.save(userEntity);
        ses.getTransaction().commit();
        ses.close();
    }

    public void deleteRecord(String username){
        Session ses = HibernateUtil.getSessionFactory().openSession();
        ses.beginTransaction();
        Query query = ses.createQuery("from UserEntity where username = :name ");
        query.setParameter("name", username);
        List<UserEntity> results = query.list();
        int k = results.size();
        for(UserEntity us : results){
            ses.delete(us);
        }
        ses.getTransaction().commit();
        k = results.size();
        ses.close();
    }
}
