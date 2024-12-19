package com.example.datlichkhambenh_test.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "BacSi", schema = "dbo", catalog = "DatLichKhamBenh")
public class BacSiEntity {
    @Id
    @Column(name = "MaBS")
    private String maBs;
    @Basic
    @Column(name = "TenBS")
    private String tenBs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaCV")
    private ChucVuEntity chucVu;

    @Basic
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    @Basic
    @Column(name = "Email")
    private String email;
    @Basic
    @Column(name = "ChuyenKhoa")
    private String chuyenKhoa;


}
