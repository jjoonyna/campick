package com.choongang.campick.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.context.annotation.Configuration;



@Configuration
public class WeatherAPI {
	
	public Map<Object,Object> weatherAPI() throws Exception{
		//Map tempMap = temperatureAPI();
		//Map precipMap = precipitationAPI();
		Map map = new HashMap();
		//map.put("",tempMap.get("") );
		//map.put("", precipMap.get(""));
		return map;
	}
	
	
	public Map<Object,Object> temperatureAPI(String code) throws Exception{
		 StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidTa"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=서비스키"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
	        urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode("11B10101", "UTF-8")); /*11B10101 서울, 11B20201 인천 등 ( 별첨엑셀자료 참고)*/
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
	        		JSONObject obj = (JSONObject) parser.parse(result); 
	        		// response 키를 가지고 데이터를 파싱 
	        		JSONObject parse_response = (JSONObject) obj.get("response"); 
	        		// response 로 부터 body 찾기
	        		JSONObject parse_body = (JSONObject) parse_response.get("body"); 
	        		// body 로 부터 items 찾기 
	        		JSONObject parse_items = (JSONObject) parse_body.get("items");

	        		// items로 부터 itemlist 를 받기 
	        		JSONArray parse_item = (JSONArray) parse_items.get("item");
	        		JSONObject weather; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용
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

	     			
	         		for(int i = 0 ; i < parse_item.size(); i++) {
	         			weather = (JSONObject) parse_item.get(i);
	         			regId = weather.get("regId");
	         			taMin3 = weather.get("taMin3");
	         			taMax3 = weather.get("taMax3");
	         			taMin4 = weather.get("taMin4");
	         			taMax4 = weather.get("taMax4");
	         			taMin5 = weather.get("taMin5");
	         			taMax5 = weather.get("taMax5");
	         			taMin6 = weather.get("taMin6");
	         			taMax6 = weather.get("taMax6");
	         			taMin7 = weather.get("taMin7");
	         			taMax7= weather.get("taMax7");
	         			
	         		}
	     			
	         		Map map = new HashMap();
	         		map.put("regId", regId);
	         		map.put("taMin3", taMin3);
	         		map.put("taMax3", taMax3);
	         		map.put("taMin4", taMin4);
	         		map.put("taMax4", taMax4);
	         		map.put("taMin5", taMin5);
	         		map.put("taMax5", taMax5);
	         		map.put("taMin6", taMin6);
	         		map.put("taMax6", taMax6);
	         		map.put("taMin7", taMin7);
	         		map.put("taMax7", taMax7);
	         		
	         		System.out.println(map);
	         		
	         		return map;
	    }
	
	public Map<Object,Object> precipitationAPI(String code) throws  Exception{
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=voB7ESMA%2BHSFSzn28KxDvL3ub8O44vBlG8EXxn8a4EGLKfCrKjLs8QXFNl7N9%2BpQcxemttb58KasoyO%2BZby7dg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode("11B00000", "UTF-8")); /*11B0000 서울, 인천, 경기도 11D10000 등 (활용가이드 하단 참고자료 참조)*/
        urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode("202403220600", "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600(1800)-최근 24시간 자료만 제공*/
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
     		JSONObject obj = (JSONObject) parser.parse(result); 
     		// response 키를 가지고 데이터를 파싱 
     		JSONObject parse_response = (JSONObject) obj.get("response"); 
     		// response 로 부터 body 찾기
     		JSONObject parse_body = (JSONObject) parse_response.get("body"); 
     		// body 로 부터 items 찾기 
     		JSONObject parse_items = (JSONObject) parse_body.get("items");

     		// items로 부터 itemlist 를 받기 
     		JSONArray parse_item = (JSONArray) parse_items.get("item");
     		JSONObject weather; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용
     		// 카테고리와 값만 받아오기
     		Object address = null;
 			Object rnSt3Am = null;
 			Object rnSt3Pm = null;
 			Object rnSt4Am = null;
 			Object rnSt4Pm = null;
 			Object rnSt5Am = null;
 			Object rnSt5Pm = null;
 			Object rnSt6Am = null;
 			Object rnSt6Pm = null;
 			Object rnSt7Am = null;
 			Object rnSt7Pm = null;
 			Object rnSt8 = null;
 			Object rnSt9 = null;
 			Object rnSt10 = null;
 			Object wf3Am = null;
 			Object wf3Pm = null;
 			Object wf4Am = null;
 			Object wf4Pm = null;
 			Object wf5Am = null;
 			Object wf5Pm = null;
 			Object wf6Am = null;
 			Object wf6Pm = null;
 			Object wf7Am = null;
 			Object wf7Pm = null;
 			Object wf8 = null;
 			Object wf9 = null;
 			Object wf10 = null;
 			Object regId = null;
     		for(int i = 0 ; i < parse_item.size(); i++) {
     			weather = (JSONObject) parse_item.get(i);
     			regId = weather.get("regId");
     			rnSt3Am = weather.get("rnSt3Am");
     			rnSt3Pm = weather.get("rnSt3Pm");
     			rnSt4Am = weather.get("rnSt4Am");
     			rnSt4Pm = weather.get("rnSt4Pm");
     			rnSt5Am = weather.get("rnSt5Am");
     			rnSt5Pm = weather.get("rnSt5Pm");
     			rnSt6Am = weather.get("rnSt6Am");
     			rnSt6Pm = weather.get("rnSt6Pm");
     			rnSt7Am = weather.get("rnSt7Am");
     			rnSt7Pm = weather.get("rnSt7Pm");
     			rnSt8 = weather.get("rnSt8");
     			rnSt9 = weather.get("rnSt9");
     			rnSt10 = weather.get("rnSt10");
     			wf3Am = weather.get("wf3Am");
     			wf3Pm = weather.get("wf3Pm");
     			wf4Am = weather.get("wf4Am");
     			wf4Pm = weather.get("wf4Pm");
     			wf5Am = weather.get("wf5Am");
     			wf5Pm = weather.get("wf5Pm");
     			wf6Am = weather.get("wf6Am");
     			wf6Pm = weather.get("wf6Pm");
     			wf7Am = weather.get("wf7Am");
     			wf7Pm = weather.get("wf7Pm");
     			wf8 = weather.get("wf8");
     			wf9 = weather.get("wf9");
     			wf10 = weather.get("wf10");
     			if(regId.equals("11B00000")) {
     				regId = "서울,경기";
     			}
     		}
 			
     		Map map = new HashMap();
     		map.put("address", address);
     		map.put("rnSt3Am", rnSt3Am);
     		map.put("rnSt3Pm", rnSt3Pm);
     		map.put("rnSt4Am", rnSt4Am);
     		map.put("rnSt4Pm", rnSt4Pm);
     		map.put("rnSt5Am", rnSt5Am);
     		map.put("rnSt5Pm", rnSt5Pm);
     		map.put("rnSt6Am", rnSt6Am);
     		map.put("rnSt6Pm", rnSt6Pm);
     		map.put("rnSt7Am", rnSt7Am);
     		map.put("rnSt7Pm", rnSt7Pm);
     		map.put("rnSt8", rnSt8);
     		map.put("rnSt9", rnSt9);
     		map.put("rnSt10", rnSt10);
     		map.put("wf3Am", wf3Am);
     		map.put("wf3Pm", wf3Pm);
     		map.put("wf4Am", wf4Am);
     		map.put("wf4Pm", wf4Pm);
     		map.put("wf5Am", wf5Am);
     		map.put("wf5Pm", wf5Pm);
     		map.put("wf6Am", wf6Am);
     		map.put("wf6Pm", wf6Pm);
     		map.put("wf7Am", wf7Am);
     		map.put("wf7Pm", wf7Pm);
     		map.put("wf8", wf8);
     		map.put("wf9", wf9);
     		map.put("wf10", wf10);
     		
     		System.out.println(map);
     		
     		return map;
	}
}
