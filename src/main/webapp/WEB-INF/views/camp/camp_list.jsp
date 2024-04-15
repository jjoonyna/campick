<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<jsp:include page="/resources/commons/header.jsp" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/camp_list.css">
<link rel="stylesheet" href="./css/footer.css">
<script src="./js/camp_list.js"></script>
<link rel="icon" href="./images/logo2.png">
<title>CAMPICK</title>
<jsp:include page="/resources/commons/gnb.jsp" />
</head>
<body>

	<main>




		<!-- 상단 검색 영역 -->
		<div class="campland-N19" data-bid="MXLu84reVj" id="">
			<div class="contents-inner">
				<div class="contents-container container-md">
					<div class="textset textset-sub"
						style="text-align: center; font-size: 42px; color: #1F18F0;">
						<p style="font-family: 'Ycomputer-Regular', Times, serif;">
							"어디로 떠나볼까..? "<img src="../icons/car1.gif"
								style="width: 40px; height: 40px;">
						</p>
					</div>
					<br> <br>


					<!-- 검색 항목 -->
						<form method="GET">
					<div style="display: flex; justify-content: center; flex-wrap: wrap;">
						<div style="margin-right: 20px; margin-bottom: 20px;">
							<label for="induty" style="font-size: 18px; margin-right: 8px;">테마</label>
							<select id="induty" name="induty" style="width: 150px;">
								<option value="" disabled selected>전체</option>
								<option value="motel">일반야영</option>
								<option value="autocamp">자동차</option>
								<option value="motel">트레일러</option>
								<option value="caravan">카라반</option>
								<option value="caravan">글램핑</option>
							</select>
						</div>
						<div style="margin-right: 2px;">
							<label for="doNm" style="font-size: 18px; margin-right: 8px;">지역</label>
							<select id="doNm" name="doNm">
								<option value="" disabled selected>전체</option>
								<option value="seoul">서울</option>
								<option value="gyeonggi">경기도</option>
								<option value="gangwon">강원도</option>
							</select>
						</div>
						<div style="margin-bottom: 20px;">
							<label for="sigunguNm" style="font-size: 18px;"></label> <select
								id="sigunguNm" name="sigunguNm">
								<option value="" disabled selected>전체</option>
								<option value="chuncheon">춘천</option>
								<option value="gangneung">강릉</option>
							</select>
						</div>
					</div>






					<!-- 검색창 -->
					<div style="display: flex; justify-content: center;">
							<label for="search" style="font-size: 18px; margin-right: 15px;">검색</label>
							<input type="text" id="search" name="search"
								placeholder="캠핑장명을 검색해주세요"
								style="width: 430px; height: 40px; border: 2px solid #ccc; border-radius: 8px; padding: 0 16px;">
					</div>




					<!-- 검색 버튼 -->
					<div
						style="display: flex; justify-content: center; margin-top: 20px;">
						<button id="searchBtn">검색</button>
					</div>
						</form>
					<br> <br> <br> <br>
					<div>
						<span>
							<h2 class="textset-tit" style="margin-bottom: 18px; font-size: 30px;">
								총&nbsp;3700개의 Pick!<img src="../icons/flag1.gif" style="width: 40px; height: 40px; margin-left: 0px;">
								
							</h2>
						</span>
					</div>

					<!-- 카드 세트 -->
					<div id="cardlist">
					
<%-- 							<c:forEach items="${camplist}" var="vo" varStatus="varStatus"> --%>
<%-- 								<div class="cardset cardset-hor cardset-xl" id="cardInto<c:out value="${varStatus.index}"/>"> --%>
<!-- 									<figure class="cardset-figure"> -->
<%-- 										<img class="cardset-img" src="../images/<c:out value="${vo.cmp_pic}"/>" alt="카드 이미지"> --%>
<!-- 									</figure> -->
<!-- 									<div class="cardset-body"> -->
<%-- 										<h2 class="cardset-tit"><c:out value="${vo.facltNm}"/></h2> --%>
<%-- 										<h6 class="cardset-desc"><c:out value="${vo.lineIntro }"/></h6> --%>
<!-- 										<div class="badgeset-wrap"> -->
<!-- 											<div style="display: flex; align-items: center;"> -->
<!-- 												<img class="icon-sm" src="../icons/ico_location_black.svg" alt="위치 아이콘"> -->
<%-- 												<span style="margin-left: 1px;"><c:out value="${vo.doNm }"/>&nbsp;<c:out value="${vo.sigunguNm }"/></span> --%>
<!-- 												<img class="icon-sm" src="../icons/ico_phone_black.svg" alt="전화 아이콘"> -->
<%-- 												<span style="margin-left: 1px;"><c:out value="${vo.tel }"/></span> --%>
<!-- 												<img class="icon-sm" src="../icons/ico_star_black.svg" alt="즐찾 아이콘"> -->
<%-- 												<span style="margin-left: 1px;"><c:out value="${vo.cmp_fav}"/>회</span> --%>
<!-- 											</div> -->
<!-- 											<br> <br> -->
<!-- 											<div> -->
<%-- 												<c:if test="${vo.toiletCo gt 0}"> --%>
<!-- 													<img src="../images/wc1.png" style="width: 40px; height: 40px;"> -->
<%-- 												</c:if> --%>
<%-- 												<c:if test="${not empty vo.brazierCl}"> --%>
<!-- 													<img src="../images/barbeque1.png" style="width: 40px; height: 40px;"> -->
<%-- 												</c:if> --%>
<%-- 												<c:if test="${vo.swrmCo gt 0}"> --%>
<!-- 													<img src="../images/shower2.png" style="width: 40px; height: 40px;"> -->
<%-- 												</c:if> --%>
<%-- 												<c:if test="${vo.caravSiteCo gt 0}"> --%>
<!-- 													<img src="../images/caravan.png" style="width: 40px; height: 40px;"> -->
<%-- 												</c:if> --%>
<%-- 												<c:if test="${vo.animalCmgCl eq 'Y'}"> --%>
<!-- 													<img src="../images/pet1.png" style="width: 40px; height: 40px;"> -->
<%-- 												</c:if> --%>
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<%-- 							</c:forEach> --%>
<!-- 					</div> -->
				</div>

<!-- 				페이지 -->
				<br>
				<br>
				<div id="pagein"></div>
<!-- 				<nav id="pagiset pagiset-circ"> -->
<!-- 					<div class="pagiset-ctrl"> -->
<!-- 						<a -->
<%-- 							href="gnb.do?pageNum=1<c:if test="${not empty search}">&search=${search}</c:if><c:if test="${not empty keyword}">&keyword=${keyword}</c:if>" --%>
<!-- 							class="pagiset-link pagiset-first" -->
<!-- 							style="width: 100px;" -->
<!-- 						> -->
<!-- 							처음 -->
<!-- 						</a> -->
<!-- 					</div> -->
<%-- 					<c:if test="${result.currentPage gt 1}"> --%>
<!-- 						<div class="pagiset-ctrl"> -->
<!-- 							<a -->
<%-- 								href="gnb.do?pageNum=${result.startPage - 1}<c:if test="${not empty search}">&search=${search}</c:if><c:if test="${not empty keyword}">&keyword=${keyword}</c:if>" --%>
<!-- 								class="pagiset-link pagiset-prev" -->
<!-- 								style="width: 100px;" -->
<!-- 							> -->
<!-- 								이전 -->
<!-- 							</a> -->
<!-- 						</div> -->
<%-- 					</c:if> --%>
<!-- 					<div class="pagiset-list"> -->
<%-- 						<c:forEach var="i" begin="${result.startPage}" end="${result.endPage}"> --%>
<!-- 							<a -->
<%-- 								href="gnb.do?pageNum=${i}<c:if test="${not empty search}">&search=${search}</c:if><c:if test="${not empty keyword}">&keyword=${keyword}</c:if>" --%>
<%-- 								class="pagiset-link<c:if test="${result.currentPage==i}"> active-fill</c:if>" --%>
<!-- 								style="width: 100px;" -->
<!-- 							> -->
<%-- 								${i} --%>
<!-- 							</a> -->
<%-- 						</c:forEach> --%>
<!-- 					</div> -->
<%-- 					<c:if test="${result.currentPage lt result.lastPage}"> --%>
<!-- 						<div class="pagiset-ctrl"> -->
<!-- 							<a -->
<%-- 								href="gnb.do?pageNum=${result.endPage + 1}<c:if test="${not empty search}">&search=${search}</c:if><c:if test="${not empty keyword}">&keyword=${keyword}</c:if>" --%>
<!-- 								class="pagiset-link pagiset-next" -->
<!-- 								style="width: 100px;" -->
<!-- 							> -->
<!-- 								다음 -->
<!-- 							</a> -->
<!-- 						</div> -->
<%-- 					</c:if> --%>
<!-- 					<div class="pagiset-ctrl"> -->
<!-- 						<a -->
<%-- 							href="gnb.do?pageNum=${result.lastPage}<c:if test="${not empty search}">&search=${search}</c:if><c:if test="${not empty keyword}">&keyword=${keyword}</c:if>" --%>
<!-- 							class="pagiset-link pagiset-last" -->
<!-- 							style="width: 100px;" -->
<!-- 						> -->
<!-- 							마지막 -->
<!-- 						</a> -->
<!-- 					</div> -->
<!-- 				</nav> -->
			</div>
		</div>
	</main>
 <jsp:include page="/resources/commons/footer.jsp" />
</body>
</html>
