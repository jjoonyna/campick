<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/find.css">
<script type="text/javascript" src="./js/find.js"></script>
<jsp:include page="/resources/commons/header.jsp" />
<title>ID찾기</title>
</head>
<body>
	<div id="table">
		<table>
			<caption id="title">ID찾기</caption>
			<tr>
				<td class="tr">이름</td>
				<td class="td"><input type="text" name="user_nm" id="user_nm"
					class="textbox"></td>
			</tr>
			<tr>
				<td class="tr">전화번호</td>
				<td class="td"><input type="text" name="user_tel" id="user_tel"
					class="textbox"></td>
			</tr>
		</table>
		<button id="user_id_find">확인</button>
	</div>
	<div id="findid"></div>
</body>
</html>