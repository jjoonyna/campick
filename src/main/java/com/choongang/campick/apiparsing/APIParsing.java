package com.choongang.campick.apiparsing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class APIParsing {
	
	public JSONArray jsonparsing(String result) throws Exception {
		
	JSONParser parser = new JSONParser(); 
	JSONObject obj = (JSONObject) parser.parse(result); 
	// response 키를 가지고 데이터를 파싱 
	JSONObject parse_response = (JSONObject) obj.get("response"); 
	// response 로 부터 body 찾기
	JSONObject parse_body = (JSONObject) parse_response.get("body"); 
	// body 로 부터 items 찾기 
	// items로 부터 itemlist 를 받기 
	JSONArray parse_items = (JSONArray) parse_body.get("items");
	return parse_items;
	}
}
