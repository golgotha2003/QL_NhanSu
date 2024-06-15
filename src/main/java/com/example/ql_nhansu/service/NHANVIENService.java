package com.example.ql_nhansu.service;

import com.example.ql_nhansu.model.NHANVIEN;
import com.example.ql_nhansu.repository.NHANVIENRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NHANVIENService {
    private final NHANVIENRepository nhanvienRepository;

    public List<NHANVIEN> getAll(){
        return nhanvienRepository.findAll();
    }

    public Optional<NHANVIEN> getNHANVIENById(String id){
        return nhanvienRepository.findById(id);
    }

    public void addNHANVIEN(NHANVIEN nhanvien){
        nhanvienRepository.save(nhanvien);
    }

    public void updateNHANVIEN(@NotNull NHANVIEN nhanvien){
        NHANVIEN existingNV = nhanvienRepository.findById(nhanvien.getMa_NV()).orElseThrow(() -> new IllegalStateException("Không tìm thấy nhân viên này"));
        existingNV.setTen_NV(nhanvien.getTen_NV());
        existingNV.setPhai(nhanvien.getPhai());
        existingNV.setNoi_Sinh(nhanvien.getNoi_Sinh());
        existingNV.setPhong_Ban(nhanvien.getPhong_Ban());
        existingNV.setLuong(nhanvien.getLuong());
        nhanvienRepository.save(existingNV);
    }

    public void deleteNHANVIEN(String id){
        if(!nhanvienRepository.existsById(id)){
            throw new IllegalStateException("Không tìm thấy nhân viên này");
        }
        nhanvienRepository.deleteById(id);
    }
}
