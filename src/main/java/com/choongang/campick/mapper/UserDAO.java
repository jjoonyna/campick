package com.choongang.campick.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.campick.model.User;


@Mapper
public interface UserDAO {

	//////////////////////////////////////////////
	//  										//	
	//  										//	
	// 			공통 기능 				start		// 
	//  										//	
	//  										//	
	////////////////////////////////////////////// 
	
	// 회원 로그인
		public User selectUser(String user_id);
	
	// 회원 삭제 
		public int deleteUser(String user_id);
	
	// 비밀번호 수정
		public int updatePwd(User user);
	
	////////////////////////////////////////////// 
	//  										//	
	//  										//	
	// 			사업자 회원 기능 		start		// 
	//  										//	
	//  										//	
	////////////////////////////////////////////// 
	
	// 사업자 회원 가입
		public int insertBiz(User user);
	
	// 사업자 회원 수정
		public int updateBiz(User user);
	
	// 사업자 아이디, 비밀번호 찾기
		public User selectBiz(String user_biz);
	
	////////////////////////////////////////////// 
	//  										//	
	//  										//	
	// 			일반 회원 기능 		start			// 
	//  										//	
	//  										//	
	////////////////////////////////////////////// 
	
	// 일반 회원 가입 
		public int insertUser(User user);
	
	// 일반 회원 수정
		public int updateUser(User user);
	
	// 일반 회원 비밀번호 찾기
		public User findUserPwd(String user_id);

	// 일반 회원 아이디 찾기 
		public User findUser(String user_tel);

		public User nickcheck(String user_nick);
	
}
