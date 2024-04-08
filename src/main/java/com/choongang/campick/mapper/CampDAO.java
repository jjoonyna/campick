package com.choongang.campick.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.campick.model.Camp;

@Mapper
public interface CampDAO {

	void insert(Camp camp);

}
