<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>로그인</title>
<jsp:include page="/resources/commons/gnb.jsp" />
<jsp:include page="/resources/commons/header.jsp" />

<link rel="stylesheet" href="./css/login.css">
<script type="text/javascript" src="./js/login.js"></script>

</head>

<body>


	<main id="main">
		<div id="login_wrap">
			<h2 class="login_title">로그인</h2>

			<div id="login_status">
				<button id="user_login">일반 로그인</button>
				|
				<button id="biz_login">사업자 로그인</button>
			</div>


			<div id="user">
				<form id="user_loginform">
					<input type="hidden" name="user_kind" value="u">
					<div class="login_form">
						<span class="login_name"> <span class="login_id">아이디:
								<input type="text" name="user_id" id="id" size="22" />
						</span>
							<button type="button" id="user_login_ok"
								style="width: 99px; height: 45px">로그인</button> <br> <span
							class="login_pw">비밀번호: <input type="password"
								name="user_pw" id="pwd" size="20" /></span> <span id="login_menu">
								<a id="user_id_find">ID / </a><a id="user_pw_find">PW찾기 | </a><a
								href="user_join">회원가입</a>
						</span>
						</span>
					</div>
				</form>
				<span id="sns_login">
					<button id="kakao_login_ok">
						<img src="./icons/kakao.png" alt="kakao">
					</button>
					<button id="google_login_ok">
						<img src="./icons/google.png" alt="goole">
					</button>
					<button id="naver_login_ok">
						<img src="./icons/naver.png" alt="naver">
					</button>
				</span>
				<hr>
			</div>


			<div id="biz">
				<form method="post">
					<input type="hidden" name="user_kind" value="b">
					<div class="login_form">
						<span class="login_name"> <span class="login_id">아이디:
								<input type="text" name="user_id" id="biz_id" size="22" />
						</span>
							<button type="button" id="biz_login_ok"
								style="width: 99px; height: 45px">로그인</button> <br> <span
							class="login_pw">비밀번호: <input type="password"
								name="user_pw" id="biz_pwd" size="20" /></span> <span id="login_menu">
								<a id="biz_id_find">ID / </a><a id="biz_pw_find">PW찾기 | </a><a
								href="biz_join">회원가입</a>
						</span>
						</span>
					</div>
				</form>
				<hr>
			</div>


		</div>
	</main>




</body>
</html>