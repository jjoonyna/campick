package com.choongang.campick.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("weather")
public class Weather {
	private String doNm;
	private Object taMin;
	private Object taMax;
	private Object taMin1;
	private Object taMax1;
	private Object taMin2;
	private Object taMax2;
	private Object taMin3;
	private Object taMax3;
	private Object taMin4;
	private Object taMax4;
	private Object taMin5;
	private Object taMax5;
	private Object taMin6;
	private Object taMax6;
	private Object taMin7;
	private Object taMax7;
	private Object rnStAm;
	private Object rnStPm;
	private Object rnSt1Am;
	private Object rnSt1Pm;
	private Object rnSt2Am;
	private Object rnSt2Pm;
	private Object rnSt3Am;
	private Object rnSt3Pm;
	private Object rnSt4Am;
	private Object rnSt4Pm;
	private Object rnSt5Am;
	private Object rnSt5Pm;
	private Object rnSt6Am;
	private Object rnSt6Pm;
	private Object rnSt7Am;
	private Object rnSt7Pm;
	private String wfAm;
	private String wfPm;
	private String wf1Am;
	private String wf1Pm;
	private String wf2Am;
	private String wf2Pm;
	private String wf3Am;
	private String wf3Pm;
	private String wf4Am;
	private String wf4Pm;
	private String wf5Am;
	private String wf5Pm;
	private String wf6Am;
	private String wf6Pm;
	private String wf7Am;
	private String wf7Pm;
}
