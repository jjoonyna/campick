package com.choongang.campick.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choongang.campick.model.Camp;
import com.choongang.campick.service.CampService;

import jakarta.servlet.http.HttpSession;
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
	// 일반 회원 예약 상세 조회 캠핑정보 가져오기
	@GetMapping("select_user_camp/{contentId}")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> select_user_camp(@PathVariable("contentId") String contentId){
		Map map = new HashMap();
		Camp db = service.selectUserCamp(contentId); // 회원이 있는지 없는지 확인
		map.put("facltNm", db.getFacltNm());
		map.put("addr1", db.getAddr1());
		map.put("cmp_staydate", db.getCmp_staydate());
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
//			@GetMapping("select_user_camp/{contentId}")
//			@ResponseBody
//			public ResponseEntity<Map<String,Object>> select_user_camp(@PathVariable("contentId") String contentId){
//				Map map = new HashMap();
//				Camp db = service.selectUserCamp(contentId); // 회원이 있는지 없는지 확인
//				map.put("facltNm", db.getFacltNm());
//				map.put("addr1", db.getAddr1());
//				map.put("cmp_staydate", db.getCmp_staydate());
//				return new ResponseEntity<>(map,HttpStatus.OK);
//			}
	
	//캠핑장 목록 불러오기 기본(페이징 형식으로) 스크롤 방식으로 바뀔시 변경예정
	@PostMapping("camplist/{page}")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> camplist(@PathVariable("page") String page,@RequestBody Camp camp){
		
		
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
		
		System.out.println("search: "+camp.getSearch());
		System.out.println("induty: "+camp.getInduty());
		System.out.println("doNm: "+camp.getDoNm());
		System.out.println("sigun: "+camp.getSigunguNm());
		
		List<Camp> camplist = service.campList(camp);
		System.out.println("리스트: "+camplist);
		if (endPage > pageCount) {
			endPage = pageCount;
		}
			
		map.put("camplist", camplist);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("pageCount", pageCount);
		map.put("listcount", listcount);
		map.put("search", camp.getSearch());
		map.put("induty", camp.getInduty());
		map.put("sigunguNm", camp.getSigunguNm());
		map.put("doNm", camp.getDoNm());
		map.put("page",pageno );
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	

	
	// 사업자 소유 캠핑장 등록하기
	@PostMapping("/insert_biz_cmp")
	@ResponseBody
	public ResponseEntity<Integer> insert_biz_cmp(@RequestBody Camp camp){
	System.out.println("캠핑장 등록");
	int result = service.insertBizCmp(camp);
	System.out.println("result : " + result);
	return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("camp_content/{contentId}")
	public String camp_content(@PathVariable("contentId") String contentId, Model model){
		
		model.getAttribute(contentId);
		return "camp/camp_content";
	}
	
	
	//캠핑장 상세페이지
	 @GetMapping(value = "campcontent/{contentId}", produces = "application/json")
	 @ResponseBody
     public ResponseEntity<Map<String, Object>> campcontent(@PathVariable("contentId") String contentId ) {
		 
         Camp db = service.selectUserCamp(contentId); // 상세정보 구하기
         System.out.println(db);
         
         Map map = new HashMap<>();
         map.put("contentId", db.getContentId());
         map.put("user_id", db.getUser_id());
         map.put("facltNm", db.getFacltNm());
         map.put("lctCl", db.getLctCl());
         map.put("intro", db.getIntro());
         map.put("featureNm", db.getFeatureNm());
         map.put("induty", db.getInduty());
         map.put("zipcode", db.getZipcode());
         map.put("addr1", db.getAddr1());
         map.put("tel", db.getTel());
         map.put("homepage", db.getHomepage());
         map.put("toietCo", db.getToiletCo());
         map.put("swrmCo", db.getSwrmCo());
         map.put("wtrplCo", db.getWtrplCo());
         map.put("brazierCl", db.getBrazierCl());
         map.put("sbrsCl", db.getSbrsCl());
         map.put("sbrsEtc", db.getSbrsEtc());
         map.put("posblFcltyCl", db.getPosblFcltyCl());
         map.put("extshrCo", db.getExtshrCo());
         map.put("themaEnvrnCl", db.getThemaEnvrnCl());
         map.put("animalCmgCl", db.getAnimalCmgCl());
         map.put("firstImageUrl", db.getFirstImageUrl());
         map.put("cmp_pic", db.getCmp_pic());
         map.put("cmp_maxpp", db.getCmp_maxpp());
         map.put("cmp_staydate", db.getCmp_staydate());
         map.put("cmp_price", db.getCmp_price());
         map.put("mapX", db.getMapX());
         map.put("mapY", db.getMapY());

         return new ResponseEntity<>(map, HttpStatus.OK);
     }
	//캠핑장 상세페이지
	 @GetMapping("campcontent2/{contentId}")
	 @ResponseBody
     public ResponseEntity<Map<String, Object>> campcontent2(@PathVariable("contentId") String contentId ) {
		 
         Camp db = service.selectUserCamp(contentId); // 상세정보 구하기
         System.out.println(db);
         
         Map map = new HashMap<>();
         map.put("contentId", db.getContentId());
         map.put("mapX", db.getMapX());
         map.put("mapY", db.getMapY());

         return new ResponseEntity<>(map, HttpStatus.OK);
     }
	
	/*
	 * 사업자 소유 캠핑장 삭제하기
	 */
	@PostMapping("/delete_biz_cmp")
	@ResponseBody
	public ResponseEntity<Integer> delete_biz_cmp(@RequestBody Camp camp, HttpSession session) {

		int result = 0; // 결과 값 받는 객체 선언

		Camp db = service.selectBizCmp(camp.getContentId()); // select된 회원 값을 db 객체에 넣는다
			// contentid 값만 가져와서 비교하여 삭제하기
		if (db.getContentId().equals(camp.getContentId())) { // 암호화된 비밀번호와 회원이 입력한 값을 인코딩하여 비교, 일치할 경우
			result = service.deleteBizCmp(camp.getContentId()); // // delete를 result 객체에 대입
			session.invalidate();
		} else { // 일치하지 않을 경우, result = -1 반환
			result = -1;
		}
		System.out.println("result:" + result); // 결과값 test 출력

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
