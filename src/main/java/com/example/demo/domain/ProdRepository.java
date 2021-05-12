package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdRepository extends JpaRepository<Prod, Long> {

//    @Query("SELECT p FROM Prod p ORDER BY p.id DESC")
//    List<Prod> findAllDesc();

}
