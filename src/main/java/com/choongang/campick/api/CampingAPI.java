package com.choongang.campick.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CampingAPI {
	public Map<Object,Object> temperatureAPI(String code) throws Exception{
		 StringBuilder urlBuilder = new StringBuilder("﻿http://apis.data.go.kr/B551011/GoCamping/basedList"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=voB7ESMA%2BHSFSzn28KxDvL3ub8O44vBlG8EXxn8a4EGLKfCrKjLs8QXFNl7N9%2BpQcxemttb58KasoyO%2BZby7dg%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*11B10101 서울, 11B20201 인천 등 ( 별첨엑셀자료 참고)*/
	        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력- YYYYMMDD0600(1800) 최근 24시간 자료만 제공*/
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
	        		JSONObject gocamping; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용
	        		// 카테고리와 값만 받아오기
	        		Object contentId = null;
	        		Object user_id = null;
	        		Object facltNm = null;
	        		Object lctCl = null;
	        		Object allar = null;
	        		Object intro = null;
	        		Object featureNm = null;
	        		Object induty = null;
	        		Object doNm = null;
	        		Object sigunguNm = null;
	        		Object zipcode = null;
	        		Object addr1 = null;
	        		Object mapX = null;
	        		Object mapY = null;
	        		Object direction = null;
	        		Object tel = null;
	        		Object homepage = null;
	        		Object manageNmpr = null;
	        		Object gnrlSiteCo = null;
	        		Object autoSiteCo = null;
	        		Object glampSiteCo = null;
	        		Object caravSiteCo = null;
	        		Object indvdlCaravSiteCo = null;
	        		Object tooltip = null;
	        		Object glampInnerFclty = null;
	        		Object caravInnerFclty = null;
	        		Object trlerAcmpnyAt = null;
	        		Object caravAcmpnyAt = null;
	        		Object toiletCo = null;
	        		Object swrmCo = null;
	        		Object wtrplCo = null;
	        		Object brazierCl = null;
	        		Object sbrsCl = null;
	        		Object sbrsEtc = null;
	        		Object posblFcltyCl = null;
	        		Object extshrCo = null;
	        		Object themaEnvrnCl = null;
	        		Object animalCmgCl = null;
	        		Object firstImageUrl = null;
	        		Object cmp_pic = null;
	        		Object cmp_fav = null;
	        		Object cmp_like = null;
	        		Object cmp_rprt = null;
	        		Object cmp_rent = null;
	        		Object cmp_regDate = null;

	     			
	         		for(int i = 0 ; i < parse_item.size(); i++) {
	         			gocamping = (JSONObject) parse_item.get(i);
	         			 contentId = gocamping.get("contentId");
		        		 user_id = gocamping.get("user_id");
		        		 facltNm = gocamping.get("facltNm");
		        		 lctCl = gocamping.get("lctCl");
		        		 allar = gocamping.get("allar");
		        		 intro = gocamping.get("intro");
		        		 featureNm = gocamping.get("featureNm");
		        		 induty = gocamping.get("induty");
		        		 doNm = gocamping.get("doNm");
		        		 sigunguNm = gocamping.get("sigunguNm");
		        		 zipcode = gocamping.get("zipcode");
		        		 addr1 = gocamping.get("addr1");
		        		 mapX = gocamping.get("mapX");
		        		 mapY = gocamping.get("mapY");
		        		 direction = gocamping.get("direction");
		        		 tel = gocamping.get("tel");
		        		 homepage = gocamping.get("homepage");
		        		 manageNmpr = gocamping.get("manageNmpr");
		        		 gnrlSiteCo = gocamping.get("gnrlSiteCo");
		        		 autoSiteCo = gocamping.get("autoSiteCo");
		        		 glampSiteCo = gocamping.get("glampSiteCo");
		        		 caravSiteCo = gocamping.get("caravSiteCo");
		        		 indvdlCaravSiteCo = gocamping.get("indvdlCaravSiteCo");
		        		 tooltip = gocamping.get("tooltip");
		        		 glampInnerFclty = gocamping.get("glampInnerFclty");
		        		 caravInnerFclty = gocamping.get("caravInnerFclty");
		        		 trlerAcmpnyAt = gocamping.get("trlerAcmpnyAt");
		        		 caravAcmpnyAt = gocamping.get("caravAcmpnyAt");
		        		 toiletCo = gocamping.get("toiletCo");
		        		 swrmCo = gocamping.get("swrmCo");
		        		 wtrplCo = gocamping.get("wtrplCo");
		        		 brazierCl = gocamping.get("brazierCl");
		        		 sbrsCl = gocamping.get("sbrsCl");
		        		 sbrsEtc = gocamping.get("sbrsEtc");
		        		 posblFcltyCl = gocamping.get("posblFcltyCl");
		        		 extshrCo = gocamping.get("extshrCo");
		        		 themaEnvrnCl = gocamping.get("themaEnvrnCl");
		        		 animalCmgCl = gocamping.get("animalCmgCl");
		        		 firstImageUrl = gocamping.get("firstImageUrl");
		        		 cmp_pic = gocamping.get("cmp_pic");
		        		 cmp_fav = gocamping.get("cmp_fav");
		        		 cmp_like = gocamping.get("cmp_like");
		        		 cmp_rprt = gocamping.get("cmp_rprt");
		        		 cmp_rent = gocamping.get("cmp_rent");
		        		 cmp_regDate = gocamping.get("cmp_regDate");

	         			
	         		}
	     			
	         		Map map = new HashMap();
	         		map.put("contentId", contentId);
	         		map.put("user_id", user_id);
	         		map.put("facltNm", facltNm);
	         		map.put("lctCl", lctCl);
	         		map.put("allar", allar);
	         		map.put("intro", intro);
	         		map.put("featureNm", featureNm);
	         		map.put("induty", induty);
	         		map.put("doNm", doNm);
	         		map.put("sigunguNm", sigunguNm);
	         		map.put("zipcode", zipcode);
	         		map.put("addr1", addr1);
	         		map.put("mapX", mapX);
	         		map.put("mapY", mapY);
	         		map.put("direction", direction);
	         		map.put("tel", tel);
	         		map.put("homepage", homepage);
	         		map.put("manageNmpr", manageNmpr);
	         		map.put("gnrlSiteCo", gnrlSiteCo);
	         		map.put("autoSiteCo", autoSiteCo);
	         		map.put("glampSiteCo", glampSiteCo);
	         		map.put("caravSiteCo", caravSiteCo);
	         		map.put("indvdlCaravSiteCo", indvdlCaravSiteCo);
	         		map.put("tooltip", tooltip);
	         		map.put("glampInnerFclty", glampInnerFclty);
	         		map.put("caravInnerFclty", caravInnerFclty);
	         		map.put("trlerAcmpnyAt", trlerAcmpnyAt);
	         		map.put("caravAcmpnyAt", caravAcmpnyAt);
	         		map.put("toiletCo", toiletCo);
	         		map.put("swrmCo", swrmCo);
	         		map.put("wtrplCo", wtrplCo);
	         		map.put("brazierCl", brazierCl);
	         		map.put("sbrsCl", sbrsCl);
	         		map.put("sbrsEtc", sbrsEtc);
	         		map.put("posblFcltyCl", posblFcltyCl);
	         		map.put("extshrCo", extshrCo);
	         		map.put("themaEnvrnCl", themaEnvrnCl);
	         		map.put("animalCmgCl", animalCmgCl);
	         		map.put("firstImageUrl", firstImageUrl);
	         		map.put("cmp_pic", cmp_pic);
	         		map.put("cmp_fav", cmp_fav);
	         		map.put("cmp_like", cmp_like);
	         		map.put("cmp_rprt", cmp_rprt);
	         		map.put("cmp_rent", cmp_rent);
	         		map.put("cmp_regDate", cmp_regDate);
	         		
	         		System.out.println(map);
	         		
	         		return map;
	    }
}
