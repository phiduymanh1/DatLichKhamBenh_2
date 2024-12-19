package com.example.datlichkhambenh_test.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "ChiTietHoaDon", schema = "dbo", catalog = "DatLichKhamBenh")
public class ChiTietHoaDonEntity {
    @Id
    @Column(name = "MaCTHD")
    private int maCthd;
    @Basic
    @Column(name = "MaHD")
    private String maHd;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDVK")
    private DichVuKhamEntity dichVuKham;
    @Basic
    @Column(name = "SoLuong")
    private Integer soLuong;
    @Basic
    @Column(name = "GiaTien")
    private BigDecimal giaTien;


}
