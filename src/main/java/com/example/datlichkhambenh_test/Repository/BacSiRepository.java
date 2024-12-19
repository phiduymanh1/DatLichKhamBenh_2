package com.example.datlichkhambenh_test.Repository;

import com.example.datlichkhambenh_test.Entity.BacSiEntity;
import com.example.datlichkhambenh_test.Ultils.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class BacSiRepository {
    Session session;
    public BacSiRepository(){
        session = Hibernate.getFACTORY().openSession();
    }
    public List<BacSiEntity> getAll(){
        return session.createQuery("FROM BacSiEntity ").list();
    }
    public BacSiEntity getOne(String ma){
        return session.find(BacSiEntity.class,ma);
    }
    public void addOrUpdate(BacSiEntity bacSi){
        try {
            session.getTransaction().begin();
            session.saveOrUpdate(bacSi);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void delete(BacSiEntity bacSi){
        try {
            session.getTransaction().begin();
            session.delete(bacSi);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
