package com.example.datlichkhambenh_test.Request;

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
}
