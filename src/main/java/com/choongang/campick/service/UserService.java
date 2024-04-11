package com.choongang.campick.service;

import org.springframework.stereotype.Service;

import com.choongang.campick.mapper.UserDAO;
import com.choongang.campick.model.Appointment;
import com.choongang.campick.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserDAO dao;
	

	////////////////////////////////////////////// 
	//  										//	
	//  										//	
	// 			공통 기능 				start		// 
	//  										//	
	//  										//	
	////////////////////////////////////////////// 
	

	// 회원 로그인 : 공통
	public User selectUser(String user_id) {
		return dao.selectUser(user_id);
	}
	
	// 회원 삭제 : 공통 
	public int deleteUser(String user_id) {
		return dao.deleteUser(user_id);
	}
	
	// 비밀번호 수정
	public int updatePwd(User user) {
		return dao.updatePwd(user);
	}
	

	////////////////////////////////////////////// 
	//  										//	
	//  										//	
	// 			사업자 회원 기능 		start		// 
	//  										//	
	//  										//	
	////////////////////////////////////////////// 
	
	
	// 사업자 회원 가입
	public int insertBiz(User user) {
		return dao.insertBiz(user);
	}
	
	// 사업자 회원 수정
	public int updateBiz(User user) {
		return dao.updateBiz(user);
	}
	
	// 사업자 아이디, 비밀번호 찾기
	public User selectBiz(String user_biz) {
		return dao.selectBiz(user_biz);
	}


	////////////////////////////////////////////// 
	//  										//	
	//  										//	
	// 			일반 회원 기능 		start			// 
	//  										//	
	//  										//	
	////////////////////////////////////////////// 
	

	// 일반 회원 가입
	public int insertUser(User user) {
		return dao.insertUser(user);
	}
	
	// 일반 회원 수정
	public int updateUser(User user) {
		return dao.updateUser(user);
	}

	// 일반 회원 비밀번호 찾기
	public User findUserPwd(String user_id) {
		return dao.findUserPwd(user_id);
	}

	// 일반 회원 아이디 찾기 
	public User findUser(String user_tel) {
		return dao.findUser(user_tel);
	}

	// 닉네임 체크
	public User nickcheck(String user_nick) {
		return dao.nickcheck(user_nick);
	}





}
