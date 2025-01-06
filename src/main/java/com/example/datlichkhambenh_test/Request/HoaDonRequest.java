package com.example.datlichkhambenh_test.Request;

import com.example.datlichkhambenh_test.Response.HoaDonResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class HoaDonRequest {

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
//    public HoaDonRequest(HoaDonResponse response) {
//        this.maHd = response.getMaHd();
//        this.ngayKham = response.getNgayKham();
//        this.tongTien = response.getTongTien();
//        this.thanhToan = response.getThanhToan();
//        this.tienThua = response.getTienThua();
//        this.trangThai = response.getTrangThai();
//        this.maBn = response.getMaBn();
//        this.maBs = response.getMaBs();
//    }

}
