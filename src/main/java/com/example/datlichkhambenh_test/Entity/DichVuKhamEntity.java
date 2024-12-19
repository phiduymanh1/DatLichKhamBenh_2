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
@Table(name = "DichVuKham", schema = "dbo", catalog = "DatLichKhamBenh")
public class DichVuKhamEntity {
    @Id
    @Column(name = "MaDVK")
    private String maDvk;
    @Basic
    @Column(name = "TenDVK")
    private String tenDvk;
    @Basic
    @Column(name = "MoTa")
    private String moTa;
    @Basic
    @Column(name = "GiaTien")
    private BigDecimal giaTien;


}
