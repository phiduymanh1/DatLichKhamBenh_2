package com.example.datlichkhambenh_test.Services;



import java.util.List;

public interface Icomon<T>{
    List<T> getAll();

    void addOrUpdate(T object);

    T getOne(String ma);

    void delete(T object);
}
