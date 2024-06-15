package com.example.ql_nhansu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhanvien")
public class NHANVIEN {
    @Id
    @Column(name = "manv", length = 3)
    private String Ma_NV;

    @NotBlank(message = "Tên là bắt buộc")
    @Column(name = "tennv", length = 100)
    private String Ten_NV;

    @Column(name = "phai", length = 3)
    private String Phai;

    @Column(name = "noisinh", length = 200)
    private String Noi_Sinh;

    @ManyToOne()
    @JoinColumn(name = "maphong")
    private PHONGBAN Phong_Ban;

    @Column(name = "luong")
    private int Luong;
}
