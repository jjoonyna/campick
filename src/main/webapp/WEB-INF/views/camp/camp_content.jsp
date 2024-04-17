<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<jsp:include page="/resources/commons/header.jsp" />
<jsp:include page="/resources/commons/gnb.jsp" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>예약 페이지</title>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/details.js"></script>
<link rel="stylesheet" href="../css/details.css">
</head>
<body>
    <main>
    <div id="results">
        <h1 id="facltNm"></h1>
           <div id="dynamicContent"></div>
        <h1>${result.facltNm }</h1>
        <div class="introduction">
            <div class="intro">
                <img class="profile" src="../images/campicon.png">
            </div> 
            <div class="intro">우리 캠핑장은요~!<br/><br/><br/>
                	<div>캠핑장 종류 : <span id="induty"></span></div><br/>
	                	<div id="featureNm"></div>	
	                	<div id="intro"></div>	
            </div>
        </div>
        
        <div class="products">
            <h2>물품list</h2>
            <div class="products2">
				<div>화장실 개수 : <span id="toietCo"></span></div><br/>
				<div>샤워실 개수 : <span id="swrmCo"></span></div><br/>
				<div>개수대 개수 : <span id="wtrplCo"></span></div><br/>
				<div>화로대 개수 : <span id="brazierCl"></span></div><br/>
				<div>소화기 개수 : <span id="extshrCo"></span></div><br/>
            </div>
        </div>
        
        <div class="products">
            <h2>주의사항</h2>
            <div class="products2">
				<ul>
					<li>주의하세요</li>
					<li></li>
					<li></li>
				</ul>
			</div>
        </div>
        <div class="products">
            <h2>주변환경 및 이용시설</h2>
            <div class="products2">
				<div>주변환경 : <span id="lctCl"></span></div><br/>
				<div>부대시설 : <span id="sbrsCl"></span></div><br/>
				<div>기타 부대시설 : <span id="sbrsEtc"></span></div><br/>
				<div>주변이용시설: <span id="posblFcltyCl"></span></div><br/>
				<div>테마환경 : <span id="themaEnvrnCl"></span></div><br/>
				<div>애완동물출입 : <span id="animalCmgCl"></span></div><br/>
			</div>
        </div>
        <h2 class="maps">찾아오는 길</h2><br/>
        <div class="mapresult">
            <div id="map"></div>
            <div class="mapresult2">
            	<div>캠핑장이름 : <span id="facltNm1"></span></div><br/>
            	<div>대표번호 : <span id="tel"></span></div><br/>
            	<div>우편번호 : <span id="zipcode"></span></div><br/>
            	<div>도로명주소 : <span id="addr1"></span></div><br/>
            	<div><a href="#" id="homepage">홈페이지들어가기</a></div><br/>
            </div>
        </div>
        </div>
 
   
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3ac1a052250440a894c10831b4af0aa7"></script>
    <script src="../js/map.js"></script>
    
    
    </main>
    
    <jsp:include page="/resources/commons/footer.jsp" />
    
</body>

</html>