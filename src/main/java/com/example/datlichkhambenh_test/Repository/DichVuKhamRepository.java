package com.example.datlichkhambenh_test.Repository;


import com.example.datlichkhambenh_test.Entity.DichVuKhamEntity;
import com.example.datlichkhambenh_test.Ultils.Hibernate;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.*;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.List;

public class DichVuKhamRepository {
    Session session;
    public DichVuKhamRepository(){
        session = Hibernate.getFACTORY().openSession();
    }
    public List<DichVuKhamEntity> getAll(){
        return session.createQuery("FROM DichVuKhamEntity ").list();
    }
    public DichVuKhamEntity getOne(String ma){
        return session.find(DichVuKhamEntity.class,ma);
    }
    public void Add(DichVuKhamEntity dichVuKham){
        try {
            session.getTransaction().begin();
            session.persist(dichVuKham);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void update(DichVuKhamEntity dichVuKham){
        try {
            session.getTransaction().begin();
            session.merge(dichVuKham);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    public void delete(String ma){
        try {
            session.getTransaction().begin();
            DichVuKhamEntity dichVuKham = session.get(DichVuKhamEntity.class,ma);
            session.delete(dichVuKham);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
