<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<jsp:include page="/resources/commons/header.jsp" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/camp_map.css">
<script type="text/javascript" src="./js/camp_map.js"></script>

<title>캠픽 지도</title>
<jsp:include page="/resources/commons/gnb.jsp" />


</head>

<body>
	<main id = "main">
		<div id="select">
			지역<select id="doNm">
				<option>서울시</option>
				<option>인천시</option>
				<option>경기도</option>
				<option>충청북도</option>
				<option>충청남도</option>
				<option>대전시</option>
				<option>강원도</option>
				<option>전라북도</option>
				<option>전라남도</option>
				<option>광주시</option>
				<option>경상북도</option>
				<option>대구시</option>
				<option>울산시</option>
				<option>부산시</option>
				<option>경상남도</option>
				<option>제주도</option>
			</select>
			<button id="search">검색</button>
		</div>
		<div id="weather">오늘의 날씨</div>
		<div id="map" style="width:700px;height:530px;">
			<div id="camp_list"></div>
		</div>
	</main>
	
	
	
	<script  type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5930273cc5e86ccd83defe576222026c"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(35.88216, 128.55180), // 지도의 중심좌표
		        level: 13, // 지도의 확대 레벨
		        mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
		    }; 

		// 지도를 생성한다 
		var map = new kakao.maps.Map(mapContainer, mapOption); 

	</script>
</body>
</html>