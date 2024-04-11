package com.choongang.campick.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.campick.model.Weather;

@Mapper
public interface WeatherDAO {

	public void weatherinsert(Weather weather);
}
