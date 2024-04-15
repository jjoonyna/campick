package com.choongang.campick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.campick.model.Camp;
import com.choongang.campick.model.User;

@Mapper
public interface CampDAO {

	void insert(Camp camp);

	List<Camp> campList(Camp camp);

	int count();

	// 사업자가 캠핑장 등록하기
	int insertBizCmp(Camp camp);

	// 캠핑장 삭제하기
	int deleteBizCmp(String contentId);

	// 캠핑장 조회하기
	Camp selectBizCmp(String contentId);

	Camp selectUserCamp(String contentId);

	

}
