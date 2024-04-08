package com.choongang.campick.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.choongang.campick.mapper.CampDAO;
import com.choongang.campick.model.Camp;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CampService {
	
	private final CampDAO dao;
	
	public void campinsert(Camp camp) throws Exception {
		StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B551011/GoCamping/basedList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=voB7ESMA%2BHSFSzn28KxDvL3ub8O44vBlG8EXxn8a4EGLKfCrKjLs8QXFNl7N9%2BpQcxemttb58KasoyO%2BZby7dg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 또는 json*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*통보시간 검색(조회 날짜 입력이 없을 경우 한달동안 예보통보 발령 날짜의 리스트 정보를 확인)*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("campick_test", "UTF-8")); /*통보코드검색(PM10, PM25, O3)*/
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
        System.out.println(sb.toString());
        
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
        		JSONObject gocamping = null; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용
        		
        		for(int i = 0; i < parse_item.size(); i++) {
        			gocamping = (JSONObject) parse_item.get(i);
        			String contentId = (String)gocamping.get("contentId");
        			 String facltNm = (String)gocamping.get("facltNm");
        			 String lctCl = (String)gocamping.get("lctCl");
        			 String allar = (String)gocamping.get("allar");
        			 String intro = (String)gocamping.get("intro");
        			 String featureNm = (String)gocamping.get("featureNm");
        			 String induty = (String)gocamping.get("induty");
        			 String doNm = (String)gocamping.get("doNm");
        			 String sigunguNm = (String)gocamping.get("sigunguNm");
        			 String zipcode = (String)gocamping.get("zipcode");
        			 String addr1 = (String)gocamping.get("addr1");
        			 String mapX = (String)gocamping.get("mapX");
        			 String mapY = (String)gocamping.get("mapY");
        			 String direction = (String)gocamping.get("direction");
        			 String tel = (String)gocamping.get("tel");
        			 String homepage = (String)gocamping.get("homepage");
        			 String manageNmpr = (String)gocamping.get("manageNmpr");
        			 String gnrlSiteCo = (String)gocamping.get("gnrlSiteCo");
        			 String autoSiteCo = (String)gocamping.get("autoSiteCo");
        			 String glampSiteCo = (String)gocamping.get("glampSiteCo");
        			 String caravSiteCo = (String)gocamping.get("caravSiteCo");
        			 String indvdlCaravSiteCo = (String)gocamping.get("indvdlCaravSiteCo");
        			 String tooltip = (String)gocamping.get("tooltip");
        			 String glampInnerFclty = (String)gocamping.get("glampInnerFclty");
        			 String caravInnerFclty = (String)gocamping.get("caravInnerFclty");
        			 String trlerAcmpnyAt = (String)gocamping.get("trlerAcmpnyAt");
        			 String caravAcmpnyAt = (String)gocamping.get("caravAcmpnyAt");
        			 String toiletCo = (String)gocamping.get("toiletCo");
        			 String swrmCo = (String)gocamping.get("swrmCo");
        			 String wtrplCo = (String)gocamping.get("wtrplCo");
        			 String brazierCl = (String)gocamping.get("brazierCl");
        			 String sbrsCl = (String)gocamping.get("sbrsCl");
        			 String sbrsEtc = (String)gocamping.get("sbrsEtc");
        			 String posblFcltyCl = (String)gocamping.get("posblFcltyCl");
        			 String extshrCo = (String)gocamping.get("extshrCo");
        			 String themaEnvrnCl = (String)gocamping.get("themaEnvrnCl");
        			 String animalCmgCl = (String)gocamping.get("animalCmgCl");
        			 String firstImageUrl = (String)gocamping.get("firstImageUrl");
        			 
        			 camp.setAddr1(addr1);
        			 camp.setAllar(allar);
        			 camp.setAnimalCmgCl(animalCmgCl);
        			 camp.setAutoSiteCo(autoSiteCo);
        			 camp.setBrazierCl(brazierCl);
        			 camp.setCaravAcmpnyAt(caravAcmpnyAt);
        			 camp.setCaravInnerFclty(caravInnerFclty);
        			 camp.setCaravSiteCo(indvdlCaravSiteCo);
        			 camp.setContentId(contentId);
        			 camp.setDirection(direction);
        			 camp.setDoNm(doNm);
        			 camp.setExtshrCo(extshrCo);
        			 camp.setFacltNm(facltNm);
        			 camp.setFeatureNm(featureNm);
        			 camp.setFirstImageUrl(firstImageUrl);
        			 camp.setGlampInnerFclty(glampInnerFclty);
        			 camp.setGlampSiteCo(glampSiteCo);
        			 camp.setGnrlSiteCo(gnrlSiteCo);
        			 camp.setHomepage(homepage);
        			 camp.setInduty(induty);
        			 camp.setIndvdlCaravSiteCo(indvdlCaravSiteCo);
        			 camp.setIntro(intro);
        			 camp.setLctCl(lctCl);
        			 camp.setManageNmpr(manageNmpr);
        			 camp.setMapX(mapX);
        			 camp.setMapY(mapY);
        			 camp.setPosblFcltyCl(posblFcltyCl);
        			 camp.setSbrsCl(sbrsCl);
        			 camp.setSbrsEtc(sbrsEtc);
        			 camp.setSigunguNm(sigunguNm);
        			 camp.setSwrmCo(swrmCo);
        			 camp.setTel(tel);
        			 camp.setThemaEnvrnCl(themaEnvrnCl);
        			 camp.setToiletCo(toiletCo);
        			 camp.setTooltip(tooltip);
        			 camp.setTrlerAcmpnyAt(trlerAcmpnyAt);
        			 camp.setWtrplCo(wtrplCo);
        			 camp.setZipcode(zipcode);
        		
        			 dao.insert(camp);
        		}
        		
        		
        		
        		
        		
		}
}
