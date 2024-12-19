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
@Table(name = "LichKham", schema = "dbo", catalog = "DatLichKhamBenh")
public class LichKhamEntity {
    @Id
    @Column(name = "MaLK")
    private String maLk;
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
    @Column(name = "GioKham")
    private Date gioKham;
    @Basic
    @Column(name = "TrangThai")
    private String trangThai;


}
