package com.example.demo.web.dto;

import com.example.demo.domain.Cust;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CustListResponseDto {
    private String custnum;
    private String custnm;
    private String anctnum;

    public CustListResponseDto(Cust entity) {
        this.custnum = entity.getCustnum();
        this.custnm = entity.getCustnm();
        this.anctnum = entity.getAcntnum();
    }
}
