package com.choongang.campick.model;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("temp")
public class Temp {

	private String regId;
	private String taMin1;
	private String taMax1;
	private String taMin2;
	private String taMax2;
	private String taMin3;
	private String taMax3;
	private String taMin4;
	private String taMax4;
	private String taMin5;
	private String taMax5;
	private String taMin6;
	private String taMax6;
	private String taMin7;
	private String taMax7;
	
}
