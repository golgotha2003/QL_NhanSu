package com.example.ql_nhansu.controller;

import com.example.ql_nhansu.model.NHANVIEN;
import com.example.ql_nhansu.service.NHANVIENService;
import com.example.ql_nhansu.service.PHONGBANService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NHANVIENController {
    @Autowired
    private NHANVIENService nhanvienService;
    @Autowired
    private PHONGBANService phongbanService;

    @GetMapping("/nhanvien")
    public String showNHANVIENList(Model model){
        model.addAttribute("nhanvien", nhanvienService.getAll());
        return "/nhanvien/nhanvien-list";
    }

    @GetMapping("/nhanvien/add")
    public String showNHANVIENForm(Model model){
        model.addAttribute("nhanvien", new NHANVIEN());
        model.addAttribute("phongban", phongbanService.getAll());
        return "/nhanvien/add-nhanvien";
    }

    @PostMapping("/nhanvien/add")
    public String addNHANVIEN(@Valid NHANVIEN nhanvien, BindingResult result){
        if(result.hasErrors()){
            return "/nhanvien/add-nhanvien";
        }
        nhanvienService.addNHANVIEN(nhanvien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/nhanvien/update/{id}")
    public String showUpdateForm(@PathVariable String id, Model model){
        NHANVIEN nhanvien = nhanvienService.getNHANVIENById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy nhân viên này"));
        model.addAttribute("nhanvien", nhanvien);
        model.addAttribute("phongban", phongbanService.getAll());
        return "/nhanvien/update-nhanvien";
    }

    @PostMapping("/nhanvien/update/{id}")
    public String updateNHANVIEN(@PathVariable String id, @Valid NHANVIEN nhanvien, BindingResult result){
        if(result.hasErrors()){
            nhanvien.setMa_NV(id);
            return "/nhanvien/update-nhanvien";
        }
        nhanvienService.updateNHANVIEN(nhanvien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/nhanvien/delete/{id}")
    public String deleteNHANVIEN(@PathVariable String id){
        nhanvienService.deleteNHANVIEN(id);
        return "redirect:/nhanvien";
    }
}
