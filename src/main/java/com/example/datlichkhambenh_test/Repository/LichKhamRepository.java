package com.example.datlichkhambenh_test.Repository;

import com.example.datlichkhambenh_test.Entity.LichKhamEntity;
import com.example.datlichkhambenh_test.Ultils.Hibernate;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class LichKhamRepository {
    Session s;
    public LichKhamRepository() {
        s = Hibernate.getFACTORY().openSession();
    }

    public List<LichKhamEntity>getLichKham() {
        return s.createQuery("from LichKhamEntity ").list();
    }

    public static void main(String[] args) {
        LichKhamRepository repo = new LichKhamRepository();
        List<LichKhamEntity> list = repo.getLichKham();

        for (LichKhamEntity x:list
             ) {
            System.out.println(x.toString());
        }
    }
}
