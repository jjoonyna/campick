package com.choongang.campick.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.campick.model.Temp;

@Mapper
public interface TempDAO {

	public void tempinsert(Temp temp);
}
