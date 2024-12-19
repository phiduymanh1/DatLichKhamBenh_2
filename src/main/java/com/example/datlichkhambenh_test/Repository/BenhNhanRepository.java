package com.example.datlichkhambenh_test.Repository;

import com.example.datlichkhambenh_test.Entity.BenhNhanEntity;
import com.example.datlichkhambenh_test.Entity.HoaDonEntity;
import com.example.datlichkhambenh_test.Ultils.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class BenhNhanRepository {
    Session session;
    public BenhNhanRepository(){
        session = Hibernate.getFACTORY().openSession();
    }
    public List<BenhNhanEntity> getAll(){
        return session.createQuery("FROM BenhNhanEntity ").list();
    }
    public BenhNhanEntity getOne(String ma){
        return session.find(BenhNhanEntity.class,ma);
    }
    public void addOrUpdate(BenhNhanEntity benhNhan){
        try {
            session.getTransaction().begin();
            session.saveOrUpdate(benhNhan);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void delete(BenhNhanEntity benhNhan){
        try {
            session.getTransaction().begin();
            session.delete(benhNhan);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
