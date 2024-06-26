package com.choongang.campick.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.choongang.campick.mapper.AppointmentDAO;
import com.choongang.campick.model.Appointment;
import com.choongang.campick.model.Camp;
import com.choongang.campick.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {
	
	private final AppointmentDAO dao;
	
	// 일반 회원 예약 조회
	public Appointment selectUserApt(String user_id) {
		return dao.selectUserApt(user_id);
	}

	// 일반 회원 캠핑장 예약하기
	public int aptUserCamp(String string, Appointment apt) {
		return dao.aptUserCamp(apt);
	}
	
	public User selectUser(String user_id) {
		return dao.selectUser(user_id);
	}


	// 일반 회원 예약 삭제
	

	// 일반 회원 예약 확인
	public Appointment selectCamp(String camp_check) {
		return dao.selectCamp(camp_check);
	}
	
	
	// 사업자 회원 예약 조회
	
	
	// 사업자 회원 예약 삭제


	public Camp selectapoint(String contentId) {
		return dao.selectapoint(contentId);
	}
	
	public Camp selectresult(String user_id) {
		return dao.selectresult(user_id);
	}
	
	public Appointment selectap(String user_id) {
		return dao.selectap(user_id);
	}

	public List<Appointment> userAptList(String user_id) {
		return dao.userAptList(user_id);
	}


}
