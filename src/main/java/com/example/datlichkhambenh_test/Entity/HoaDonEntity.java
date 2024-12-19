package com.example.datlichkhambenh_test.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "HoaDon", schema = "dbo", catalog = "DatLichKhamBenh")
public class HoaDonEntity {
    @Id
    @Column(name = "MaHD")
    private String maHd;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaBN")
    private BenhNhanEntity benhNhan;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaBS")
    private BacSiEntity bacSi;
    @Basic
    @Column(name = "NgayKham")
    private Date ngayKham;
    @Basic
    @Column(name = "TongTien")
    private BigDecimal tongTien;
    @Basic
    @Column(name = "ThanhToan")
    private BigDecimal thanhToan;
    @Basic
    @Column(name = "TienThua")
    private BigDecimal tienThua;
    @Basic
    @Column(name = "TrangThai")
    private String trangThai;


}
