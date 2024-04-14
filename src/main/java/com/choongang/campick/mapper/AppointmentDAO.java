package com.choongang.campick.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.campick.model.Appointment;
import com.choongang.campick.model.Camp;


@Mapper
public interface AppointmentDAO {


	
	// 일반 회원 예약 조회
	public Appointment selectUserApt(String user_id);

	// 일반 회원 캠핑장 예약하기
	public int aptUserCamp(Appointment apt);

	
	// 회원 예약 삭제 

	
	// 사업자 회원 예약 조회
	
	
	// 사업자 회원 예약 삭제
	
	Camp selectapoint(int contentId);
	
	Camp selectresult(String user_id);
	
	Appointment selectap(String user_id);
	
}
