package com.choongang.campick.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choongang.campick.model.Camp;
import com.choongang.campick.model.User;
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
	//캠핑장 목록 불러오기 기본(페이징 형식으로) 스크롤 방식으로 바뀔시 변경예정
	@GetMapping("camplist/{page}")
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
		map.put("page",pageno );
		System.out.println(page);
		System.out.println(map.get("listcount"));
		System.out.println(map.get("camplist"));
		System.out.println(map.get("search"));
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
	
	
	@GetMapping("camp_content")
	public String camp_content(){
		return "camp/camp_content";
	
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
	//캠핑장 상세페이지
	   @GetMapping("/cmp_content/{contentId}")
	    @ResponseBody
	    public ResponseEntity<Map<String, Object>> cmp_content(@RequestBody Camp camp, @PathVariable("contentid") String contentid ) {
	        Camp db = service.getCamp(contentid); // 상세정보 구하기

	        Map<String, Object> map = new HashMap<>();
	        map.put("db", db);

	        return new ResponseEntity<>(map, HttpStatus.OK);
	    }

	   //상세페이지 아아디
		@PostMapping("/contentId")
		@ResponseBody
		public ResponseEntity<Integer> login_user(@RequestBody Camp camp,HttpSession session) {
			//	@PathVariable("user_id") String user_id

			System.out.println("contentId : " + camp.getContentId()); // 입력한 아이디가 제대로 들어가는지 확인

			Camp db = service.selectcontent( camp.getContentId()); // 회원이 있는지 없는지 확인
				int result = 0;
			
					// 따라서 위의 두 조건절이 true 값이어야 로그인 가능함.
					System.out.println("완료!");
					session.setAttribute("contentid", db.getContentId());
					return new ResponseEntity<>(result, HttpStatus.OK);
					}

		}

	   
	   
	   
	   
	
