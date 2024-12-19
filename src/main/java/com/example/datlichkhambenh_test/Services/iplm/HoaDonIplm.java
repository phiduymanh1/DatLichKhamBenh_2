package com.example.datlichkhambenh_test.Services.iplm;


import com.example.datlichkhambenh_test.Entity.HoaDonEntity;
import com.example.datlichkhambenh_test.Repository.HoaDonReponsitory;
import com.example.datlichkhambenh_test.Response.HoaDonResponse;
import com.example.datlichkhambenh_test.Services.Icomon;

import java.util.List;
import java.util.stream.Collectors;

public class HoaDonIplm implements Icomon<HoaDonResponse> {
    HoaDonReponsitory hoaDonReponsitory = new HoaDonReponsitory();
    @Override
    public List<HoaDonResponse> getAll() {
        List<HoaDonEntity> listhd = hoaDonReponsitory.getAll();
        return listhd.stream().map(HoaDonResponse::new).collect(Collectors.toList());
    }

    @Override
    public void addOrUpdate(HoaDonResponse object) {

    }

    @Override
    public HoaDonResponse getOne(String ma) {
//        HoaDonEntity hoaDon = new HoaDonEntity();
        HoaDonEntity hoaDon = hoaDonReponsitory.getOne(ma);
        return new HoaDonResponse(hoaDon);
    }

    @Override
    public void delete(HoaDonResponse object) {

    }
}
