package com.choongang.campick.service;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.choongang.campick.mapper.DustDAO;
import com.choongang.campick.model.Dust;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DustService {
	private final DustDAO dao;
	
	public void dustinsert() throws Exception {
		Date today1 = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String now1 = sdf1.format(today1);
		
	  	StringBuilder urlBuilder1 = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth"); /*URL*/
        urlBuilder1.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=voB7ESMA%2BHSFSzn28KxDvL3ub8O44vBlG8EXxn8a4EGLKfCrKjLs8QXFNl7N9%2BpQcxemttb58KasoyO%2BZby7dg%3D%3D"); /*Service Key*/
        urlBuilder1.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 또는 json*/
        urlBuilder1.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("30", "UTF-8")); /*한 페이지 결과 수(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder1.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder1.append("&" + URLEncoder.encode("searchDate","UTF-8") + "=" + URLEncoder.encode(now1, "UTF-8")); /*통보시간 검색(조회 날짜 입력이 없을 경우 한달동안 예보통보 발령 날짜의 리스트 정보를 확인)*/
        urlBuilder1.append("&" + URLEncoder.encode("InformCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*통보코드검색(PM10, PM25, O3)*/
        URL url1 = new URL(urlBuilder1.toString());
        HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
        conn1.setRequestMethod("GET");
        conn1.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn1.getResponseCode());
        BufferedReader rd1;
        if(conn1.getResponseCode() >= 200 && conn1.getResponseCode() <= 300) {
            rd1 = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
        } else {
            rd1 = new BufferedReader(new InputStreamReader(conn1.getErrorStream()));
        }
        StringBuilder sb1 = new StringBuilder();
        String line1;
        while ((line1 = rd1.readLine()) != null) {
            sb1.append(line1);
        }
        rd1.close();
        conn1.disconnect();
        String result1 = sb1.toString();
        System.out.println(result1);
        
    	JSONParser parser = new JSONParser(); 
    	JSONObject obj = (JSONObject) parser.parse(result1); 
    	// response 키를 가지고 데이터를 파싱 
    	JSONObject parse_response = (JSONObject) obj.get("response"); 
    	// response 로 부터 body 찾기
    	JSONObject parse_body = (JSONObject) parse_response.get("body"); 
    	// body 로 부터 items 찾기 
    	// items로 부터 itemlist 를 받기 
    	JSONArray parse_items = (JSONArray) parse_body.get("items");
        JSONObject dust_grade;
        String informData;
        Object informGrade;
        for(int i = 0 ; i <  3; i++) {
			dust_grade = (JSONObject)  parse_items.get(i);
			informGrade = dust_grade.get("informGrade");
			informData = (String) dust_grade.get("informData");
			String gradeall = (String)informGrade;
			String doNm = "";
			String[] gradeArray = gradeall.split(",");
			for(String g : gradeArray) {
				String[] gradeArr = g.split(" : ");
				String grade = "";
				doNm=gradeArr[0];
				grade = gradeArr[1];
				if(doNm.equals("서울")) {
					doNm="서울시";
				}
				if(doNm.equals("인천")) {
					doNm="인천시";
				}
				if(doNm.equals("경기북부")) {
					doNm="경기도 북부";
				}
				if(doNm.equals("경기남부")) {
					doNm="경기도 남부";
				}
				if(doNm.equals("영동")) {
					doNm="강원도 영동";
				}
				if(doNm.equals("영서")) {
					doNm="강원도 영서";
				}
				
				if(doNm.equals("대전")) {
					doNm="대전시";
				}
				if(doNm.equals("충북")) {
					doNm="충청북도";
				}
				if(doNm.equals("충남")) {
					doNm="충청남도";
				}
				if(doNm.equals("세종")) {
					doNm="세종시";
				}
				if(doNm.equals("광주")) {
					doNm="광주시";
				}
				if(doNm.equals("전북")) {
					doNm="전라북도";
				}
				if(doNm.equals("전남")) {
					doNm="전라남도";
				}
				if(doNm.equals("부산")) {
					doNm="부산시";
				}
				if(doNm.equals("대구")) {
					doNm="대구시";
				}
				if(doNm.equals("울산")) {
					doNm="울산시";
				}
				if(doNm.equals("경북")) {
					doNm="경상북도";
				}
				if(doNm.equals("경남")) {
					doNm="경상남도";
				}
				if(doNm.equals("제주")) {
					doNm="제주시";
				}
	
				Dust dust = new Dust();
				dust.setDoNm(doNm);
				dust.setGrade(grade);
				dust.setInformData(informData);
				dao.dustinsert(dust);
				
			}
        }
	}
}
