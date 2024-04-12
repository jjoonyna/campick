<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="./header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gnb</title>
</head>
<body>
	<header>
		<div class="wrap">
			<h1 class="logo">
				<a href="camp_list"><img src="./images/logo2.png"></a> <span
					class="sound-only">사이트로고</span>
			</h1>
			<nav class="gnb-wrap">
				<ul class="gnb">
					<li class="depth1"><a href="camp_list">캠픽정보</a></li>
					<li class="depth1"><a href="camp_map">캠픽지도</a></li>
					<li class="depth1"><a href="#">캠픽후기</a></li>
					<li class="depth1"><a href="#">캠픽알림</a></li>
				</ul>
			</nav>
			<div class="gnb-right">
				<c:if test="${sessionScope.user_id == null }">
				<a href="login"> <img src="./icons/ico_profile_black.svg" alt="로그인"></a>
				</c:if>
				<c:if test="${sessionScope.user_id != null && sessionScope.user_kind=='u' }">
				<a href="user_mypage"> <img src="./icons/ico_profile_black.svg" alt="로그인"></a>
				</c:if>
				<c:if test="${sessionScope.user_id != null && sessionScope.user_kind=='b' }">
				<a href="biz_mypage"> <img src="./icons/ico_profile_black.svg" alt="로그인"></a>
				</c:if>
			</div>
		</div>
	</header>
</body>
</html>