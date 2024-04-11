package com.choongang.campick.controller;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.logging.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choongang.campick.model.Appointment;
import com.choongang.campick.model.Camp;
import com.choongang.campick.model.User;
import com.choongang.campick.service.AppointmentService;
import com.choongang.campick.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class AppointmentController {

	// 서비스
		private final AppointmentService service;
	

//
//		//예약 조회
//		@GetMapping("/insert_userappointment")
//		@ResponseBody
//		public ResponseEntity<Map<String,Object>> insert_userappointment(HttpSession session){
//			Map map = new HashMap();
//			String user_id = (String)session.getAttribute("user_id");
//			System.out.println(user_id);
//			Appointment db = service.selectuserAppointment(user_id); // 회원이 있는지 없는지 확인
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
//		//예약 삭제
//	
//		@PostMapping("/delete_userappointment")
//		@ResponseBody
//		public ResponseEntity<Integer> delete_userappointment(@RequestBody String reservationId) {
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
//		//사업자 예약 조회
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
//		//사업자 예약 삭제
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
	    
	    // 마이페이지 내 예약 내역 목록 페이지
	    @GetMapping("/user_mypage_apt_list")
	    public String user_mypage_apt_list() {
	    	return "user/user_mypage_apt_list"; 
	    }
	    
	    
		//예약 페이지
	    @GetMapping("/camp_appointment/{contentId}")
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
	    
	  //예약확인 페이지
	    @GetMapping("/camp_appointresult/{apt_no}")
	    public ResponseEntity<Map<String, Object>> camp_appointresult(@PathVariable("apt_no") int apt_no) {
	    	Map map = new HashMap();
	    	
	    	Appointment db = service.selectresult(apt_no);
	    	map.put("cmp_no", db.getCmp_no());
	    	map.put("user_id", db.getUser_id());
	    	map.put("user_nm", db.getUser_nm());
	    	map.put("apt_date", db.getApt_date());
	    	map.put("apt_pp", db.getApt_pp());
	    	map.put("apt_req", db.getApt_req());
	    	map.put("apt_staydate", db.getApt_staydate());
	    	map.put("apt_price", db.getApt_price());
	    	map.put("apt_at", db.getApt_at());
	    	
	    	
	    	return new ResponseEntity<>(map,HttpStatus.OK); // 실제 JSP 파일의 경로에 맞게 수정해야 합니다.
	    }
		
		
		
		
		
		
}

	

