package com.example.datlichkhambenh_test.Request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DichVuKhamRequest {
    private String maDvk;

    private String tenDvk;

    private String moTa;

    private BigDecimal giaTien;
}
