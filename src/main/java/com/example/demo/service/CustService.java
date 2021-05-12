package com.example.demo.service;

import com.example.demo.domain.Cust;
import com.example.demo.domain.CustRepository;
import com.example.demo.web.dto.CustListResponseDto;
import com.example.demo.web.dto.CustResponseDto;
import com.example.demo.web.dto.CustSaveRequestDto;
import com.example.demo.web.dto.CustUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustService {

    private final CustRepository custRepository;

    @Transactional
    public String save(CustSaveRequestDto requestDto) {
        return custRepository.save(requestDto.toEntity()).getCustnum();
    }

    @Transactional
    public Long update(Long id, CustUpdateRequestDto requestDto) {
        Cust cust = custRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        cust.update(requestDto.getCustnm(), requestDto.getAcntnum());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Cust cust = custRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        custRepository.delete(cust);
    }

    @Transactional(readOnly = true)
    public CustResponseDto findById(Long id) {
        Cust entity = custRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new CustResponseDto(entity);
    }
}
