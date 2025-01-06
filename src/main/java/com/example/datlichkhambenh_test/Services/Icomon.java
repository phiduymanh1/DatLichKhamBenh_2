package com.example.datlichkhambenh_test.Services;



import java.util.List;


public interface Icomon<T , A >{
    List<T> getAll();

    void Add(A object);
    void Update(A object);

    T getOne(String ma);

    void delete(String ma );

}
