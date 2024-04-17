<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="./header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script src="./js/gnb.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<meta charset="UTF-8">
<title>gnb</title>
</head>
<body>
	<header>
		<div class="wrap">
			<h1 class="logo">
<<<<<<< HEAD
				<a href="../camp_list"><img src="../images/logo2.png"></a> <span
=======
				<a href="camp_list"><img src="../images/logo2.png"></a> <span
>>>>>>> branch 'master' of https://github.com/jjoonyna/campick.git
					class="sound-only">사이트로고</span>
			</h1>
			<nav class="gnb-wrap">
				<ul class="gnb">
					<li class="depth1"><a href="../camp_list">캠픽정보</a></li>
					<li class="depth1"><a href="../camp_map">캠픽지도</a></li>
					<li class="depth1"><a href="#">캠픽후기</a></li>
					<li class="depth1"><a href="#">캠픽알림</a></li>
				</ul>
			</nav>
			<div class="gnb-right">
				
<!-- 				<div id="dynamicContent"></div> -->
					<c:if test="${sessionScope.user_kind == null }">
		              	<a class="textlinenone" href="login">Login</a>
					</c:if>
					<c:if test="${sessionScope.user_kind == 'u' }">
		               <div class="dropdown">
	             		<button class="dropbtn">
	                		<img src="../icons/ico_profile_black.svg" alt="프로필 사진" class="profile-pic">
	                     	<span class="dropbtn_icon"></span>
	                	</button>
	               		<div class="dropdown-content">
	          
	                        <a id="myPageBtn" href="../user_mypage">마이페이지</a>
		                     <a class="logoutBtn">로그아웃</a>
		                 </div>
		               </div>
					</c:if>
					<c:if test="${sessionScope.user_kind == 'b' }">
		               <div class="dropdown">
	             		<button class="dropbtn">
	                		<img src="../icons/ico_profile_black.svg" alt="프로필 사진" class="profile-pic">
	                     	<span class="dropbtn_icon"></span>
	                	</button>
	               		<div class="dropdown-content">
	          
	                        <a id="myPageBtn" href="../biz_mypage">마이페이지</a>
		                    <a class="logoutBtn" >로그아웃</a>
		                 </div>
		               </div>
					</c:if>
				<!-- 예진,현정누나 변경사항

					<c:if test="${sessionScope.user_id == null }">
						<a href="login"> <img src="../icons/ico_profile_black.svg" alt="로그인"></a>
					</c:if>
					<c:if test="${sessionScope.user_id != null && sessionScope.user_kind=='u' }">
						<a href="user_mypage"> <img src="../icons/ico_profile_black.svg" alt="로그인"></a>
					</c:if>
					<c:if test="${sessionScope.user_id != null && sessionScope.user_kind=='b' }">
						<a href="biz_mypage"> <img src="../icons/ico_profile_black.svg" alt="로그인"></a>
					</c:if>
				-->
			</div>
		</div>
	</header>
</body>
</html>