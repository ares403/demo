package com.example.demo.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustTest {

    @Autowired
    SvcRepository svcRepository;

    @Test
    public void 안녕(){
        svcRepository.save(Svc.builder()
                .svcmgmtnum(7100000007L)
                .feeprodid("스탠다드5G")
                .custnum("01020828962")
                .build());

        List<Svc> svcList = svcRepository.findAll();
        Svc svc = svcList.get(0);
        assertThat(svc.getSvcmgmtnum()).isEqualTo(7100000007L);
    }
}