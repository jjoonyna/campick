package com.choongang.campick.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.campick.model.Dust;

@Mapper
public interface DustDAO {

	public void dustinsert(Dust dust);
}
