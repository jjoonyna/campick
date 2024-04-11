package com.choongang.campick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.campick.model.Camp;
import com.choongang.campick.model.User;

@Mapper
public interface CampDAO {

	//상세보기
	Camp getCamp(String contentid);
	//상세보기 아이디
	Camp selectcontent(String contentid);

	//예약 조회
	void insert(Camp camp);

	List<Camp> campList(Camp camp);

	int count();

}
