package com.choongang.campick.mapper;

import java.util.List;

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
	
	public User selectUser(String user_id);
	
	// 회원 예약 삭제 

	//회원 예약 확인 
	public Appointment selectCamp(String camp_check);
	
	
	// 사업자 회원 예약 조회
	
	
	// 사업자 회원 예약 삭제
	
	Camp selectapoint(String contentId);
	
	Camp selectresult(String user_id);
	
	Appointment selectap(String user_id);

	public List<Appointment> userAptList(String user_id);
	
}
