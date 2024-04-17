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
<link rel="stylesheet" href="../css/footer.css">
<link rel="stylesheet" href="../css/appointment.css">
<script type="text/javascript" src="../js/appointment.js"></script>
</head>
<body>
	
	
	
	<main>
	
	
	
			<!-- 예약 하기 -->
<div class="campland-N19" data-bid="MXLu84reVj" id="">
	<div class="contents-inner">
		<div class="contents-container container-md">
			<div style="text-align: center; font-size: 42px; color: #000000;">
				<h1 style="font-family: 'Ycomputer-Regular', Times, serif;">예약 하기</h1>
			</div><br><br>
	
	
	
			<!-- 예약할 캠핑장 정보 -->
			<div class="boxs">
				<div class="container">
					<div class="cardset cardset-hor cardset-xl">
						<figure class="cardset-figure">
							<img class="cardset-img" src="" id="firstImageUrl"
								alt="카드 이미지">
						</figure>
						<div class="cardset-body">
							<h2 class="cardset-tit " id="facltNm"></h2>
							<h6 class="card-maintext" id="featureNm"></h6>
							<p class="card-maintext" style="padding-top: 5px;"><span id="intro"></span></p>
							<div class="badgeset-wrap">
									<div class="badgeset-group" style="padding-top: 10px;">
										<div class="badgeset badgeset-border badgeset-round badgeset-primary">최대4명</div>
										<div class="badgeset badgeset-fill badgeset-border badgeset-round">캠PICK!</div>
										<div class="badgeset badgeset-fill badgeset-border badgeset-round">키즈 캠핑</div>
										<div class="badgeset badgeset-fill badgeset-border badgeset-round">개별 화장실</div>
										<div class="badgeset badgeset-fill badgeset-border badgeset-round">매점</div><br>
										<div style="padding-top: 10px;">
										<div> 
											<table>
												<tr>
													<td style="padding-top: 15px;"><div>가격 :</div></td>
													<td> </td>
													<td style="padding-left: 10px;"> <span style="font-size: 15px;" id="cmp_price"></span>원 </td>
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
									
										<div class = "formline">
											<table>
												<tr>
													<td class="tabletext">번호</td>
													<td class="tableline">
													<div id="contentId"></div>
													</td>
												</tr>
												<tr>
													<td class="tabletext">유저ID</td>
													<td class="tableline">
													<div id="user_id" ></div>
													</td>
												</tr>
												<tr>
													<td class="tabletext">날짜</td>
													<td class="tableline">
													<input type="date" id="apt_startdate" >
													</td>
												</tr>
												<tr>
										        <td class="tabletext">숙박 일자</td>
										        <td class="tableline">
										            <select id="apt_staydate" name="apt_staydate" onchange="calculatePrice">
										            </select>
										        </td>
										        </tr>
												<tr>
													<td class="tabletext">성명</td>
													<td class="tableline"><input type="text" id="user_nm" name="user_nm"></td>
												</tr>
												<tr>
													<td class="tabletext">인원</td>
													<td class="tableline"><select id="apt_pp" name="apt_pp"></select></td>
												</tr>
												<tr>
													<td class="tabletext">요청 사항</td>
													<td class="tableline"><textarea id="apt_req" name="apt_req" placeholder=" 500자 이내로 요청 사항을 입력해주세요." class="aptrequest"></textarea></td>
												</tr>
												<tr>
													<td class="tabletext">결제 방식</td>
													<td style="padding-left: 10px;"><select id="apt_at" name="user_price" required>
																		  	<option value="default">선택</option>
																		  	<option value="신한">신한</option>
																		  	<option value="국민">국민</option>
																		  	<option value="카카오">카카오</option>
																		  </select> </td>
												</tr>
											</table>
										</div>
								</div>
							</figure>
						</div>
										<br><br>
										<div class="bbuttons">
												<!--  id="camp_appointment_ok" -->
    											<input type="button"
													class="aptbutton" value="예약" onclick="calculatePrice()"/>
    											<input type="button" class="aptcancel" value="취소"/>
    												
  										</div>
					</div>
				</div>
			
							
					

				</div>
			</div>
		</div>	
	</main>
	
</body>
</html>