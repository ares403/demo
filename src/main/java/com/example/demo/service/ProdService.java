package com.example.demo.service;

import com.example.demo.domain.Prod;
import com.example.demo.domain.ProdRepository;
import com.example.demo.web.dto.ProdResponseDto;
import com.example.demo.web.dto.ProdSaveRequestDto;
import com.example.demo.web.dto.ProdUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProdService {

    private final ProdRepository prodRepository;

    @Transactional
    public void save(ProdSaveRequestDto requestDto) {
        prodRepository.save(requestDto.toEntity()).getProdid();
    }

    @Transactional
    public void update(Long id, ProdUpdateRequestDto requestDto) {
        Prod prod = prodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        prod.update(requestDto.getProdnm(), requestDto.getCoclcd());
    }

    @Transactional
    public void delete (Long id) {
        Prod prod = prodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        prodRepository.delete(prod);
    }

    @Transactional(readOnly = true)
    public ProdResponseDto findById(Long id) {
        Prod entity = prodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new ProdResponseDto(entity);
    }
}
