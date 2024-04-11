package com.choongang.campick.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("dust")
public class Dust {
	private String informData;
	private String grade;
	private String doNm;
	
}
