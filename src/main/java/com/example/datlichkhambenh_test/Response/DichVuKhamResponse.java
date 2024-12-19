package com.example.datlichkhambenh_test.Response;


import com.example.datlichkhambenh_test.Entity.DichVuKhamEntity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DichVuKhamResponse {

    private String maDvk;

    private String tenDvk;

    private String moTa;

    private BigDecimal giaTien;

    public  DichVuKhamResponse(DichVuKhamEntity dichVuKham){
        this.maDvk = dichVuKham.getMaDvk();
        this.tenDvk = dichVuKham.getTenDvk();
        this.moTa = dichVuKham.getMoTa();
        this.giaTien = dichVuKham.getGiaTien();
    }
}
