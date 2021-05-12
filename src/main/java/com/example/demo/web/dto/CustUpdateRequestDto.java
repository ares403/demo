package com.example.demo.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustUpdateRequestDto {
    private String custnm;
    private String acntnum;

    @Builder
    public CustUpdateRequestDto(String custnm, String acntnum) {
        this.custnm = custnm;
        this.acntnum = acntnum;
    }
}
