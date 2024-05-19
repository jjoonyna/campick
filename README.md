![그림1](https://github.com/jjoonyna/campick/assets/150616454/fee8a794-e409-4dcd-adb5-24b806a84300)

<h1>"날씨에 맟게 캠핑을 즐기고 싶다!"</h1>
<Strong>CAMPICK</Strong><br>
: CAMP 와 PICK의 합성어로, "캠핑장을 PICK"라는 뜻입니다.
<br><br><br>
<Strong>CAMPICK</Strong>은 최근 늘어난 캠퍼들을 위해 날씨 정보를 기반으로<br> 원하는 날씨에 맞게 캠핑장 추천 및 주변 관광지 안내 & 예약 사이트입니다.
<br><br><br>
<h2>프로젝트 일정</h2><br>
: 24.03.18 ~ 24.04.12 <Strong>(중앙정보기술인재개발원 1차 프로젝트)</Strong>
<br><br><br>


<table>
	<h2>역할 분담</h2>
	<cation>team '불4조 기4단'</cation>
	<th><img width="140" alt="나원준" src="https://github.com/jjoonyna/moggozi2/assets/150616454/49ec8571-f6fc-4d88-ad7e-60505e32b751"><br>나원준<br>@jjoonyna </th>
 	<th><img width="160" alt="김한석" src="https://github.com/jjoonyna/moggozi2/assets/150616454/8edbbf33-e2ce-47cd-9add-e2119881e6ea"><br>김한석<br>@hanssec </th>
  	<th><img width="160" alt="임정석" src="https://github.com/jjoonyna/moggozi2/assets/150616454/6955d21c-9370-40fb-be97-4b7ba37176f8"><br>임정석<br>@edgar-gy</th>
   	<th><img width="160" alt="배현정" src="https://github.com/jjoonyna/moggozi2/assets/150616454/de13f1e9-8e6b-4ec1-b68d-8547a191c6e6"><br>배현정<br>@qkqhdhwhs </th>
    	<th><img width="160" alt="장예진" src="https://github.com/jjoonyna/moggozi2/assets/150616454/686f021e-89de-4497-975f-b1d53181f85f"><br>장예진<br>@jyj95 </th>
     	<th><img width="150" alt="정윤선" src="https://github.com/jjoonyna/moggozi2/assets/150616454/108d0ff6-ab5c-4f07-953f-7047f088188f"><br>정윤선<br>@myaongE</th>
	<tr>
		<td>
      <Strong>회원 관리 FRONT</Strong><br>
			- 회원가입<br>
      - 로그인<br>
			- 마이페이지<br>
      <br>
      <Strong>캠핑장 목록 READ</Strong><br>
			- 캠핑장/날씨 openAPI를 이용한 캠핑장 목록<br><br>
			- 형상 관리<br>
		</td>
		<td>
      <Strong>회원 관리 CUD</Strong><br>
			- 회원가입<br>
      - 정보 수정<br>
      - 회원 탈퇴<br>
      <br>
      <Strong>캠핑장 목록 FRONT</Strong><br>
			- 캠핑장 목록<br>
		</td>
  	<td>
      <Strong>회원 관리 READ</Strong><br>
			- 로그인<br>
      - 예약 목록<br>
      - 후기 확인 조회<br>
      <br><br>
			- 캠핑장 등록<br>
		</td>
  	<td>
      <Strong>사업자 관리 CUD</Strong><br>
			- 회원가입<br>
      - 로그아웃<br>
      - 마이페이지<br>
      <br>
      <Strong>상세보기 FRONT</Strong><br>
			- 지도/관광지 API로 <br>캠핑장 상세보기<br>
      <br>
      <Strong>예약 READ</Strong><br>
      - AJAX 처리
		</td>
  	<td>
      <Strong>사업자 관리 FRONT</Strong><br>
			- 회원가입<br>
      - 로그인<br>
      - 마이페이지<br>
      - 예약관리/내역<br>
      <br>
      <Strong>상세보기 READ</Strong><br>
			- 상세보기 리스트<br>
			- 지도/관광지 API<br>
      <br>
		</td>
  	<td>
      <Strong>사업자 관리 READ</Strong><br>
      - 사업자 API로 기능 구현<br>
			- 회원가입<br>
      - 로그아웃<br>
      - 마이페이지<br>
      <br>
      <Strong>상세보기 CUD</Strong><br>
			- 상세보기 목록<br>
      <br>
      <Strong>예약 FRONT</Strong><br>
      - 예약 하기<br>
      - 예약 내역<br>
		</td>
  </tr>
</table>

<br><br><br>

<table>
	<caption><h2>개발 환경</h2></caption>
	<tr>
		<td>OS</td>
		<td>Linux, Window</td>
	</tr>
	<tr>
		<td>Language</td>
		<td>JAVA(17), HTML/CSS, Java Script</td>
	</tr>
	<tr>
		<td>Front</td>
		<td>HTML, CSS, JavaScript, Ajax</td>
	</tr>
	<tr>
		<td>Framework</td>
		<td>Spring Boot 3.2.4</td>
	</tr>
	<tr>
		<td>DB</td>
		<td>MySQL 8.0.36, MyBatis</td>
	</tr>
	<tr>
		<td>IDE</td>
		<td>STS4, intelliJ</td>
	</tr>
 	<tr>
		<td>ETC</td>
		<td>REST API, RDS</td>
	</tr>
</table>	
<br><br><br>
<h2>요구사항 분석</h2>

![그림1](https://github.com/jjoonyna/campick/assets/150616454/5636ae6d-53df-4cb2-8644-83a73388fbd0)
![그림2](https://github.com/jjoonyna/campick/assets/150616454/4426b021-dcca-423a-ad23-3a4da3577255)
![그림3](https://github.com/jjoonyna/campick/assets/150616454/6ad39b66-b2ed-42a2-88bc-e76f693a584f)



<br><br><br>
<h2>DB</h2>
<img width="762" alt="그림4" src="https://github.com/jjoonyna/campick/assets/150616454/e8284b62-2302-4433-8a15-ea3367ac4ba4">
 

<br><br><br>
<h2>작업 흐름도</h2>


![슬라이드13](https://github.com/jjoonyna/campick/assets/150616454/bbf69391-12f1-491e-8272-dcada1b8cb42)
![슬라이드14](https://github.com/jjoonyna/campick/assets/150616454/ddca55e1-93a9-4327-81b9-e62aef92182f)

<br><br><br>
<h2>Color&Font</h2>

![슬라이드15](https://github.com/jjoonyna/campick/assets/150616454/aad487fd-8d47-4c6b-9169-e7362a248da3)


