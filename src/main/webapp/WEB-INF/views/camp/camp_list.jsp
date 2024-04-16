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
<title>camplist</title>
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
               <div class="searchArea">
                  <div class="searchTheme">
                     <label for="induty">테마</label>
                     <select id="induty" name="induty">
                        <option value="" <c:if test="${empty induty}">selected</c:if>>전체</option>
                        <option value="motel" <c:if test="${induty eq 'motel'}">selected</c:if>>일반야영</option>
                        <option value="autocamp" <c:if test="${induty eq 'autocamp'}">selected</c:if>>자동차</option>
                        <option value="trailer" <c:if test="${induty eq 'trailer'}">selected</c:if>>트레일러</option>
                        <option value="caravan" <c:if test="${induty eq 'caravan'}">selected</c:if>>카라반</option>
                        <option value="glamping" <c:if test="${induty eq 'glamping'}">selected</c:if>>글램핑</option>
                     </select>
                  </div>
                  <div class="searchLoc">
                     <label for="doNm">지역</label>
                     <select id="doNm" name="doNm">
                        <option value="" disabled selected>전체</option>
                        <option value="서울시">서울</option>
                        <option value="경기도">경기도</option>
                        <option value="강원도">강원도</option>
                     </select>
                  </div>
                  <div class="searchSigungu">
                     <label for="sigunguNm"></label>
                     <select id="sigunguNm" name="sigunguNm">
                        <option value="" disabled selected>전체</option>
                        <option value="chuncheon">춘천</option>
                        <option value="gangneung">강릉</option>
                     </select>
                  </div>
               </div>


               <!-- 검색창 -->
               <div class="searchBox">
                     <label for="search" id="searchBar">검색</label>
                     <input type="text" id="search" name="search" placeholder="캠핑장명을 검색해주세요">
               </div>




               <!-- 검색 버튼 -->
               <div>
                  <button id="searchBtn">검색</button>
               </div>
               <br> <br> <br> <br>



            <!-- 카드 세트 -->
            <div id="cardlist">
               
            </div>
                     


            <!-- 페이지 -->
            <br>
            <br>
            <div id="pagein"></div>
<!--             <nav class="pagiset_pagiset-circ"> -->
<!--                <div class="pagiset-ctrl"> -->
<!--                   <a -->
<%--                      href="gnb.do?pageNum=1<c:if test="${not empty search}">&search=${search}</c:if><c:if test="${not empty keyword}">&keyword=${keyword}</c:if>" --%>
<!--                      class="pagiset-link_pagiset-first" -->
<!--                   > -->
<!--                      처음 -->
<!--                   </a> -->
<!--                </div> -->
<%--                <c:if test="${result.currentPage gt 1}"> --%>
<!--                   <div class="pagiset-ctrl"> -->
<!--                      <a -->
<%--                         href="gnb.do?pageNum=${result.startPage - 1}<c:if test="${not empty search}">&search=${search}</c:if><c:if test="${not empty keyword}">&keyword=${keyword}</c:if>" --%>
<!--                         class="pagiset-link_pagiset-prev" -->
<!--                         style="width: 100px;" -->
<!--                      > -->
<!--                         이전 -->
<!--                      </a> -->
<!--                   </div> -->
<%--                </c:if> --%>
<!--                <div class="pagiset-list"> -->
<%--                   <c:forEach var="i" begin="${result.startPage}" end="${result.endPage}"> --%>
<!--                      <a -->
<%--                         href="gnb.do?pageNum=${i}<c:if test="${not empty search}">&search=${search}</c:if><c:if test="${not empty keyword}">&keyword=${keyword}</c:if>" --%>
<%--                         class="pagiset-link<c:if test="${result.currentPage==i}"> active-fill</c:if>" --%>
<!--                         style="width: 100px;" -->
<!--                      > -->
<%--                         ${i} --%>
<!--                      </a> -->
<%--                   </c:forEach> --%>
<!--                </div> -->
<%--                <c:if test="${result.currentPage lt result.lastPage}"> --%>
<!--                   <div class="pagiset-ctrl"> -->
<!--                      <a -->
<%--                         href="gnb.do?pageNum=${result.endPage + 1}<c:if test="${not empty search}">&search=${search}</c:if><c:if test="${not empty keyword}">&keyword=${keyword}</c:if>" --%>
<!--                         class="pagiset-link_pagiset-next" -->
<!--                         style="width: 100px;" -->
<!--                      > -->
<!--                         다음 -->
<!--                      </a> -->
<!--                   </div> -->
<%--                </c:if> --%>
<!--                <div class="pagiset-ctrl"> -->
<!--                   <a -->
<%--                      href="gnb.do?pageNum=${result.lastPage}<c:if test="${not empty search}">&search=${search}</c:if><c:if test="${not empty keyword}">&keyword=${keyword}</c:if>" --%>
<!--                      class="pagiset-link_pagiset-last" -->
<!--                      style="width: 100px;" -->
<!--                   > -->
<!--                      마지막 -->
<!--                   </a> -->
<!--                </div> -->
<!--             </nav> -->
<!--          </div> -->
<!--       </div> -->
   </main>
   <jsp:include page="/resources/commons/footer.jsp" />
</body>
</html>