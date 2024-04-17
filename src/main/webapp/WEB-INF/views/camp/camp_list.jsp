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
                  
                  
                  
                  <!-- 시/도 -->
                  <div class="searchLoc">
                     <label for="doNm">지역</label>
                     <select id="doNm" name="doNm" onchange="getSigungu()">
                        <option value="" disabled selected>전체</option>
                        <!-- 시/도 총16개 -->
                           <option value="강원도">강원도</option>
                           <option value="경기도">경기도</option>
                           <option value="경상남도">경상남도</option>
                           <option value="경상북도">경상북도</option>
                           <option value="광주시">광주시</option>
                           <option value="대구시">대구시</option>
                           <option value="대전시">대전시</option>
                           <option value="부산시">부산시</option>
                           <option value="서울시">서울시</option>
                           <option value="인천시">인천시</option>
                           <option value="울산시">울산시</option>
                           <option value="전라남도">전라남도</option>
                           <option value="전라북도">전라북도</option>
                           <option value="제주도">제주도</option>
                           <option value="충청남도">충청남도</option>
                           <option value="충청북도">충청북도</option>
                     </select>
                  </div>
                  
                  
                  <!-- 시/군/구 -->
                  <div class="searchSigungu">
                     <label for="sigunguNm"></label>
                     <select id="sigunguNm" name="sigunguNm">
                        <option value="" disabled selected>전체</option>
                     </select>
                  </div>
               </div>
               <script>
             // 데이터
             var data = {
                 "강원도": ["강릉시", "고성군", "동해시", "삼척시", "속초시", "양구군", "양양군", "영월군", "원주시", "인제군", "정선군", "철원군", "춘천시", "태백시", "평창군", "홍천군", "화천군", "횡성군"],
                 "경기도": ["가평군", "고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시", "동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시", "안양시", "양주시", "양평군", "여주시", "연천군", "오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시"],
                 "경상남도": ["창원시", "진주시", "통영시", "사천시", "김해시", "밀양시", "거제시", "양산시", "의령군", "함안군", "창녕군", "고성군", "남해군", "하동군", "산청군", "함양군", "거창군", "합천군"],
                 "경상북도": ["포항시", "경주시", "김천시", "안동시", "구미시", "영주시", "영천시", "상주시", "문경시", "경산시", "군위군", "의성군", "청송군", "영양군", "영덕군", "청도군", "고령군", "성주군", "칠곡군", "예천군", "봉화군", "울진군","울릉군"],
                 "광주시": ["동구", "서구", "남구", "북구", "광산구"],
                 "대구시": ["중구", "동구", "서구", "남구", "북구", "수성구", "달서구", "달성군"],
                 "대전시": ["동구", "중구", "서구", "유성구", "대덕구"],
                 "부산시": ["중구", "서구", "동구", "영도구", "부산진구", "동래구", "남구", "북구", "해운대구", "사하구", "금정구", "강서구", "연제구", "수영구", "사상구", "기장군"],
                 "서울시": ["강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"],
                 "인천시": ["강화군", "계양구", "남구", "남동구", "동구", "부평구", "서구", "연수구", "옹진군", "중구"],
                 "울산시": ["남구", "동구", "북구", "울주군", "중구"],
                 "전라남도": ["강진군", "고흥군", "곡성군", "광양시", "구례군", "나주시", "담양군", "목포시", "무안군", "보성군", "순천시", "신안군", "여수시", "영광군", "영암군", "완도군", "장성군", "장흥군", "진도군", "함평군", "해남군", "화순군"],
                 "전라북도": ["고창군", "군산시", "김제시", "남원시", "무주군",   "부안군", "순창군", "완주군", "익산시", "임실군", "장수군", "전주시", "정읍시", "진안군"],
                 "제주도": ["제주도", "서귀포시"],
                 "충청남도": ["계룡시", "공주시", "논산시", "당진시", "보령시", "서산시", "아산시", "천안시", "금산군", "부여군", "서천군", "연기군", "예산군", "청양군", "태안군", "홍성군"],
                 "충청북도": ["제천시", "청주시", "충주시", "괴산군", "단양군", "보은군", "영동군", "옥천군", "음성군", "진천군", "청원군"]
             };
         
             // 시/도 변경 시 시/군/구를 업데이트하는 함수
             function getSigungu() {
                 var provinceSelect = document.getElementById("doNm");
                 var sigunguSelect = document.getElementById("sigunguNm");
                 var selectedProvince = provinceSelect.value;
         
                 // 기존 시/군/구 옵션 제거
                 sigunguSelect.innerHTML = "<option value='' disabled selected>전체</option>";
         
                 // 선택된 시/도에 따라 시/군/구 추가
                 if (selectedProvince !== "") {
                     var cities = data[selectedProvince];
                     cities.forEach(function(city) {
                         var option = document.createElement("option");
                         option.text = city;
                         sigunguSelect.add(option);
                     });
                 }
             }
            </script>


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