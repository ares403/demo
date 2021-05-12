package com.example.demo.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Prod {

    @Id
    @Column(nullable = false, name = "PROD_ID")
    private String prodid;

    @Column(nullable = false)
    private String prodnm;
    private String coclcd;

    @Builder
    public Prod(String prodid, String prodnm, String coclcd, List<Svc> svc) {
        this.prodid = prodid;
        this.prodnm = prodnm;
        this.coclcd = coclcd;
        this.svc = svc;
    }

    public void update(String prodnm, String coclcd) {
        this.prodnm = prodnm;
        this.coclcd = coclcd;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prod", orphanRemoval = true)
    private List<Svc> svc ;

}
