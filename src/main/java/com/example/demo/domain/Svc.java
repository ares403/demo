package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Svc {

    @Id
    @Column(length = 10, nullable = false)
    private Long svcmgmtnum;

    @Column(nullable = true, name = "PROD_ID")
    private String feeprodid;

    @Column(length = 12, nullable = false, name = "CUST_NUM")
    private String custnum;

    @Builder
    public Svc(Long svcmgmtnum, String feeprodid, String custnum) {
        this.svcmgmtnum = svcmgmtnum;
        this.feeprodid = feeprodid;
        this.custnum = custnum;
    }

    public void update(String feeprodid, String custnum) {
        this.feeprodid = feeprodid;
        this.custnum = custnum;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROD_ID", insertable = false, updatable = false)
    private Prod prod;

//
//    @ManyToOne
//    @JoinColumn(name = "CUST_NUM", insertable = false, updatable = false)
//    private Cust cust;

}