package com.example.ql_nhansu.controller;

import com.example.ql_nhansu.service.NHANVIENService;
import com.example.ql_nhansu.service.PHONGBANService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private NHANVIENService nhanvienService;
    @Autowired
    private PHONGBANService phongbanService;

    @GetMapping
    public String showNHANVIENList(Model model){
        model.addAttribute("nhanvien", nhanvienService.getAll());
        return "/nhanvien/nhanvien-list";
    }
}
