package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SvcRepository extends JpaRepository<Svc, Long> {

    @Query("SELECT p FROM Svc p ORDER BY p.id DESC")
    List<Svc> findAllDesc();

//    @Query("SELECT s FROM Svc s inner join s.prod p")
//    List<Svc> findAllDesc2();
}
