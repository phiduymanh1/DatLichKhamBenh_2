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
@Table(name = "ChucVu", schema = "dbo", catalog = "DatLichKhamBenh")
public class ChucVuEntity {
    @Id
    @Column(name = "MaCV")
    private String maCv;
    @Basic
    @Column(name = "TenCV")
    private String tenCv;


}
