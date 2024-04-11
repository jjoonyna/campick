package com.choongang.campick.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.campick.model.Appointment;
import com.choongang.campick.model.Camp;
import com.choongang.campick.model.User;


@Mapper
public interface AppointmentDAO {


	
	// 일반 회원 예약 조회
	public Appointment selectUserApt(String user_id);

	// 일반 회원 캠핑장 예약하기
	public int aptUserCamp(Appointment apt);

	
	// 회원 예약 취소하기 
	public int cancelUserApt(String user_id);
	
	// 사업자 회원 예약 조회
	public Appointment selectbizAppointment(String user_id);

	// 사업자 회원 예약 삭제
	public int cancelbizApt(String user_id);


	
	
	
	//예약페이지
	Camp selectapoint(int contentId);
	
	//예약정보 확인
	Appointment selectresult(int apt_no);
}
