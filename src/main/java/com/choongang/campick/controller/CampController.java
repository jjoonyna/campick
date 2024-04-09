package com.choongang.campick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.choongang.campick.model.Camp;
import com.choongang.campick.service.CampService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CampController {
	private final CampService service;
	
	//예약 페이지
    @GetMapping("/camp_appointment")
    public String loginPage() {
        return "camp/camp_appointment"; // 실제 JSP 파일의 경로에 맞게 수정해야 합니다.
    }
	
}
