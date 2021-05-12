package com.example.demo.web;

import com.example.demo.domain.Prod;
import com.example.demo.domain.ProdRepository;
import com.example.demo.domain.Svc;
import com.example.demo.domain.SvcRepository;
import com.example.demo.web.dto.SvcSaveRequestDto;
import com.example.demo.web.dto.SvcUpdateRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SvcApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private SvcRepository svcRepository;

    @Autowired
    private ProdRepository prodRepository;

    @After
    public void tearDown() throws Exception{
//        svcRepository.deleteAll();
    }

//    @Test
//    public void Svc_upload() throws Exception{
//        SvcSaveRequestDto requestDto = SvcSaveRequestDto.builder()
//                .svcmgmtnum(7100000007L)
//                .feeprodid("스탠다드")
//                .custnum("01020828962")
//                .build();
//
//        String url = "http://localhost:" + port + "/api/v1/svc";
//
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
//
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//        List<Svc> all = svcRepository.findAll();
//        assertThat(all.get(0).getSvcmgmtnum()).isEqualTo(7100000007L);
//        assertThat(all.get(0).getCustnum()).isEqualTo("01020828962");
//    }
//
//    @Test
//    public void Svc_update() throws Exception{
//        Svc savedSvc = svcRepository.save(Svc.builder()
//        .svcmgmtnum(7100000007L)
//        .feeprodid("스탠다드")
//        .custnum("01020828962")
//        .build());
//
//        Long updateId = savedSvc.getId();
//        String expectedFeeprodid = "스탠다드2";
//        String expectedCustnum = "1111111111";
//
//        SvcUpdateRequestDto requestDto = SvcUpdateRequestDto.builder()
//                .feeprodid(expectedFeeprodid)
//                .custnum(expectedCustnum)
//                .build();
//
//        String url = "http://localhost:" + port + "/api/v1/svc/" + updateId;
//
//        HttpEntity<SvcUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
//
//        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, long.class);
//
//
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        List<Svc> all = svcRepository.findAll();
//        assertThat(all.get(0).getFeeprodid()).isEqualTo(expectedFeeprodid);
//        assertThat(all.get(0).getCustnum()).isEqualTo(expectedCustnum);
//    }

//    @Transactional
    @Test
    public void SVC_join() throws Exception{
        Svc savedSvc = Svc.builder()
        .svcmgmtnum(7100000007L)
        .feeprodid("A00001")
        .custnum("01020828962")
        .build();
        List<Svc> list= new ArrayList<>();
        list.add(savedSvc);
        Prod prod = Prod.builder()
                .prodid("A00001")
                .prodnm("스탠다드")
                .coclcd("T")
                .svc(list)
                .build();
//
        prodRepository.save(prod);

//        System.out.println(prodRepository.findAll().get(0).getSvc().get(0).getSvcmgmtnum());
//
//
        System.out.println(svcRepository.findAll().get(0).getProd().getProdnm());

    }
}
