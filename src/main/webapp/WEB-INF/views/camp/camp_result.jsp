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
													<td class="tabletdtext"><span class="readdatas" id="facltNm" ></span></td>
												</tr>
												<tr class="onlybottomline">
													<td class="tabletdtext">위치 : </td>
													<td class="tabletdtext"><span class="readdatas" id="addr1" ></span></td>
												</tr>
												<tr class="onlybottomline">
													<td class="tabletdtext">날짜 : </td>
													<td class="tabletdtext"><span id="apt_startdate" name="cmp_startdate" class="readdatas" ></span>,
													<td class="tabletdtext"><span class="readdatas" id="apt_staydate" name="cmp_stay"></span>박</td>
													
												</tr>
												<tr class="onlybottomline">
													<td class="tabletdtext">인원 : </td>
													<td class="tabletdtext"><span class="readdatas" id="apt_pp" name="participants"></span>명</td>
												</tr>
												<tr class="onlybottomline">
													<td class="tabletdtext">요청 사항 : </td>
													<td class="tabletdtext"><span class="readdatas" id="apt_req" name="content" ></span></td>
												</tr>
												<tr class="onlybottomline">
													<td class="tabletdtext">결제 내역 : </td>
													<td class="tabletdtext"><span class="readdatas" onchange="payment()" id="user_price" name="user_price"></span></td>
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