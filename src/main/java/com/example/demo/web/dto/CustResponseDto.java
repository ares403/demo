package com.example.demo.web.dto;

import com.example.demo.domain.Cust;
import lombok.Getter;

@Getter
public class CustResponseDto {
    private String custnum;
    private String custnm;
    private String acntnum;

    public CustResponseDto(Cust entity) {
        this.custnum = entity.getCustnum();
        this.custnm = entity.getCustnm();
        this.acntnum = entity.getAcntnum();
    }
}
