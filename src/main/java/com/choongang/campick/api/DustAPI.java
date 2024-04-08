package com.choongang.campick.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DustAPI {
	
	public List<Map<String,Object>> dust() throws Exception {
		//조회할 날짜 생성
		Date today = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(today);
		//openapi 조회
	  	StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=voB7ESMA%2BHSFSzn28KxDvL3ub8O44vBlG8EXxn8a4EGLKfCrKjLs8QXFNl7N9%2BpQcxemttb58KasoyO%2BZby7dg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 또는 json*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder.append("&" + URLEncoder.encode("searchDate","UTF-8") + "=" + URLEncoder.encode(now, "UTF-8")); /*통보시간 검색(조회 날짜 입력이 없을 경우 한달동안 예보통보 발령 날짜의 리스트 정보를 확인)*/
        urlBuilder.append("&" + URLEncoder.encode("InformCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*통보코드검색(PM10, PM25, O3)*/
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
        String result = sb.toString();
        
        //api 파싱
 		JSONParser parser = new JSONParser(); 
 		JSONObject obj = (JSONObject) parser.parse(result); 
 		// response 키를 가지고 데이터를 파싱 
 		JSONObject parse_response = (JSONObject) obj.get("response"); 
 		// response 로 부터 body 찾기
 		JSONObject parse_body = (JSONObject) parse_response.get("body"); 
 		// body 로 부터 items 찾기 
 		JSONObject parse_items = (JSONObject) parse_body.get("items");

 		// items로 부터 itemlist 를 받기 
 		JSONArray parse_item = (JSONArray) parse_items.get("item");
        JSONObject dust_grade;
        Object informData;
        Object informGrade;
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for(int i = 0 ; i <  3; i++) {
			dust_grade = (JSONObject)  parse_item.get(i);
			informGrade = dust_grade.get("informGrade");
			informData = dust_grade.get("informData");
			
			String grade = (String)informGrade;
			String location = "";
			String[] gradeArray = grade.split(",");
			for(String g : gradeArray) {
				String[] gradeArr = g.split(" : ");
				for(int j=0; j<gradeArr.length; j++) {
					Map<String,Object> map = new HashMap<String,Object>();
					if(j==0) {
						location=gradeArr[j];
					}else if(j%2==0) {
						location=gradeArr[j];
						
					}else {
						grade = gradeArr[j];
					}
					map.put("informData", informData);
					map.put("location", location);
					map.put("grade", grade);
					list.add(map);
				}
			}
        }
        
        return list;
        
	}
}
