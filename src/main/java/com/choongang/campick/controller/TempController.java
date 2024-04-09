package com.choongang.campick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.choongang.campick.model.Temp;
import com.choongang.campick.service.TempService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TempController {
	private final TempService service;
	
	//캠핑장 db에 넣기
	@GetMapping("weatherinsert")
	public String weatherinsert(Temp temp) throws Exception {
		service.tempinsert(temp);
		System.out.println("성공");
		return "./views/user/login.jsp";
	}
}
