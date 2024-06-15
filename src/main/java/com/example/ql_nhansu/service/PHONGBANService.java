package com.example.ql_nhansu.service;

import com.example.ql_nhansu.model.PHONGBAN;
import com.example.ql_nhansu.repository.PHONGBANRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PHONGBANService {
    private final PHONGBANRepository phongbanRepository;

    public List<PHONGBAN> getAll(){
        return phongbanRepository.findAll();
    }

    public Optional<PHONGBAN> getPHONGBANById(String id){
        return phongbanRepository.findById(id);
    }

    public void addPHONGBAN(PHONGBAN phongban){
        phongbanRepository.save(phongban);
    }

    public void updatePHONGBAN(@NotNull PHONGBAN phongban){
        PHONGBAN existingPB = phongbanRepository.findById(phongban.getMa_Phong()).orElseThrow(() -> new IllegalStateException("Không tìm thấy phòng ban này"));
        existingPB.setTen_Phong(phongban.getTen_Phong());

        phongbanRepository.save(existingPB);
    }

    public void deletePHONGBAN(String id){
        if(!phongbanRepository.existsById(id)){
            throw new IllegalStateException("Không tìm thấy nhn viên này");
        }
        phongbanRepository.deleteById(id);
    }
}
