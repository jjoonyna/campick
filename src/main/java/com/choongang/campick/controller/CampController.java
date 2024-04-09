package com.choongang.campick.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	@GetMapping("")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> camplist(){
		Map map = new HashMap();
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	//예약 페이지
    @GetMapping("/camp_appointment")
    public String loginPage() {
        return "camp/camp_appointment"; // 실제 JSP 파일의 경로에 맞게 수정해야 합니다.
    }
	
}
