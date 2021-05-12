package com.example.demo.web.dto;

import com.example.demo.domain.Prod;
import lombok.Getter;

@Getter
public class ProdResponseDto {
    private String prodid;
    private String prodnm;
    private String coclcd;

    public ProdResponseDto(Prod entity) {
        this.prodid = entity.getProdid();
        this.prodnm = entity.getProdnm();
        this.coclcd = entity.getCoclcd();
    }
}
