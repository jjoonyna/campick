<%@ page language='java' contentType='text/html; charset=UTF-8'
	pageEncoding='UTF-8'%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset='UTF-8'>
<title>mypage</title>
<jsp:include page='/resources/commons/header.jsp' />
<link rel='stylesheet' href='./css/user_mypage.css'>
<link rel='stylesheet' href='./css/join.css'>
<script type='text/javascript' src='./js/user_mypage.js'></script>
<script src='http://dmaps.daum.net/map_js_init/postcode.v2.js'></script>
<jsp:include page='/resources/commons/gnb.jsp' />
</head>
<body>

	<main id='main'>
		<div id='mylist'>
			<ul>
				<li>
					<button id='myInfo'>내정보</button>
					<ul id='myInfo_list'>
						<li><button id='myInfo_change'>내정보수정</button></li>
						<li><button id='pw_change'>비밀번호변경</button></li>
						<li><button id='delete'>회원탈퇴</button></li>
					</ul>
				</li>
<!-- 				<li> -->
<!-- 					<button>찜목록</button> -->
<!-- 				</li> -->
				<li>
					<button id='appoint'>예약목록</button>
				</li>
<!-- 				<li> -->
<!-- 					<button id='review'>내후기</button> -->
<!-- 					<ul id='review_list'> -->
<!-- 						<li><button>댓글후기</button></li> -->
<!-- 						<li><button>이용후기</button></li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
			</ul>
		</div>
		<div id='line'></div>



		<div id='mypage'>
			<div id='myInfo_check'>
				<table id='info_table'>
					<caption>내정보</caption>
					<tr>
						<td>id</td>
						<td id='user_id'></td>
					</tr>					
					<tr>
						<td><br>주소</td>
						<td id='user_addr1'><br></td>
					</tr>
				</table>
			</div>
			<div id='review_check'>
				<table id='review_table'>
					<caption>내후기</caption>
					<tr>
						<td>댓글후기 수</td>
						<td>0</td>
					</tr>
					<tr>
						<td><br>이용후기 수</td>
						<td><br>0</td>
					</tr>
				</table>

			</div>
		</div>



		<div id='join_wrap'>
			<h2 class='join_title'>내정보 수정</h2>
			<form>
				<table id='join_t'>





					<tr>
						<th>이름</th>
						<td><input type='text' name='user_nm' id='info_nm' readonly='readonly'
							class='text' /></td>
					</tr>

					<tr>
						<th>닉네임</th>
						<td><input type='text' name='user_nick' id='info_nick'
							class='text' /> &nbsp <input type='button' value='중복 확인'
							class='check' onclick='nick_check()' />
							<div id='nickcheck'></div></td>
					</tr>

					<tr>
						<th>아이디</th>
						<td><input type='text' name='user_id' id='info_id'
							class='text' readonly='readonly' /></td>
					</tr>


					<tr>
						<th>비밀번호</th>
						<td><input type='password' name='user_pw' id='info_pw'
							class='pw' /></td>
					</tr>



					<tr>
						<th>생년월일</th>
						<td><input type='text' name='user_birth' id='info_birth'
							class='text' /></td>
					</tr>


					<tr>
						<th>휴대폰 번호</th>
						<td><input type='tel' name='user_tel' id='info_tel'
							class='text' /></td>
					</tr>

					<tr>
						<th>우편번호</th>
						<td><input name='user_code' id='info_code' class='code'
							type='text' readonly onclick='post_search()' /> &nbsp <input
							type='button' value='우편번호 검색' class='input_button'
							onclick='openDaumPostcode()' /></td>
					</tr>

					<tr>
						<th>기본 주소</th>
						<td><input name='user_addr1' id='info_addr1' class='addr'
							type='text' readonly onclick='post_search()' /></td>
					</tr>

					<tr>
						<th>상세 주소</th>
						<td><input name='user_addr2' id='info_addr2' class='addr'
							type='text' /></td>
					</tr>

					<tr>
						<th>이메일</th>
						<td><input name='user_email' id='info_email' class='email'
							type='text' /></td>
					</tr>

				</table>

				<div id='join_menu'>
					<input type='button' value='수정완료' class='button'
						id='user_change_ok' /> &nbsp <input type='button' value='취소'
						class='cancle' />

				</div>

			</form>
		</div>


		<div id='pw_change_display'>
			<div id='join_wrap'>
				<h2 class='join_title'>비밀번호 변경</h2>
				<form>
					<table id='join_t'>


						<tr>
							<th>아이디</th>
							<td><input type='text' name='user_id' id='change_id'
								class='text' readonly='readonly' /></td>
						</tr>


						<tr>
							<th>현재 비밀번호</th>
							<td><input type='password' name='user_pw' id='change_pw'
								class='pw' /></td>
						</tr>
						<tr>
							<th>새 비밀번호</th>
							<td><input type='password' name='new_user_pw'
								id='new_user_pw' class='pw' /></td>
						</tr>
						<tr>
							<th>새 비밀번호확인</th>
							<td><input type='password' name='new_user_pw2'
								id='new_user_pw2' class='pw' /></td>
						</tr>

					</table>

					<div id='join_menu'>
						<input type='button' value='변경완료' class='button' id='pw_change_ok' />
						&nbsp <input type='button' value='취소' class='cancle' />

					</div>

				</form>
			</div>
		</div>

		<div id='delete_display'>
			<div id='join_wrap'>
				<h2 class='join_title'>회원 탈퇴</h2>
				<form>
					<table id='join_t'>


						<tr>
							<th>아이디</th>
							<td><input type='text' name='user_id' id='delete_id'
								class='text' readonly='readonly' /></td>
						</tr>


						<tr>
							<th>현재 비밀번호</th>
							<td><input type='password' name='user_pw' id='delete_pw'
								class='pw' /></td>
						</tr>

					</table>

					<div id='join_menu'>
						<input type='button' value='탈퇴완료' class='button' id='delete_ok' />
						&nbsp <input type='button' value='취소' class='cancle' />

					</div>

				</form>
			</div>
		</div>


		<!-- 예약자 정보 입력란 -->
		<c:forEach items></c:forEach>
		<div class='boxbox'>
			<div class='boxboxbox'>
				<div>
						<div class='card_body'>
							<h2 class='boldtit'>님의 예약이 완료되었습니다!</h2><br><br>
									<table class='formline'>
										<tr class='onlybottomline'>
											<td class='tabletdtext'>숙소 정보 : </td>
											<td class='tabletdtext'><div class='readdatas' id='cmp_nm' name='cmp_nm' ></div></td>
										</tr>
										<tr class='onlybottomline'>
											<td class='tabletdtext'>위치 : </td>
											<td class='tabletdtext'><div class='readdatas' id='cmp_addr' name='cmp_addr'></div></td>
										</tr>
										<tr class='onlybottomline'>
											<td class='tabletdtext'>날짜 : </td>
											<td class='tabletdtext'><input type='text' id='cmp_startdate' name='cmp_startdate'   class='readdatas'>
											<td class='tabletdtext'><input type='text'  class='readdatas' id='cmp_stay' name='cmp_stay'/></td>
											
										</tr>
										<tr class='onlybottomline'>
											<td class='tabletdtext'>인원 : </td>
											<td class='tabletdtext'><input type='text'  class='readdatas' id='participants' name='apt_pp' required/></td>
										</tr>
										<tr class='onlybottomline'>
											<td class='tabletdtext'>요청 사항 : </td>
											<td class='tabletdtext'><input type='text'  class='readdatas' id='content' name='apt_req' required/></td>
										</tr>
										<tr class='onlybottomline'>
											<td class='tabletdtext'>결제 내역 : </td>
											<td class='tabletdtext'><input type='text' class='readdatas' onchange='payment()' id='apt_price' name='apt_price' required/></td>
										</tr>
									</table>
								</div>
								<br><br>
<!-- 								<div class='bbuttons'> -->
<!--   											<button type='submit' -->
<!-- 											class='aptbutton'>예약 목록</button> -->
<!--   											<button type='reset' class='apt_cancle' -->
<!--   												'>예약 취소</button> -->
<!-- 										</div> -->
						</div>
				</div>
			</div>
					
					
		

	</main>


	<footer> </footer>

</body>
</html>