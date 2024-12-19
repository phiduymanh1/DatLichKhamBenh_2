package com.example.datlichkhambenh_test.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "BenhNhan", schema = "dbo", catalog = "DatLichKhamBenh")
public class BenhNhanEntity {
    @Id
    @Column(name = "MaBN")
    private String maBn;
    @Basic
    @Column(name = "TenBN")
    private String tenBn;
    @Basic
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    @Basic
    @Column(name = "DiaChi")
    private String diaChi;
    @Basic
    @Column(name = "Email")
    private String email;
    @Basic
    @Column(name = "GioiTinh")
    private Boolean gioiTinh;
    @Basic
    @Column(name = "NgaySinh")
    private Date ngaySinh;


}
