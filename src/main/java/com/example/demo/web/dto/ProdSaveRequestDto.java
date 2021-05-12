package com.example.demo.web.dto;

import com.example.demo.domain.Prod;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProdSaveRequestDto {

    private String prodid;
    private String prodnm;
    private String coclcd;

    @Builder
    public ProdSaveRequestDto(String prodid, String prodnm, String coclcd) {
        this.prodid = prodid;
        this.prodnm = prodnm;
        this.coclcd = coclcd;
    }

    public Prod toEntity() {
        return Prod.builder()
                .prodid(prodid)
                .prodnm(prodnm)
                .coclcd(coclcd)
                .build();
    }
}
