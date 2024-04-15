<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<jsp:include page="/resources/commons/header.jsp" />
<jsp:include page="/resources/commons/gnb.jsp" />
<title>예약 내역</title>
<link rel="stylesheet" href="./css/camp_result.css">
<script type="text/javascript" src="./js/camp_result.js"></script>
</head>
<body>
<main>
	
	
	
			<!-- 예약 하기 -->
			<div class="main h1">
				<h1>예약 내역</h1>
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
													<td class="tabletdtext"><div class="readdatas" id="cmp_nm" >${result.facltNm }</div></td>
												</tr>
												<tr class="onlybottomline">
													<td class="tabletdtext">위치 : </td>
													<td class="tabletdtext"><div class="readdatas" id="cmp_addr" >${result.addr1 }</div></td>
												</tr>
												<tr class="onlybottomline">
													<td class="tabletdtext">날짜 : </td>
													<td class="tabletdtext"><input type="text" id="cmp_startdate" name="cmp_startdate" value="${result.cmp_startdate}"  class="readdatas">
													<td class="tabletdtext"><input type="text"  class="readdatas" id="cmp_stay" name="cmp_stay" value="${result.cmp_stay}"/></td>
													
												</tr>
												<tr class="onlybottomline">
													<td class="tabletdtext">인원 : </td>
													<td class="tabletdtext"><input type="text"  class="readdatas" id="participants" name="participants" value="${result.apt_pp }" required/></td>
												</tr>
												<tr class="onlybottomline">
													<td class="tabletdtext">요청 사항 : </td>
													<td class="tabletdtext"><input type="text"  class="readdatas" id="content" name="content" value="${apt_req }" required/></td>
												</tr>
												<tr class="onlybottomline">
													<td class="tabletdtext">결제 내역 : </td>
													<td class="tabletdtext"><input type="text" class="readdatas" onchange="payment()" id="bankSelect" name="user_price" value="${apt_price }" required/></td>
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
					<br><br><br><br><br><br><br><br><br><br><br><br>

</body>
</html>