<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>mypage</title>
<link rel="stylesheet" href="./css/user_mypage.css">
<link rel="stylesheet" href="./css/join.css">
<link rel="stylesheet" href="./css/camp_result.css">
<script type="text/javascript" src="./js/camp_result.js"></script>
<script type="text/javascript" src="./js/user_mypage.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<jsp:include page="/resources/commons/header.jsp" />
<jsp:include page="/resources/commons/gnb.jsp" />
</head>
<body>


	<main id="main">
		<div id="mylist">
			<ul>
				<li>
					<button id="myInfo">내정보</button>
					<ul id="myInfo_list">
						<li><button id="myInfo_change">내정보수정</button></li>
						<li><button id="pw_change">비밀번호변경</button></li>
						<li><button id="delete">회원탈퇴</button></li>
					</ul>
				</li>
				<li>
					<button>찜목록</button>
				</li>
				<li>
					<button>예약목록</button>
				</li>
				<li>
					<button id="review">내후기</button>
					<ul id="review_list">
						<li><button>댓글후기</button></li>
						<li><button>이용후기</button></li>
					</ul>
				</li>
			</ul>
		</div>
		<div id="line"></div>

			
		<!-- 예약 하기 -->
		<div class="main h1">
			<h1>예약 목록</h1>
		</div><br><br>


		<!-- 예약자 정보 입력란 -->
		<div class="boxbox">
			<div class="boxboxbox">
				<div style="padding: 40px;">
						<div class="card_body">
							<h2 class="boldtit">${user_id}님의 예약이 완료되었습니다!</h2><br><br>
									<table class="formline">
										<tr class="onlybottomline">
											<td class="tabletdtext">숙소 정보 : </td>
											<td class="tabletdtext"><div class="readdatas" id="cmp_nm" name="cmp_nm" value="마천도 서울 카라반"></div></td>
										</tr>
										<tr class="onlybottomline">
											<td class="tabletdtext">위치 : </td>
											<td class="tabletdtext"><div class="readdatas" id="cmp_addr" name="cmp_addr" value=""></div></td>
										</tr>
										<tr class="onlybottomline">
											<td class="tabletdtext">날짜 : </td>
											<td class="tabletdtext"><input type="text" id="cmp_startdate" name="cmp_startdate" value="${cmp_startdate}"  class="readdatas">
											<td class="tabletdtext"><input type="text"  class="readdatas" id="cmp_stay" name="cmp_stay" value="${cmp_stay}"/></td>
											
										</tr>
										<tr class="onlybottomline">
											<td class="tabletdtext">인원 : </td>
											<td class="tabletdtext"><input type="text"  class="readdatas" id="participants" name="participants" required/></td>
										</tr>
										<tr class="onlybottomline">
											<td class="tabletdtext">요청 사항 : </td>
											<td class="tabletdtext"><input type="text"  class="readdatas" id="content" name="content" required/></td>
										</tr>
										<tr class="onlybottomline">
											<td class="tabletdtext">결제 내역 : </td>
											<td class="tabletdtext"><input type="text" class="readdatas" onchange="payment()" id="bankSelect" name="user_price" required/></td>
										</tr>
									</table>
								</div>
								<br><br>
								<div class="bbuttons">
  											<button type="submit"
											class="aptbutton">예약 목록</button>
  											<button type="reset" class="aptcancel"
  												onclick="$('#board_name').focus();">예약 취소</button>
										</div>
						</div>
				</div>
			</div>
					
					
		


	</main>
</body>
</html>