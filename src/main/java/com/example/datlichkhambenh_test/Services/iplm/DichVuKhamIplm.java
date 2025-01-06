package com.example.datlichkhambenh_test.Services.iplm;



import com.example.datlichkhambenh_test.Entity.DichVuKhamEntity;
import com.example.datlichkhambenh_test.Repository.DichVuKhamRepository;
import com.example.datlichkhambenh_test.Request.DichVuKhamRequest;
import com.example.datlichkhambenh_test.Response.DichVuKhamResponse;
import com.example.datlichkhambenh_test.Services.Icomon;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DichVuKhamIplm implements Icomon<DichVuKhamResponse , DichVuKhamRequest > {
    DichVuKhamRepository dichVuKhamRepository = new DichVuKhamRepository();
    @Override
    public List<DichVuKhamResponse> getAll() {
        List<DichVuKhamEntity> dichVuKhamEntities = dichVuKhamRepository.getAll();
        return dichVuKhamEntities.stream().map(DichVuKhamResponse::new).collect(Collectors.toList());
    }

    @Override
    public void Add(DichVuKhamRequest object) {
        dichVuKhamRepository.Add(conver(object));
    }

    @Override
    public void Update(DichVuKhamRequest object) {
        dichVuKhamRepository.update(conver(object));
    }
    @SneakyThrows
    public DichVuKhamEntity conver(DichVuKhamRequest dichVuKhamRequest){
        DichVuKhamEntity dichVuKhamEntity = new DichVuKhamEntity();
        BeanUtils.copyProperties(dichVuKhamEntity,dichVuKhamRequest);
        return dichVuKhamEntity;
    }


    @Override
    public DichVuKhamResponse getOne(String ma) {
        DichVuKhamEntity dichVuKham = dichVuKhamRepository.getOne(ma);

        return new DichVuKhamResponse(dichVuKham);
    }

    @Override
    public void delete(String ma) {
        dichVuKhamRepository.delete(ma);
    }
}
