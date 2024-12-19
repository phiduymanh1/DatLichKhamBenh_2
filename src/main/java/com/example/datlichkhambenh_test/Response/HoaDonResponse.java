package com.example.datlichkhambenh_test.Response;


import com.example.datlichkhambenh_test.Entity.HoaDonEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class HoaDonResponse {

    private String maHd;

    private Date ngayKham;

    private BigDecimal tongTien;

    private BigDecimal thanhToan;

    private BigDecimal tienThua;

    private String trangThai;

    private String maBn;

    private String tenBn;

    private String maBs;

    private String tenBs;

    public HoaDonResponse (HoaDonEntity hoaDon) {
        this.maHd = hoaDon.getMaHd();
        this.tienThua = hoaDon.getTienThua();
        this.ngayKham = hoaDon.getNgayKham();
        this.tongTien = hoaDon.getTongTien();
        this.thanhToan = hoaDon.getThanhToan();
        this.trangThai = hoaDon.getTrangThai();
        if (hoaDon.getBacSi() != null){
            Hibernate.initialize(hoaDon.getBacSi());
            this.maBs = hoaDon.getBacSi().getMaBs();
            this.tenBs = hoaDon.getBacSi().getTenBs();
        }
        if (hoaDon.getBenhNhan() != null){
            Hibernate.initialize(hoaDon.getBenhNhan());
            this.maBn = hoaDon.getBenhNhan().getMaBn();
            this.tenBn = hoaDon.getBenhNhan().getTenBn();
        }
    }
}
