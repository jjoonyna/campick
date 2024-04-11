package com.choongang.campick.service;

import org.springframework.stereotype.Service;

import com.choongang.campick.mapper.AppointmentDAO;
import com.choongang.campick.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {
	
	private final AppointmentDAO dao;
	
	// 일반 회원 예약 조회
	public User selectuserApponintment(String user_id) {
		return dao.selectuserApponintment(user_id);
	}

	// 일반 회원 예약 삭제
	

	

	
	// 사업자 회원 예약 조회
	
	
	// 사업자 회원 예약 삭제





}
