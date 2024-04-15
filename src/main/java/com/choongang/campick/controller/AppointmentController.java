package com.choongang.campick.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choongang.campick.model.Appointment;
import com.choongang.campick.model.Camp;
import com.choongang.campick.service.AppointmentService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class AppointmentController {

	// 서비스
		private final AppointmentService service;
//
//		//예약 조회(마이페이지)
//		@GetMapping("/insert_userappointment")
		
		// 일반 회원 예약 하기
//		@PostMapping("/apt_user_cmp")
//		@ResponseBody
//		public ResponseEntity<Integer> apt_user_cmp(@RequestBody Appointment apt){
//			System.out.println("예약을 할거예요!");
//			int result = service.aptUserCamp(apt);
//			System.out.println("result : " + result);
//			
//			return new ResponseEntity<>(result, HttpStatus.OK);
//		}
//
//		// 일반 회원 예약 상세 조회
//		@GetMapping("/select_user_apt")
//		@ResponseBody
//		public ResponseEntity<Map<String,Object>> select_user_apt(HttpSession session){
//			Map map = new HashMap();
//			String user_id = (String)session.getAttribute("user_id");
//			System.out.println(user_id);
//			Appointment db = service.selectUserApt(user_id); // 회원이 있는지 없는지 확인
//			map.put("apt_no", db.getApt_no());
//			map.put("cmp_no", db.getCmp_no());
//			map.put("user_id", db.getUser_id());
//			map.put("user_nm", db.getUser_nm());
//			map.put("apt_date", db.getApt_date());
//			map.put("apt_pp", db.getApt_pp());
//			map.put("apt_req", db.getApt_req());
//			map.put("apt_staydate", db.getApt_staydate());
//			map.put("apt_price", db.getApt_price());
//			map.put("apt_at", db.getApt_at());
//			
//			return new ResponseEntity<>(map,HttpStatus.OK);
//		}
//		
//	
//
		// 일반 회원 예약 상세 조회
		@GetMapping("/select_user_apt")
		@ResponseBody
		public ResponseEntity<Map<String,Object>> select_user_apt(HttpSession session){
			Map map = new HashMap();
			String user_id = (String)session.getAttribute("user_id");
			System.out.println(user_id);
			Appointment db = service.selectUserApt(user_id); // 회원이 있는지 없는지 확인
			map.put("cmp_no", db.getCmp_no());
			map.put("apt_no", db.getApt_no());
			map.put("user_id", db.getUser_id());
			map.put("apt_date", db.getApt_date());
			map.put("apt_pp", db.getApt_pp());
			map.put("apt_req", db.getApt_req());
			map.put("apt_staydate", db.getApt_staydate());
			map.put("apt_price", db.getApt_price());
			map.put("apt_at", db.getApt_at());
			
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		
	

//		//예약 취소
//	
//		@PostMapping("/cancel_user_apt")
//		@ResponseBody
//		public ResponseEntity<Integer> cancel_user_apt(@RequestBody String reservationId) {
//
//		    int result = 0; // 결과 값 받는 객체 선언
//
//		    System.out.println("Deleting reservation with ID: " + reservationId); // 예약 ID 출력해보기
//
//		    Appointment db = service.selectReservation(user.getUser_id()); // select된 예약 값을 db 객체에 넣는다
//
//		    if (db != null) { // 예약이 존재하는 경우
//		        result = service.deleteReservation(user.getUser_id()); // 예약을 삭제하는 서비스 메소드 호출
//		    } else { // 예약이 존재하지 않는 경우
//		        result = -1; // 삭제 실패
//		    }
//
//		    System.out.println("Result: " + result); // 결과값 출력
//
//		    return new ResponseEntity<>(result, HttpStatus.OK);
//		}
//
//		
//		//사업자 예약 조회(마이페이지)
//		@GetMapping("/insert_bizappointment")
//		@ResponseBody
//		public ResponseEntity<Map<String,Object>> insert_bizappointment(HttpSession session){
//			Map map = new HashMap();
//			String user_id = (String)session.getAttribute("user_id");
//			System.out.println(user_id);
//			Appointment db = service.selectbizAppointment(user_id); // 회원이 있는지 없는지 확인
//			map.put("user_id", db.getUser_id());
//			map.put("user_nm", db.getUser_nm());
//			map.put("apt_date", db.getApt_date());
//			map.put("apt_pp", db.getApt_pp());
//			map.put("apt_req", db.getApt_req());
//			map.put("apt_staydate", db.getApt_staydate());
//			map.put("apt_price", db.getApt_price());
//			map.put("apt_at", db.getApt_at());
//			
//			return new ResponseEntity<>(map,HttpStatus.OK);
//		}
//		
//		
//		//사업자 예약 삭제(마이페이지)
//		@PostMapping("/delete_bizappointment")
//		@ResponseBody
//		public ResponseEntity<Integer> delete_bizappointment(@RequestBody String reservationId) {
//
//		    int result = 0; // 결과 값 받는 객체 선언
//
//		    System.out.println("Deleting reservation with ID: " + reservationId); // 예약 ID 출력해보기
//
//		    Appointment db = service.selectReservation(user.getUser_id()); // select된 예약 값을 db 객체에 넣는다
//
//		    if (db != null) { // 예약이 존재하는 경우
//		        result = service.deleteReservation(user.getUser_id()); // 예약을 삭제하는 서비스 메소드 호출
//		    } else { // 예약이 존재하지 않는 경우
//		        result = -1; // 삭제 실패
//		    }
//
//		    System.out.println("Result: " + result); // 결과값 출력
//
//		    return new ResponseEntity<>(result, HttpStatus.OK);
//		}
	
		
		
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
	    

	    
		//예약 페이지
	    @PostMapping("/camp_appointment/{contentId}")
	    @ResponseBody
	    public ResponseEntity<Map<String, Object>> camp_appointment(@PathVariable("contentId") int contentId) {
	    	Map map = new HashMap();
	    	
	    	Camp db = service.selectapoint(contentId);
	    	map.put("firstImageUrl", db.getFirstImageUrl());
	    	map.put("facltNm", db.getFacltNm());
	    	map.put("intro", db.getIntro());
	    	map.put("faclNm", db.getFacltNm());
	    	map.put("price", db.getCmp_price());
	    	map.put("cmp_maxpp", db.getCmp_maxpp());
	    	
	    	
	    	return new ResponseEntity<>(map,HttpStatus.OK); // 실제 JSP 파일의 경로에 맞게 수정해야 합니다.
	    }

		 // 일반 회원 예약 하기
	      @PostMapping("/apt_user_cmp")
	      @ResponseBody
	      public ResponseEntity<Integer> apt_user_cmp(@RequestBody Appointment apt){
	         
	         System.out.println("예약을 할거예요!");
	         int result = service.aptUserCamp(apt);
	         System.out.println("result : " + result);
	         
	         return new ResponseEntity<>(result, HttpStatus.OK);
	      }
	      
	      @PostMapping("/camp_results/{user_id}")
		    @ResponseBody
		    public ResponseEntity<Map<String, Object>> camp_results(@PathVariable("user_id") String user_id) {
		    	Map map = new HashMap();
		    	
		    	Camp db = service.selectresult(user_id);
		    	Appointment ap = service.selectap(user_id);
		    	map.put("facltNm", db.getFacltNm());
		    	map.put("addr1", db.getAddr1());
		    	map.put("apt_startdate", ap.getApt_startdate());
		    	map.put("apt_staydate", ap.getApt_staydate());
		    	map.put("apt_pp", ap.getApt_pp());
		    	map.put("apt_req", ap.getApt_req());
		    	map.put("apt_price", ap.getApt_price());
		    	
		    	
		    	return new ResponseEntity<>(map,HttpStatus.OK); // 실제 JSP 파일의 경로에 맞게 수정해야 합니다.
		    }

	    
	 
}

	

