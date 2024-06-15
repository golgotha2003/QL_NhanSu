package com.example.ql_nhansu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phongban")
public class PHONGBAN {
    @Id
    @Column(name = "maphong", length = 2)
    private String Ma_Phong;

    @NotBlank(message = "Tên là bắt buộc")
    @Column(name = "tenphong", length = 30)
    private String Ten_Phong;

    @OneToMany(mappedBy = "Phong_Ban", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<NHANVIEN> Nhan_Vien;
}
