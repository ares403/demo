package com.example.demo.web;

import com.example.demo.service.SvcService;
import com.example.demo.web.dto.SvcListResponseDto;
import com.example.demo.web.dto.SvcResponseDto;
import com.example.demo.web.dto.SvcSaveRequestDto;
import com.example.demo.web.dto.SvcUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SvcApiController {

    private final SvcService svcService;

    @PostMapping("/api/v1/svc")
    public void save(@RequestBody SvcSaveRequestDto requestDto) {
        svcService.save(requestDto);
    }

    @PutMapping("/api/v1/svc/{id}")
    public void update(@PathVariable Long id, @RequestBody SvcUpdateRequestDto requestDto) {
        svcService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/svc/{id}")
    public void delete(@PathVariable Long id) {
        svcService.delete(id);
    }

    @GetMapping("/api/v1/svc/{id}")
    public SvcResponseDto findById(@PathVariable Long id) {
        return svcService.findById(id);
    }

}
