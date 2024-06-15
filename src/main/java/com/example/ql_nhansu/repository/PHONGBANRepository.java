package com.example.ql_nhansu.repository;


import com.example.ql_nhansu.model.PHONGBAN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PHONGBANRepository extends JpaRepository<PHONGBAN, String> {
}
