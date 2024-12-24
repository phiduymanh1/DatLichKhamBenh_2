package com.example.datlichkhambenh_test.Services.iplm;



import com.example.datlichkhambenh_test.Entity.DichVuKhamEntity;
import com.example.datlichkhambenh_test.Repository.DichVuKhamRepository;
import com.example.datlichkhambenh_test.Request.DichVuKhamRequest;
import com.example.datlichkhambenh_test.Response.DichVuKhamResponse;
import com.example.datlichkhambenh_test.Services.Icomon;

import java.util.List;
import java.util.stream.Collectors;

public class DichVuKhamIplm implements Icomon<DichVuKhamResponse , DichVuKhamRequest> {
    DichVuKhamRepository dichVuKhamRepository = new DichVuKhamRepository();
    @Override
    public List<DichVuKhamResponse> getAll() {
        List<DichVuKhamEntity> listdvk = dichVuKhamRepository.getAll();
        return listdvk.stream().map(DichVuKhamResponse::new).collect(Collectors.toList());
    }

    @Override
    public void Add(DichVuKhamRequest object) {

    }

    @Override
    public void Update(DichVuKhamResponse object) {

    }


    @Override
    public DichVuKhamResponse getOne(String ma) {
        return null;
    }

    @Override
    public void delete(DichVuKhamRequest object) {

    }
}
