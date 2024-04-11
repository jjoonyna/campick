package com.choongang.campick.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public void campinsert(Camp camp) throws Exception {
		service.campinsert(camp);
		System.out.println("성공");
	}
	@GetMapping("camp_map")
	public String camp_map(){
		return "camp/camp_map";
	}
	@GetMapping("camp_list")
	public String camp_list(){
		return "camp/camp_list";
	}
	//캠핑장 목록 불러오기 기본(페이징 형식으로) 스크롤 방식으로 바뀔시 변경예정
	@GetMapping("camplist/{page}")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> camplist(@PathVariable("page") String page, Camp camp){
		Map map = new HashMap();
		if (page == null || page.equals("")) {
			page = "1";
		}
		int pageno = Integer.parseInt(page);
		int limit = 10;
		int listcount = (int)service.count();
		
		int start = (pageno-1) * limit;    // 각 page별 추출할 시작번호 : 0, 10, 20...
		camp.setStart(start);

		// 총페이지
		int pageCount = listcount / limit + ((listcount % limit == 0) ? 0 : 1);

		int startPage = ((pageno - 1) / 10) * limit + 1;  // 1, 11, 21...
		int endPage = startPage + 10 - 1; 				// 10, 20, 30...
		
		List<Camp> camplist = service.campList(camp);

		if (endPage > pageCount) {
			endPage = pageCount;
		}
			
		map.put("camplist", camplist);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("pageCount", pageCount);
		map.put("listcount", listcount);
		map.put("search", camp.getSearch());
		map.put("page",page );
		System.out.println(map.get("camplist"));
		System.out.println(map.get("search"));
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	
	
	
	
	//예약 페이지
    @GetMapping("/camp_appointment")
    public String loginPage() {
        return "camp/camp_appointment"; // 실제 JSP 파일의 경로에 맞게 수정해야 합니다.
    }
	
}
