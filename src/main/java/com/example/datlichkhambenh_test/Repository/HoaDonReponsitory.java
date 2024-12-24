package com.example.datlichkhambenh_test.Repository;


import com.example.datlichkhambenh_test.Entity.HoaDonEntity;
import com.example.datlichkhambenh_test.Ultils.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class HoaDonReponsitory {
    Session session;
    public HoaDonReponsitory(){
        session = Hibernate.getFACTORY().openSession();
    }
    public List<HoaDonEntity> getAll(){
        return session.createQuery("FROM HoaDonEntity ").list();
    }
    public HoaDonEntity getOne(String ma){
        return session.find(HoaDonEntity.class,ma);
    }
    public void addOrUpdate(HoaDonEntity hoaDon){
        try {
            session.getTransaction().begin();
            session.saveOrUpdate(hoaDon);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    } public void update(HoaDonEntity hoaDon){
        try {
            session.getTransaction().begin();
            session.update(hoaDon);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    public void delete(HoaDonEntity hoaDon){
        try {
            session.getTransaction().begin();
            session.delete(hoaDon);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
