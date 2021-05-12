package com.example.demo.web.dto;

import com.example.demo.domain.Cust;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustSaveRequestDto {
    private String custnum;
    private String custnm;
    private String acntnum;

    @Builder
    public CustSaveRequestDto(String custnum, String custnm, String acntnum) {
        this.custnum = custnum;
        this.custnm = custnm;
        this.acntnum = acntnum;
    }

    public Cust toEntity() {
        return Cust.builder()
                .custnum(custnum)
                .custnm(custnm)
                .acntnum(acntnum)
                .build();
    }

}
