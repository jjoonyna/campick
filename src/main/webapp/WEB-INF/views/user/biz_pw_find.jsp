<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/find.css">
<script type="text/javascript" src="/resources/js/find.js"></script>
<jsp:include page="/resources/commons/header.jsp" />
<title>비밀번호찾기</title>
</head>
<body>
	<div id="pw_find">
		<div id="table">
			<table>
				<caption id="title">사업자 회원 PW찾기</caption>
				<tr>
					<td class="tr">사업자ID</td>
					<td class="td"><input type="text" name="user_id" id="user_id"
						class="textbox"></td>
				</tr>
				<tr>
					<td class="tr">사업자번호</td>
					<td class="td"><input type="text" name="user_biz"
						id="user_biz" class="textbox"></td>
				</tr>
			</table>
			<button id="biz_pw_find">확인</button>
		</div>
	</div>



	<div id="pw_change">
		<div id="table">
			<table>
				<caption id="title">PW찾기</caption>
				<tr>
					<td class="tr">id</td>
					<td class="td"><input type="text" name="user_id" id="user_id"
						class="textbox"></td>
				</tr>
				<tr>
					<td class="tr">새비밀번호</td>
					<td class="td"><input type="password" name="user_pw"
						id="user_pw" class="textbox"></td>
				</tr>
				<tr>
					<td class="tr">새비밀번호 확인</td>
					<td class="td"><input type="password" name="user_pw2"
						id="user_pw2" class="textbox"></td>
				</tr>
			</table>
			<div id="pwdcheck"></div>
			<button id="user_pw_change">확인</button>
		</div>
	</div>

</body>
</html>