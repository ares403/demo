package com.example.demo.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProdUpdateRequestDto {

    private String prodnm;
    private String coclcd;

    @Builder
    public ProdUpdateRequestDto(String prodnm, String coclcd) {
        this.prodnm = prodnm;
        this.coclcd = coclcd;
    }

}
