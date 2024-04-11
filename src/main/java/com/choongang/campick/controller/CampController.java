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
	
	// 예약 페이지
    @GetMapping("/camp_appointment")
    public String cmp_apt() {
        return "camp/camp_appointment"; 
    }
    
    // 예약 내역 페이지
    @GetMapping("/camp_result")
    public String camp_result() {
    	return "camp/camp_result"; 
    }
    
    // 예약 내역 목록 페이지
    @GetMapping("/cmp_apt_list")
    public String cmp_apt_list() {
    	return "camp/cmp_apt_list"; 
    }
    
    // 마이페이지 내 예약 내역 목록 페이지
    @GetMapping("/user_mypage_apt_list")
    public String user_mypage_apt_list() {
    	return "user/user_mypage_apt_list"; 
    }
    
    
	
}
