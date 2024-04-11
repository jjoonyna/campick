package com.choongang.campick.service;

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
import org.springframework.stereotype.Service;

import com.choongang.campick.mapper.WeatherDAO;
import com.choongang.campick.model.Weather;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherService {
	private final WeatherDAO dao;

	public void weatherinsert() throws Exception {

		Date today = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String now = sdf.format(today);

		String[] addr = { "11B10101", "11B20201", "11B20305", "11C10301", "11C20101", "11C20401", "11D10301",
				"11F10201", "11F20401", "11F20501", "11H10201", "11H10701", "11H20101", "11H20201", "11H20301",
				"11G00201" };
		String[] addr2 = { "11B00000", "11B00000", "11B00000", "11C10000", "11C20000", "11C20000", "11D10000",
				"11F10000", "11F20000", "11F20000", "11H10000", "11H10000", "11H20000", "11H20000", "11H20000",
				"11G00000" };
		for (int i = 0; i < addr.length; i++) {

			System.out.println(addr[i]);

			StringBuilder urlBuilder = new StringBuilder(
					"http://apis.data.go.kr/1360000/MidFcstInfoService/getMidTa"); /* URL */
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
					+ "=voB7ESMA%2BHSFSzn28KxDvL3ub8O44vBlG8EXxn8a4EGLKfCrKjLs8QXFNl7N9%2BpQcxemttb58KasoyO%2BZby7dg%3D%3D"); /*
																																 * Service
																																 * Key
																																 */
			urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("10", "UTF-8")); /* 한 페이지 결과 수 */
			urlBuilder.append("&" + URLEncoder.encode("dataType", "UTF-8") + "="
					+ URLEncoder.encode("JSON", "UTF-8")); /* 요청자료형식(XML/JSON)Default: XML */
			urlBuilder.append("&" + URLEncoder.encode("regId", "UTF-8") + "="
					+ URLEncoder.encode(addr[i], "UTF-8")); /* 11B10101 서울, 11B20201 인천 등 ( 별첨엑셀자료 참고) */
			urlBuilder.append("&" + URLEncoder.encode("tmFc", "UTF-8") + "=" + URLEncoder.encode(now+"1800",
					"UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력- YYYYMMDD0600(1800) 최근 24시간 자료만 제공*/
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
			String doNm = null;
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

			StringBuilder urlBuilder2 = new StringBuilder(
					"http://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst"); /* URL */
			urlBuilder2.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
					+ "=voB7ESMA%2BHSFSzn28KxDvL3ub8O44vBlG8EXxn8a4EGLKfCrKjLs8QXFNl7N9%2BpQcxemttb58KasoyO%2BZby7dg%3D%3D"); /*
																																 * Service
																																 * Key
																																 */
			urlBuilder2.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
			urlBuilder2.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("10", "UTF-8")); /* 한 페이지 결과 수 */
			urlBuilder2.append("&" + URLEncoder.encode("dataType", "UTF-8") + "="
					+ URLEncoder.encode("JSON", "UTF-8")); /* 요청자료형식(XML/JSON)Default: XML */
			urlBuilder2.append("&" + URLEncoder.encode("regId", "UTF-8") + "="
					+ URLEncoder.encode(addr2[i], "UTF-8")); /* 11B0000 서울, 인천, 경기도 11D10000 등 (활용가이드 하단 참고자료 참조) */
			urlBuilder2.append("&" + URLEncoder.encode("tmFc", "UTF-8") + "=" + URLEncoder.encode(now+"1800",
					"UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600(1800)-최근 24시간 자료만 제공*/
			URL url2 = new URL(urlBuilder2.toString());
			HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
			conn2.setRequestMethod("GET");
			conn2.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn2.getResponseCode());
			BufferedReader rd2;
			if (conn2.getResponseCode() >= 200 && conn2.getResponseCode() <= 300) {
				rd2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
			} else {
				rd2 = new BufferedReader(new InputStreamReader(conn2.getErrorStream()));
			}
			StringBuilder sb2 = new StringBuilder();
			String line2;
			while ((line2 = rd2.readLine()) != null) {
				sb2.append(line2);
			}
			rd2.close();
			conn2.disconnect();
			System.out.println(sb2.toString());
			String result2 = sb2.toString();

			// Json parser를 만들어 만들어진 문자열 데이터를 객체화
			JSONParser parser2 = new JSONParser();
			JSONObject obj2 = (JSONObject) parser2.parse(result2);
			// response 키를 가지고 데이터를 파싱
			JSONObject parse_response2 = (JSONObject) obj2.get("response");
			// response 로 부터 body 찾기
			JSONObject parse_body2 = (JSONObject) parse_response2.get("body");
			// body 로 부터 items 찾기
			JSONObject parse_items2 = (JSONObject) parse_body2.get("items");

			// items로 부터 itemlist 를 받기
			JSONArray parse_item2 = (JSONArray) parse_items2.get("item");
			JSONObject weather2; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용
			// 카테고리와 값만 받아오기
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
			String wf3Am = null;
			String wf3Pm = null;
			String wf4Am = null;
			String wf4Pm = null;
			String wf5Am = null;
			String wf5Pm = null;
			String wf6Am = null;
			String wf6Pm = null;
			String wf7Am = null;
			String wf7Pm = null;
			String regId2 = null;

			for (int j = 0; j < parse_item.size(); j++) {
				obj = (JSONObject) parse_item.get(j);
				obj2 = (JSONObject) parse_item2.get(j);
				doNm = (String) obj.get("regId");
				regId2 = (String) obj2.get("regId");
				taMin3 = obj.get("taMin3");
				taMax3 = obj.get("taMax3");
				taMin4 = obj.get("taMin4");
				taMax4 = obj.get("taMax4");
				taMin5 = obj.get("taMin5");
				taMax5 = obj.get("taMax5");
				taMin6 = obj.get("taMin6");
				taMax6 = obj.get("taMax6");
				taMin7 = obj.get("taMin7");
				taMax7 = obj.get("taMax7");
				rnSt3Am = obj2.get("rnSt3Am");
				rnSt3Pm = obj2.get("rnSt3Pm");
				rnSt4Am = obj2.get("rnSt4Am");
				rnSt4Pm = obj2.get("rnSt4Pm");
				rnSt5Am = obj2.get("rnSt5Am");
				rnSt5Pm = obj2.get("rnSt5Pm");
				rnSt6Am = obj2.get("rnSt6Am");
				rnSt6Pm = obj2.get("rnSt6Pm");
				rnSt7Am = obj2.get("rnSt7Am");
				rnSt7Pm = obj2.get("rnSt7Pm");
				wf3Am = (String) obj2.get("wf3Am");
				wf3Pm = (String) obj2.get("wf3Pm");
				wf4Am = (String) obj2.get("wf4Am");
				wf4Pm = (String) obj2.get("wf4Pm");
				wf5Am = (String) obj2.get("wf5Am");
				wf5Pm = (String) obj2.get("wf5Pm");
				wf6Am = (String) obj2.get("wf6Am");
				wf6Pm = (String) obj2.get("wf6Pm");
				wf7Am = (String) obj2.get("wf7Am");
				wf7Pm = (String) obj2.get("wf7Pm");
			}
			if (doNm.equals("11B10101")) {
				doNm = "서울시";
			}
			if (doNm.equals("11B20201")) {
				doNm = "인천시";
			}
			if (doNm.equals("11B20305")) {
				doNm = "경기도";
			}
			if (doNm.equals("11C10301")) {
				doNm = "충청북도";
			}
			if (doNm.equals("11C20101")) {
				doNm = "충청남도";
			}
			if (doNm.equals("11C20401")) {
				doNm = "대전시";
			}
			if (doNm.equals("11D10301")) {
				doNm = "강원도";
			}
			if (doNm.equals("11F10201")) {
				doNm = "전라북도";
			}
			if (doNm.equals("11F20401")) {
				doNm = "전라남도";
			}
			if (doNm.equals("11F20501")) {
				doNm = "광주시";
			}
			if (doNm.equals("11H10201")) {
				doNm = "경상북도";
			}
			if (doNm.equals("11H10701")) {
				doNm = "대구시";
			}
			if (doNm.equals("11H20101")) {
				doNm = "울산시";
			}
			if (doNm.equals("11H20201")) {
				doNm = "부산시";
			}
			if (doNm.equals("11H20301")) {
				doNm = "경상남도";
			}
			if (doNm.equals("11G00201")) {
				doNm = "제주도";
			}
			////////////////////////////////////////////////////////
			Weather weather = new Weather();
			weather.setTaMax(weather.getTaMax1());
			weather.setTaMin(weather.getTaMin1());
			weather.setTaMax1(weather.getTaMax2());
			weather.setTaMin1(weather.getTaMin2());
			weather.setTaMax2(weather.getTaMax3());
			weather.setTaMin2(weather.getTaMin3());
			weather.setTaMin3(taMin3);
			weather.setTaMax3(taMax3);
			weather.setTaMin4(taMin4);
			weather.setTaMax4(taMax4);
			weather.setTaMin5(taMin5);
			weather.setTaMax5(taMax5);
			weather.setTaMin6(taMin6);
			weather.setTaMax6(taMax6);
			weather.setTaMin7(taMin7);
			weather.setTaMax7(taMax7);
			
			weather.setRnStAm(weather.getRnSt1Am());
			weather.setRnStPm(weather.getRnSt1Pm());
			weather.setRnSt1Am(weather.getRnSt2Am());
			weather.setRnSt1Pm(weather.getRnSt2Pm());
			weather.setRnSt2Am(weather.getRnSt3Am());
			weather.setRnSt2Pm(weather.getRnSt3Pm());
			weather.setRnSt3Am(rnSt3Am);
			weather.setRnSt3Pm(rnSt3Pm);
			weather.setRnSt4Am(rnSt4Am);
			weather.setRnSt4Pm(rnSt4Pm);
			weather.setRnSt5Am(rnSt5Am);
			weather.setRnSt5Pm(rnSt5Pm);
			weather.setRnSt6Am(rnSt6Am);
			weather.setRnSt6Pm(rnSt6Pm);
			weather.setRnSt7Am(rnSt7Am);
			weather.setRnSt7Pm(rnSt7Pm);
			
			weather.setWfAm(weather.getWf1Am());
			weather.setWfPm(weather.getWf1Pm());
			weather.setWf1Am(weather.getWf2Am());
			weather.setWf1Pm(weather.getWf2Pm());
			weather.setWf2Am(weather.getWf3Am());
			weather.setWf2Pm(weather.getWf3Pm());
			weather.setWf3Am((String) wf3Am);
			weather.setWf3Pm((String) wf3Pm);
			weather.setWf4Am((String) wf4Am);
			weather.setWf4Pm((String) wf4Pm);
			weather.setWf5Am((String) wf5Am);
			weather.setWf5Pm((String) wf5Pm);
			weather.setWf6Am((String) wf6Am);
			weather.setWf6Pm((String) wf6Pm);
			weather.setWf7Am((String) wf7Am);
			weather.setWf7Pm((String) wf7Pm);
			weather.setDoNm((String) doNm);
			dao.weatherinsert(weather);
		}

	}

}
