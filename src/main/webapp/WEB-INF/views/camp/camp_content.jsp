<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>예약 페이지</title>
<jsp:include page="/resources/commons/gnb.jsp" />
<jsp:include page="/resources/commons/header.jsp" />
<script src="./js/details.js"></script>
<link rel="stylesheet" href="./css/details.css">
</head>
<body>
    <main>
        <h1>${result.facltNm }</h1>
        <div class="main-conteiner">
            <div class="imageset-img">
            	<c:if test="${result.firstImageUrl != null}">
                 	<img src="${result.firstImageUrl}">
            	</c:if>
            	<c:if test="${result.firstImageUrl == null}">
                	<img src="./images/ai-generated-8673421_1280.jpg" alt="이미지 1">
            	</c:if>
            </div>
            <div class="contents-right">
            	<div>최대예약인원 : ${result.cmp_maxpp }</div><br/>
            	<div>최대숙박일자 : ${result.cmp_staydate }</div><br/>
            	<div>최대이용금액 : ${result.cmp_price }</div><br/>
            </div>
           </div>
        <div class="contents-button">
        	<div><a href="#" class="inqry">예약하기</a></div>
        	<div><a href="#"><img src="./icons/ico_bell_black.svg"></a></div>
        	<div><a href="#"><img src="./icons/ico_star_black.svg"></a></div>
        	<div><a href="#"><img src="./icons/ico_heart_black.svg"></a></div>
        </div>
        <h1>${result.facltNm }</h1>
        <div class="introduction">
            <div class="intro">
                <img class="profile" src="./images/campicon.png">
            </div> 
            <div class="intro">우리 캠핑장은요~!<br/><br/><br/>
                <c:if test="${result.intro == null }">
                	<div>캠핑장 종류 : ${result.induty }</div><br/>
	                	${result.featureNm }	
                </c:if>
                <c:if test="${result.intro != null }">
                	<div>캠핑장 종류 : ${result.induty }</div><br/>
	                	${result.intro }
                </c:if>
            </div>
        </div>
        <div class="products">
            <h2>물품list</h2>
            <div class="products2">
				<div>화장실 개수 : ${result.toietCo }</div><br/>
				<div>샤워실 개수 : ${result.swrmCo }</div><br/>
				<div>개수대 개수 : ${result.wtrplCo }</div><br/>
				<div>화로대 개수 : ${result.brazierCl }</div><br/>
				<div>소화기 개수 : ${result.extshrCo }</div><br/>
            </div>
        </div>
        <div class="products">
            <h2>주의사항</h2>
            <div class="products2">주의주의</div>
        </div>
        <div class="products">
            <h2>주변환경 및 이용시설</h2>
            <div class="products2">
				<div>주변환경 : ${result.lctCl }</div><br/>
				<div>부대시설 : ${result.sbrsCl }</div><br/>
				<div>기타 부대시설 : ${result.sbrsEtc }</div><br/>
				<div>주변이용시설: ${result.posblFcltyCl }</div><br/>
				<div>테마환경 : ${result.themaEnvrnCl }</div><br/>
				<div>애완동물출입 : ${result.animalCmgCl }</div><br/>
			</div>
        </div>
        <h2>찾아오는 길</h2><br/>
        <div class="mapresult">
            <div id="map"></div>
            <div class="mapresult2">
            	<div>캠핑장이름 : ${result.facltNm }</div><br/>
            	<div>대표번호 : ${result.tel }</div><br/>
            	<div>우편번호 : ${result.zipcode }</div><br/>
            	<div>도로명주소 : ${result.addr1 }</div><br/>
            	<div>홈페이지 : ${result.homepage }</div><br/>
            </div>
        </div>
    
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3ac1a052250440a894c10831b4af0aa7"></script>
    <script src="./js/map.js"></script>
    </main>
</body>
</html>