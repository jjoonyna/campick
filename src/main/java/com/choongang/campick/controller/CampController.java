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
	
	//캠핑장 db에 넣기
	@GetMapping("campinsert")
	public String campinsert(Camp camp) throws Exception {
		service.campinsert(camp);
		System.out.println("성공");
		return "./views/user/login.jsp";
	}
}
