package com.example.ql_nhansu.repository;

import com.example.ql_nhansu.model.NHANVIEN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NHANVIENRepository extends JpaRepository<NHANVIEN, String> {
}
