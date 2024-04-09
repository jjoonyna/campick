package com.choongang.campick.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.choongang.campick.mapper.TempDAO;
import com.choongang.campick.model.Temp;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TempService {
	private final TempDAO dao;
	
	public void tempinsert(Temp temp) throws Exception{
		
//		예보등급(인천)
//		예보등급(경기북부)
//		예보등급(경기남부)
//		예보등급(강원영서)
//		예보등급(강원영동)
//		예보등급(대전)
//		예보등급(세종)
//		예보등급(충북)
//		예보등급(충남)
//		예보등급(광주)
//		예보등급(전북)
//		예보등급(전남)
//		예보등급(부산)
//		예보등급(대구)
//		예보등급(울산)
//		예보등급(경북)
//		예보등급(경남)
//		예보등급(제주)
		
		// 중기 기온
//		﻿11B10101	서울	11G00401	서귀포
//		11B20201	인천	11F20501	광주
//		11B20601	수원	21F20801	목포
//		11B20305	파주	11F20401	여수
//		11D10301	춘천	11F10201	전주
//		11D10401	원주	21F10501	군산
//		11D20501	강릉	11H20201	부산
//		11C20401	대전	11H20101	울산
//		11C20101	서산	11H20301	창원
//		11C20404	세종	11H10701	대구
//		11C10301	청주	11H10501	안동
//		11G00201	제주	11H10201	포항
		
		
		// 중기 육상(강수확률)
//		﻿11B00000	서울, 인천, 경기도
//		11D10000	강원도영서
//		11D20000	강원도영동
//		11C20000	대전, 세종, 충청남도
//		11C10000	충청북도
//		11F20000	광주, 전라남도
//		11F10000	전라북도
//		11H10000	대구, 경상북도
//		11H20000	부산, 울산, 경상남도
//		11G00000	제주도


		String[] addr = {"11B10101","11B20201","11B20601","11B20305","11D10301","11D10401","11D20501","11C20401",
				"11C20101","11C20404","11C10301","11G00201","11G00401","11F20501","21F20801","11F20401","11F10201",
				"21F10501","11H20201","11H20101","11H20301","11H10701","11H10501","11H10201"};
		
		for(int i=0; i<addr.length;i++) {
			
		
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidTa"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=서비스키"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode(addr[i], "UTF-8")); /*11B10101 서울, 11B20201 인천 등 ( 별첨엑셀자료 참고)*/
        urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode("201309030600", "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력- YYYYMMDD0600(1800) 최근 24시간 자료만 제공*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        String result = sb.toString();
        
        // Json parser를 만들어 만들어진 문자열 데이터를 객체화 
        		JSONParser parser = new JSONParser(); 
        		JSONObject object = (JSONObject) parser.parse(result); 
        		// response 키를 가지고 데이터를 파싱 
        		JSONObject parse_response = (JSONObject) object.get("response"); 
        		// response 로 부터 body 찾기
        		JSONObject parse_body = (JSONObject) parse_response.get("body"); 
        		// body 로 부터 items 찾기 
        		JSONObject parse_items = (JSONObject) parse_body.get("items");

        		// items로 부터 itemlist 를 받기 
        		JSONArray parse_item = (JSONArray) parse_items.get("item");
        		JSONObject obj; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용
        		// 카테고리와 값만 받아오기
        		Object regId = null;
        		Object taMin3 = null;
        		Object taMax3 = null;
        		Object taMin4 = null;
        		Object taMax4 = null;
        		Object taMin5 = null;
        		Object taMax5 = null;
        		Object taMin6 = null;
        		Object taMax6 = null;
        		Object taMin7 = null;
        		Object taMax7 = null;
        		
        		
     			
         		for(int j = 0 ; j < parse_item.size(); j++) {
         			obj = (JSONObject) parse_item.get(j);
         			regId = obj.get("regId");
         			taMin3 = obj.get("taMin3");
         			taMax3 = obj.get("taMax3");
         			taMin4 = obj.get("taMin4");
         			taMax4 = obj.get("taMax4");
         			taMin5 = obj.get("taMin5");
         			taMax5 = obj.get("taMax5");
         			taMin6 = obj.get("taMin6");
         			taMax6 = obj.get("taMax6");
         			taMin7 = obj.get("taMin7");
         			taMax7= obj.get("taMax7");
         			
         			////////////////////지역 변경 필요//////////////////////////
         			if(regId.equals("11B10101")) {
         				regId = "서울";
         			}
         			if(regId.equals("11B20201")) {
         				regId = "인천";
         			}
         			////////////////////////////////////////////////////////
         			temp.setTaMax1(temp.getTaMax2());
         			temp.setTaMin1(temp.getTaMin2());	
         			temp.setTaMax2(temp.getTaMax3());
         			temp.setTaMin2(temp.getTaMin3());	
         			temp.setTaMin3((String)taMin3);
         			temp.setTaMax3((String)taMax3);
         			temp.setTaMin4((String)taMin4);
         			temp.setTaMax4((String)taMax4);
         			temp.setTaMin5((String)taMin5);
         			temp.setTaMax5((String)taMax5);
         			temp.setTaMin6((String)taMin6);
         			temp.setTaMax6((String)taMax6);
         			temp.setTaMin7((String)taMin7);
         			temp.setTaMax7((String)taMax7);
         			temp.setRegId((String)regId);
         			dao.tempinsert(temp);
         		}
         		
		}
         		
	}
	
	
}
