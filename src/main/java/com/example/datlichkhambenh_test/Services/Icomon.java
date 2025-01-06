package com.example.datlichkhambenh_test.Services;



import java.util.List;

<<<<<<< HEAD
public interface Icomon<T , A >{
    List<T> getAll();

    void Add(A object);
    void Update(A object);

    T getOne(String ma);

    void delete(String ma );
=======
public interface Icomon<T , A>{
    List<T> getAll();

    void Add(A object);
    void Update(T object);

    T getOne(String ma);

    void delete(A object);
>>>>>>> 6a14a23d63cda213e6ec4475ea5a6c62a7de28dc
}
