package com.example.demo.web;

import com.example.demo.service.CustService;
import com.example.demo.web.dto.CustListResponseDto;
import com.example.demo.web.dto.CustResponseDto;
import com.example.demo.web.dto.CustSaveRequestDto;
import com.example.demo.web.dto.CustUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CustApiController {

    private final CustService custService;

    @PostMapping("/api/v1/cust")
    public void save(@RequestBody CustSaveRequestDto requestDto) {
        custService.save(requestDto);
    }

    @PutMapping("/api/v1/cust/{id}")
    public void update(@PathVariable Long id, @RequestBody CustUpdateRequestDto requestDto) {
        custService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/cust/{id}")
    public void delete(@PathVariable Long id) {
        custService.delete(id);
    }

    @GetMapping("/api/v1/cust/{id}")
    public CustResponseDto findById(@PathVariable Long id) {
        return custService.findById(id);
    }

}
