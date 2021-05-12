package com.example.demo.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SvcUpdateRequestDto {
    private String custnum;
    private String feeprodid;

    @Builder
    public SvcUpdateRequestDto(String custnum, String feeprodid) {
        this.custnum = custnum;
        this.feeprodid = feeprodid;
    }
}
