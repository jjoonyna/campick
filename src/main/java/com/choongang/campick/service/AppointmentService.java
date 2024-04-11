package com.choongang.campick.service;

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
	public int aptUserCamp(Appointment apt) {
		return dao.aptUserCamp(apt);
	}

	// 캠핑장 예약 취소하기 
	public int cancelUserApt(String user_id) {
		return dao.cancelUserApt(user_id);
	}
	

	// 사업자 회원 예약 조회
	public Appointment selectbizAppointment(String user_id) {
		return dao.selectbizAppointment(user_id);
	}

	// 사업자 회원 예약 취소

	public int cancelbizApt(String user_id) {
		return dao.cancelbizApt(user_id);
	}



	

	

	

	
	//예약페이지
	public Camp selectapoint(int contentId) {
		return dao.selectapoint(contentId);
	}
	//예약정보확인
	public Appointment selectresult(int apt_no) {
		return dao.selectresult(apt_no);
	}
	


}
