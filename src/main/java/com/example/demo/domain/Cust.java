package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Cust {

    @Id
    @Column(length = 12, nullable = false, name = "CUST_NUM")
    private String custnum;

    @Column(nullable = false)
    private String custnm;
    private String acntnum;

    @Builder
    public Cust(String custnum, String custnm, String acntnum) {
        this.custnum = custnum;
        this.custnm = custnm;
        this.acntnum = acntnum;
    }

    public void update(String custnm, String acntnum) {
        this.custnm = custnm;
        this.acntnum = acntnum;
    }

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "CUST_NUM")
//    private List<Svc> getSvc(){
//        return getSvc();
//    }

}
