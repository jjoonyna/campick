package com.choongang.campick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.campick.model.Camp;

@Mapper
public interface CampDAO {

	void insert(Camp camp);

	List<Camp> campList(Camp camp);

	int count();

}
