package com.example.demo.service;

import com.example.demo.domain.Svc;
import com.example.demo.domain.SvcRepository;
import com.example.demo.web.dto.SvcListResponseDto;
import com.example.demo.web.dto.SvcResponseDto;
import com.example.demo.web.dto.SvcSaveRequestDto;
import com.example.demo.web.dto.SvcUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SvcService {
    private final SvcRepository svcRepository;

    @Transactional
    public void save(SvcSaveRequestDto requestDto) {
        svcRepository.save(requestDto.toEntity()).getSvcmgmtnum();
    }

    @Transactional
    public void update(Long id, SvcUpdateRequestDto requestDto) {
        Svc svc = svcRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        svc.update(requestDto.getFeeprodid(), requestDto.getCustnum());

    }

    @Transactional
    public void delete (Long id) {
        Svc svc = svcRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        svcRepository.delete(svc);
    }

    @Transactional(readOnly = true)
    public SvcResponseDto findById(Long id) {
        Svc entity = svcRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new SvcResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<SvcListResponseDto> findAllDesc() {
        return svcRepository.findAllDesc().stream()
                .map(SvcListResponseDto::new)
                .collect(Collectors.toList());
    }

}
