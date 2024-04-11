package com.choongang.campick.model;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@Data
@JsonAutoDetect
@Alias("apt")
public class Appointment {
	private String apt_no;			// 예약 번호
	private String cmp_no;			// 캠핑장 번호
	private String user_id;			// 아이디
	private String user_nm;			// 예약자 이름
	private String apt_date;		//날짜
	private String apt_pp;			//인원
	private String apt_req;			//요청사항
	private String apt_staydate;	//숙박 일자
	private String apt_price;		//금액
	private String apt_at;			//결제 상태
	
	



}
