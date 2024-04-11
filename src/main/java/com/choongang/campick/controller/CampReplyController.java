package com.choongang.campick.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choongang.campick.model.Reply;
import com.choongang.campick.model.User;
import com.choongang.campick.service.CampReplyService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CampReplyController {
	
	private final CampReplyService service;
	
	
//	/*
//	 * 댓글 작성
//	 */
//	@PostMapping("/insert_cmp_reply")
//	@ResponseBody
//	public ResponseEntity<Integer> insert_cmp_reply(@RequestBody Reply reply){
//		System.out.println("댓글을 쓸거예요!");
//		int result = service.insertReply(reply);
//		System.out.println("result : " + result);
//		
//		return new ResponseEntity<>(result, HttpStatus.OK);
//	}
//	
//	/*
//	 * 댓글 수정 (미완)
//	 */
//	@PutMapping("/update_cmp_reply")
//	@ResponseBody
//	public ResponseEntity<Integer> update_cmp_reply(@RequestBody Reply reply, HttpSession session){
//		System.out.println("댓글 수정 시작!");
//		int result = 0; // 결과 값 받는 객체 선언
//
//		System.out.println(reply.getUser_id()); // 회원이 입력한 값 출력해보기
//
//		Reply db = service.selectReply(reply.getUser_id()); // select된 회원 값을 db 객체에 넣는다
//		 // 세션에서 현재 로그인한 사용자 정보 가져오기
//        User loginUser = (User) session.getAttribute("user");
//
//        // 세션에 사용자 정보가 없으면 로그인 페이지로 리다이렉트
//        if (loginUser == null) {
//            return new ResponseEntity<>(-1, HttpStatus.UNAUTHORIZED);
//        }
//
//		// 댓글을 작성한 사용자와 현재 로그인한 사용자가 같은지 확인
//        if (!reply.getUser_id().equals(loginUser.getUser_id())) {
//            return new ResponseEntity<>(-1, HttpStatus.FORBIDDEN); // 권한 없음
//        }
//		return new ResponseEntity<>(HttpStatus.OK);
//		
//	}
//	
//	/*
//	 * 댓글 삭제 
//	 */
//	@GetMapping("/delete_cmp_reply/{cmp_no}")
//	@ResponseBody
//	public ResponseEntity<Integer> delete_cmp_reply(@RequestBody Reply reply){
//		
//		int result = 0;
//		
//		Reply db = service.selectReply(reply.getUser_id());
//		
//		if (reply.getUser_id().matches(db.getUser_id())) {	// 아이디 회원이 입력한 값을 인코딩하여 비교, 일치할 경우
//			result = service.deleteReply(reply.getUser_id());					// // delete를 result 객체에 대입
//		} else {															// 일치하지 않을 경우, result = -1 반환
//			result = -1;
//		}
//		System.out.println("result:" + result);		// 결과값 test 출력
//
//		return new ResponseEntity<>(result, HttpStatus.OK);
//
//		
//	}
}
