package com.choongang.campick.model;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@Data
@JsonAutoDetect
@Alias("cmp_user")
public class User {
	private String user_id;		// 아이디
	private String user_nick;	// 닉네임
	private String user_sns;	// 소셜 로그인 
	private String user_pw;		// 비밀번호 
	private String user_nm;		// 이름 
	private String user_biz;	// 사업자등록번호
	private String user_tel;	// 휴대폰번호
	private String user_code;	// 우편번호
	private String user_addr1;	// 기본주소
	private String user_addr2;	// 상세주소
	private String user_pic;	// 프로필사진
	private String user_email;	// 이메일
	private String user_kind; 	// 회원 상태
	private String user_gender; // 성별
	private String user_birth;	// 생년월일
}
