package com.choongang.campick.model;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("camp")
public class Camp {
	private String contentId;
	private String user_id;
	private String facltNm;
	private String lctCl;
	private String lineIntro;
	private String intro;
	private String featureNm;
	private String induty;
	private String doNm;
	private String sigunguNm;
	private String zipcode;
	private String addr1;
	private String mapX;
	private String mapY;
	private String tel;
	private String homepage;
	private String gnrlSiteCo;
	private String autoSiteCo;
	private String glampSiteCo;
	private String caravSiteCo;
	private String glampInnerFclty;
	private String caravInnerFclty;
	private String trlerAcmpnyAt;
	private String caravAcmpnyAt;
	private String toiletCo;
	private String swrmCo;
	private String wtrplCo;
	private String brazierCl;
	private String sbrsCl;
	private String sbrsEtc;
	private String posblFcltyCl;
	private String extshrCo;
	private String themaEnvrnCl;
	private String animalCmgCl;
	private String firstImageUrl;
	private String cmp_pic;
	private String cmp_fav;
	private String cmp_like;
	int cmp_maxpp;
	int cmp_staydate;
	int cmp_price;

	private Date cmp_regDate;

	private int start;
	private String search;
}
