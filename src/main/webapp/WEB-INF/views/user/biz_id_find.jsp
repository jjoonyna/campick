<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/find.css">
<script type="text/javascript" src="./js/find.js"></script>
	<jsp:include page="/resources/commons/header.jsp"/>
<title>ID찾기</title>
</head>
<body>
	<div id="table">
		<table>
		<caption id="title">사업자 회원 ID찾기</caption>
			<tr>
				<td class="tr">사업자명</td>
				<td class="td"><input type="text" name="user_nm" id="user_nm" class="textbox"></td>
			</tr>
			<tr>
				<td class="tr">사업자번호</td>
				<td class="td"><input type="text" name="user_biz" id="user_biz" class="textbox" ></td>
			</tr>
		</table>
		<button id="biz_id_find">확인</button>
	</div>
	<div id="findid"></div>
</body>
</html>