<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./header.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>일반 회원가입 폼</title>
<link rel="stylesheet" type="text/css" href="./css/join.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="./js/join.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

</head>
<body>

	<header>

		<div class="wrap">
			<h1 class="logo">
				<a href="#"><img src="images/logo2.png"></a> <span
					class="sound-only">사이트로고</span>
			</h1>
			<nav class="gnb-wrap">
				<ul class="gnb">
					<li class="depth1"><a href="#">캠픽정보</a></li>
					<li class="depth1"><a href="#">캠픽지도</a></li>
					<li class="depth1"><a href="#">캠픽후기</a></li>
					<li class="depth1"><a href="#">캠픽알림</a></li>
				</ul>
			</nav>
			<div class="gnb-right">
				<c:if test="${sessionScope.user_id == null }">
					<a href="./login.jsp"> <img
						src="./icons/ico_profile_black.svg" alt="로그인"></a>
				</c:if>
				<c:if
					test="${sessionScope.user_id != null && sessionScope.user_kind=='u' }">
					<a href="./user_mypage.jsp"> <img
						src="./icons/ico_profile_black.svg" alt="로그인"></a>
				</c:if>
				<c:if
					test="${sessionScope.user_id != null && sessionScope.user_kind=='b' }">
					<a href="./biz_mypage.jsp"> <img
						src="./icons/ico_profile_black.svg" alt="로그인"></a>
				</c:if>
			</div>
		</div>
	</header>
	<main>
		<div id="join_wrap">
			<h2 class="join_title">일반 회원 가입</h2>
			<form id="user_joinform">
			<input type="hidden" id="user_kind" name="user_kind" value="u">
				<table id="join_t">

				

					<tr>
						<th>이름</th>
						<td><input type="text" name="user_nm" id="user_nm"
							class="text" /></td>
					</tr>

					<tr>
						<th>닉네임</th>
						<td><input type="text" name="user_nick" id="user_nick"
							class="text" /> &nbsp <input type="button" value="중복 확인"
							class="check" onclick="nick_check()" />
							<div id="nickcheck"></div></td>
					</tr>

					<tr>
						<th>아이디</th>
						<td><input type="text" name="user_id" id="user_id"
							class="text" /> &nbsp <input type="button" value="중복 확인"
							class="check" onclick="id_check()" />
							<div id="idcheck"></div></td>
					</tr>


					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="user_pw" id="user_pw"
							class="pw" /></td>
					</tr>

					<tr>
						<th>비밀번호확인</th>
						<td><input type="password" name="user_pw2" id="user_pw2"
							class="pw" /><div id="pwdcheck"></div></td>
					</tr>


					<tr>
						<th>성별</th>
						<td><input type="radio" name="gender" id="man" value="남자"
							checked> 남자 &nbsp <input type="radio" name="gender"
							id="felmaln" value="여자"> 여자</td>
					</tr>

					<tr>
						<th>생년월일</th>
						<td><input type="text" name="user_birth"
							id="user_birth" class="text" /></td>
					</tr>


					<tr>
						<th>휴대폰 번호</th>
						<td><input type="tel" name="user_tel" id="user_tel"
							class="text" /></td>
					</tr>

					<tr>
						<th>우편번호</th>
						<td><input name="user_code" id="user_code" class="code"
							type="text" readonly onclick="post_search()" /> &nbsp <input
							type="button" value="우편번호 검색" class="input_button"
							onclick="openDaumPostcode()" /></td>
					</tr>

					<tr>
						<th>기본 주소</th>
						<td><input name="user_addr1" id="user_addr1" class="addr"
							type="text" readonly onclick="post_search()" /></td>
					</tr>

					<tr>
						<th>상세 주소</th>
						<td><input name="user_addr2" id="user_addr2" class="addr"
							type="text" /></td>
					</tr>

					<tr>
						<th>이메일</th>
						<td><input name="user_email" id="user_email" class="email"
							type="text" /></td>
					</tr>

				</table>

				<div id="join_menu">
					<input type="button" value="회원가입" class="button" id="user_join_ok" />
					&nbsp <input type="button" value="가입취소" class="button" />

				</div>

			</form>
		</div>

	</main>
	<footer> </footer>



</body>
</html>
