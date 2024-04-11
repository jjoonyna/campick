package com.choongang.campick.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.campick.model.Appointment;
import com.choongang.campick.model.Camp;
import com.choongang.campick.model.User;


@Mapper
public interface AppointmentDAO {


	
	// 회원 예약 조회
	User selectuserApponintment(String user_id);
	
	// 회원 예약 삭제 

	
	// 사업자 회원 예약 조회
	
	
	// 사업자 회원 예약 삭제
	
	//예약페이지
	Camp selectapoint(int contentId);
	
	//예약정보 확인
	Appointment selectresult(int apt_no);
}
