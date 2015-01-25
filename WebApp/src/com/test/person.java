package com.test;

import com.dal.entity.TransactionManager;
import com.dal.entity.UserEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import java.util.List;

/**
 * Created by Ruben on 1/24/2015.
 */

@ManagedBean
@SessionScoped
public class person {

    private String username;

    public void next(ActionEvent event){

        TransactionManager tr = new TransactionManager();
        List<UserEntity> list = tr.getAll();
        System.out.println(list.get(0));
    }

    public void insertInto(ActionEvent event){

        TransactionManager tr = new TransactionManager();
        tr.insertInto(getUsername());
        System.out.println(getUsername());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
