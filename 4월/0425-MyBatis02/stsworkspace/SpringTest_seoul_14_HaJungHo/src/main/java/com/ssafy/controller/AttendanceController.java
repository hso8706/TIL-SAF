package com.ssafy.controller;

import com.ssafy.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttendanceController {
    @Autowired
    AttendanceService service;

    @GetMapping(value = {"/","/index"})
    public String index(Model model){
        return "index";
    }
}
