package com.choongang.campick.model;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("camp")
public class Camp {
	String contentId; 
	 String user_id; 
	 String facltNm;
	 String lctCl;
	 String allar; 
	 String intro;
	 String featureNm;
	 String induty;
	 String doNm;
	 String sigunguNm;
	 String zipcode; 
	 String addr1;
	 String mapX; 
	 String mapY; 
	 String direction;
	 String tel; 
	 String homepage;
	 String manageNmpr; 
	 String gnrlSiteCo;
	 String autoSiteCo; 
	 String glampSiteCo; 
	 String caravSiteCo; 
	 String indvdlCaravSiteCo;
	 String tooltip;
	 String glampInnerFclty;
	 String caravInnerFclty;
	 String trlerAcmpnyAt;
	 String caravAcmpnyAt;
	 String toiletCo;
	 String swrmCo;
	 String wtrplCo;
	 String brazierCl;
	 String sbrsCl;
	 String sbrsEtc;
	 String posblFcltyCl; 
	 String extshrCo; 
	 String themaEnvrnCl;
	 String animalCmgCl;
	 String firstImageUrl;
	 String cmp_pic;
	 String cmp_fav;
	 String  cmp_like;
	 String  cmp_rprt;
	 String cmp_rent;
	 Date cmp_regDate;
}
