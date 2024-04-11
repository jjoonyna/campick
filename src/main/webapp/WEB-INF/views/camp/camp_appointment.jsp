<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<jsp:include page="/resources/commons/header.jsp" />
<jsp:include page="/resources/commons/gnb.jsp" />
<title>예약 페이지</title>
<link rel="stylesheet" href="./css/appointment.css">
<script type="text/javascript" src="./js/appointment.js"></script>
</head>
<body>
	
	
	
	<main>
	
	
	
			<!-- 예약 하기 -->
			<div style="text-align: center; font-size: 42px; color: #000000;">
				<p style="font-family: 'Ycomputer-Regular', Times, serif;">예약 하기</p>
			</div><br><br>
	
	
	
			<!-- 예약할 캠핑장 정보 -->
			<div class="boxs">
				<div class="container">
					<div class="cardset cardset-hor cardset-xl">
						<figure class="cardset-figure">
							<img class="cardset-img" src="./images/img_campland_N19_1.png"
								alt="카드 이미지">
						</figure>
						<div class="cardset-body">
							<h2 class="cardset-tit">마천도 서울 카라반</h2>
							<h6 class="cardset-desc">귀요운 현정언니 출몰 지역!</h6>
							<p class="cardset-desc" style="padding-top: 5px;">경기도 서울시 마천에 위치한 현정 캠핑장으로 인근 20km 내에 마트와 편의시설, <br>
													그리고 현정 언니와 놀 수 있는 기회가 있습니다. ^^ 놀러 오세요잉~!!!</p>
							<div class="badgeset-wrap">
									<div class="badgeset-group" style="padding-top: 10px;">
										<div class="badgeset badgeset-fill badgeset-border badgeset-round badgeset-primary">최대4명</div>
										<div class="badgeset badgeset-fill badgeset-border badgeset-round">캠PICK!</div>
										<div class="badgeset badgeset-fill badgeset-border badgeset-round">키즈 캠핑</div>
										<div class="badgeset badgeset-fill badgeset-border badgeset-round">개별 화장실</div>
										<div class="badgeset badgeset-fill badgeset-border badgeset-round">매점</div><br>
										<div style="padding-top: 10px;">
										<label for="text">체크인 날짜 : </label> &nbsp <span id="startdate"></span> <label for="select">
										숙박 일자 : </label>
										<select id="stay" name="stay" onchange="calculatePrice()" style="width: 50px;">
											<option value="default">선택</option>
											<option value="1">1박</option>
											<option value="2">2박</option>
											<option value="3">3박</option>
										</select></div> 
										<div> 
											<table>
												<tr>
													<td style="padding-top: 15px;">가격 : </td>
													<td> </td>
													<td style="padding-left: 10px;"> <div id="price"> </div></td>
												</tr>
											</table> 
										</div> 
									</div>
								</div>
							</div>
						</div>
					</div>
				 </div>
				 
				 
				 
				 
				 <br>
				 
				 
				 
				
				<!-- 예약자 정보 입력란 -->
				<div class="boxbox">
					<div class="boxboxbox">
						<div class="cardset cardset-hor cardset-xl" style="padding: 40px;">
							<figure class="cardset-figure">
								<div class="cardset-body">
									<h2 class="cardset-tit">예약자 정보</h2>
										<div class="formline">
											<input type="date"
											id="datepicker" onchange="displaySelectedDate()">
										</div>
										<div class = "formline">
											<table>
												<tr>
													<td class="tabletext">성함</td>
													<td class="tableline"><input type="text" id="user_nm" name="user_nm" value="${user_id}"></td>
												</tr>
												<tr>
													<td class="tabletext">인원</td>
													<td class="tableline"><select id="cmp_maxpp" name="participants" required></select></td>
												</tr>
												<tr>
													<td class="tabletext">요청 사항</td>
													<td class="tableline"><textarea id="content" name="content" placeholder=" 500자 이내로 요청 사항을 입력해주세요." class="aptrequest"></textarea></td>
												</tr>
												<tr>
													<td class="tabletext">결제 방식</td>
													<td style="padding-left: 10px;"><select onchange="payment()" id="bankSelect" name="user_price" required>
																		  	<option value="default">선택</option>
																		  	<option value="신한">신한</option>
																		  	<option value="국민">국민</option>
																		  	<option value="카카오">카카오</option>
																		  </select> <div id="paymentResult"> </div></td>
												</tr>
											</table>
										</div>
								</div>
							</figure>
						</div>
										<br><br>
										<div class="bbuttons">
    											<input type="button"
													class="aptbutton" id="camp_appointment_ok" value="예약"/>
    											<input type="button" class="aptcancel" value="취소"/>
    												
  										</div>
					</div>
				</div>
			
							
					

				
	</main>
</body>
</html>