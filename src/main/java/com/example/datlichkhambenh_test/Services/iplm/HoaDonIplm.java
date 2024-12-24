package com.example.datlichkhambenh_test.Services.iplm;


import com.example.datlichkhambenh_test.Entity.BacSiEntity;
import com.example.datlichkhambenh_test.Entity.BenhNhanEntity;
import com.example.datlichkhambenh_test.Entity.ChucVuEntity;
import com.example.datlichkhambenh_test.Entity.HoaDonEntity;
import com.example.datlichkhambenh_test.Repository.BacSiRepository;
import com.example.datlichkhambenh_test.Repository.BenhNhanRepository;
import com.example.datlichkhambenh_test.Repository.HoaDonReponsitory;
import com.example.datlichkhambenh_test.Request.HoaDonRequest;
import com.example.datlichkhambenh_test.Response.HoaDonResponse;
import com.example.datlichkhambenh_test.Services.Icomon;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HoaDonIplm implements Icomon<HoaDonResponse , HoaDonRequest> {
    HoaDonReponsitory hoaDonReponsitory = new HoaDonReponsitory();
    @Override
    public List<HoaDonResponse> getAll() {
        List<HoaDonEntity> listhd = hoaDonReponsitory.getAll();
        return listhd.stream().map(HoaDonResponse::new).collect(Collectors.toList());
    }

    @Override
    public void Add(HoaDonRequest object) {
        hoaDonReponsitory.addOrUpdate(converHoaDonFromRequest(object));
    }
    @SneakyThrows
    @Override
    public void Update(HoaDonResponse object) {
        HoaDonRequest hoaDonRequest = new HoaDonRequest();
        BeanUtils.copyProperties(hoaDonRequest,object);
        hoaDonReponsitory.update(converHoaDonFromRequest(hoaDonRequest));
    }


    public static void main(String[] args) {
        HoaDonEntity hoaDon = new HoaDonEntity();
        hoaDon.setMaHd("HD006");
        hoaDon = new HoaDonReponsitory().getOne(hoaDon.getMaHd());
        BacSiEntity bacSi = new BacSiEntity();
        bacSi.setMaBs("BS002");
        bacSi = new BacSiRepository().getOne(bacSi.getMaBs());
        BenhNhanEntity benhNhan = new BenhNhanEntity();

        benhNhan.setMaBn("BN002");
        benhNhan = new BenhNhanRepository().getOne(benhNhan.getMaBn());
        hoaDon.setBacSi(bacSi);
        hoaDon.setBenhNhan(benhNhan);
//        hoaDonResponse.set("BS002");
        hoaDon.setNgayKham(Date.valueOf("2024-09-09"));
        hoaDon.setThanhToan(BigDecimal.valueOf(1234));
        hoaDon.setTongTien(BigDecimal.valueOf(12000));
        hoaDon.setTienThua(BigDecimal.valueOf(12000));
        hoaDon.setTrangThai("Chưa Thanh Toán");
//        new HoaDonReponsitory().update(hoaDon);
        HoaDonResponse hoaDonResponse = new HoaDonResponse(hoaDon);
        System.out.println(hoaDon);
        System.out.println(hoaDonResponse);
//        HoaDonEntity hoaDon = new HoaDonIplm().converHoaDonFromRequest(hoaDonRequest);
//        System.out.println("Hoa don req 2: "+ hoaDonRequest);
//        System.out.println(hoaDon);
        new HoaDonIplm().Update(hoaDonResponse);


    }
    @SneakyThrows
    public HoaDonEntity converHoaDonFromRequest(HoaDonRequest hoaDonRequest){
        HoaDonEntity hoaDon = new HoaDonEntity();
        BeanUtils.copyProperties(hoaDon,hoaDonRequest);
        if (hoaDonRequest.getMaBn() != null){
            BenhNhanEntity benhNhan = new BenhNhanRepository().getOne(hoaDonRequest.getMaBn());
            hoaDon.setBenhNhan(benhNhan);
        }
        if (hoaDonRequest.getMaBs() != null){
            BacSiEntity bacSi = new BacSiRepository().getOne(hoaDonRequest.getMaBs());
            hoaDon.setBacSi(bacSi);
        }
        return hoaDon;
    }
    @Override
    public HoaDonResponse getOne(String ma) {
//        HoaDonEntity hoaDon = new HoaDonEntity();
        HoaDonEntity hoaDon = hoaDonReponsitory.getOne(ma);
        return new HoaDonResponse(hoaDon);
    }

    @Override
    public void delete(HoaDonRequest object) {
        hoaDonReponsitory.delete(converHoaDonFromRequest(object));
    }

}
