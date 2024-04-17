<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<jsp:include page="/resources/commons/header.jsp" />
<link rel="stylesheet" href="./css/biz_mypage.css">
<link rel="stylesheet" href="./css/join.css">
<script type="text/javascript" src="./js/biz_mypage.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
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
<!-- 				<li> -->
<!-- 					<button>캠핑장관리</button> -->
<!-- 				</li> -->
				<li>
					<button id="regist_camp">캠핑장등록</button>
				</li>
<!-- 				<li> -->
<!-- 					<button id="review">내후기</button> -->
<!-- 					<ul id="review_list"> -->
<!-- 						<li><button>댓글후기</button></li> -->
<!-- 						<li><button>이용후기</button></li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
			</ul>
		</div>
		<div id="line"></div>


		<div id="mypage">
			<div id="myInfo_check">
				<table id="info_table">
					<caption>내정보</caption>

					<tr>
						<td>id</td>
						<td id="biz_id"></td>
					</tr>
					<tr>
						<td>주소</td>
						<td id="biz_addr1"></td>
					</tr>
				</table>
			</div>
			<div id="review_check">
				<table id="review_table">
					<caption>내후기</caption>
					<tr>
						<td>댓글후기 수</td>
						<td>0</td>
					</tr>
					<tr>
						<td>이용후기 수</td>
						<td>0</td>
					</tr>
				</table>

			</div>
		</div>


		<div id="join_wrap">
			<h2 class="join_title">내정보 수정</h2>
			<form>
				<table id="join_t">




					<tr>
						<th>이름</th>
						<td><input type="text" name="user_nm" id="info_nm" readonly="readonly"
							class="text" /></td>
					</tr>

					<tr>
						<th>닉네임</th>
						<td><input type="text" name="user_nick" id="info_nick"
							class="text" /> &nbsp <input type="button" value="중복 확인"
							class="check" onclick="nick_check()" />
							<div id="nickcheck"></div></td>
					</tr>

					<tr>
						<th>아이디</th>
						<td><input type="text" name="user_id" id="info_id"
							class="text" readonly="readonly" /></td>
					</tr>


					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="user_pw" id="info_pw"
							class="pw" /></td>
					</tr>



					<tr>
						<th>휴대폰 번호</th>
						<td><input type="tel" name="user_tel" id="info_tel"
							class="text" /></td>
					</tr>

					<tr>
						<th>우편번호</th>
						<td><input name="user_code" id="info_code" class="code"
							type="text" readonly onclick="post_search()" /> &nbsp <input
							type="button" value="우편번호 검색" class="input_button"
							onclick="openDaumPostcode()" /></td>
					</tr>

					<tr>
						<th>기본 주소</th>
						<td><input name="user_addr1" id="info_addr1" class="addr"
							type="text" readonly onclick="post_search()" /></td>
					</tr>

					<tr>
						<th>상세 주소</th>
						<td><input name="user_addr2" id="info_addr2" class="addr"
							type="text" /></td>
					</tr>

					<tr>
						<th>이메일</th>
						<td><input name="user_email" id="info_email" class="email"
							type="text" /></td>
					</tr>

				</table>

				<div id="join_menu">
					<input type="button" value="수정완료" class="button"
						id="user_change_ok" /> &nbsp <input type="button" value="취소"
						class="cancle" />

				</div>

			</form>
		</div>


		<div id="pw_change_display">
			<div id="join_wrap">
				<h2 class="join_title">비밀번호 변경</h2>
				<form>
					<table id="join_t">


						<tr>
							<th>아이디</th>
							<td><input type="text" name="user_id" id="change_id"
								class="text" readonly="readonly" /></td>
						</tr>


						<tr>
							<th>현재 비밀번호</th>
							<td><input type="password" name="user_pw" id="change_pw"
								class="pw" /></td>
						</tr>
						<tr>
							<th>새 비밀번호</th>
							<td><input type="password" name="new_user_pw"
								id="new_user_pw" class="pw" /></td>
						</tr>
						<tr>
							<th>새 비밀번호확인</th>
							<td><input type="password" name="new_user_pw2"
								id="new_user_pw2" class="pw" /></td>
						</tr>

					</table>

					<div id="join_menu">
						<input type="button" value="변경완료" class="button" id="pw_change_ok" />
						&nbsp <input type="button" value="취소" class="cancle" />

					</div>

				</form>
			</div>
		</div>

		<div id="delete_display">
			<div id="join_wrap">
				<h2 class="join_title">회원 탈퇴</h2>
				<form>
					<table id="join_t">


						<tr>
							<th>아이디</th>
							<td><input type="text" name="user_id" id="delete_id"
								class="text" readonly="readonly" /></td>
						</tr>


						<tr>
							<th>현재 비밀번호</th>
							<td><input type="password" name="user_pw" id="delete_pw"
								class="pw" /></td>
						</tr>

					</table>

					<div id="join_menu">
						<input type="button" value="탈퇴완료" class="button" id="delete_ok" />
						&nbsp <input type="button" value="취소" class="cancle" />

					</div>

				</form>
			</div>
		</div>




 <div id="regist_wrap">
      <h2 class="regist_title">관리자 캠핑</h2>
      <form name="f" method="post" action="insert_biz_cmp"
         onsubmit="return check()" enctype="multipart/form-data">

         <table id="regist_t">
            <tr>
               <th>ID</th>
               <td><input type="text" id="regist_id" readonly="readonly"></td>
            </tr>
            
            <tr>
               <th>사업자 번호</th>
               <td><input type="text" id="regist_biz" readonly="readonly"></td>
            </tr>

            <tr>
               <th>대표자명</th>
               <td><input type="text" id="regist_nm" readonly="readonly"></td>
            </tr>
            <tr>
               <th>제목</th>
               <td><input name="facltNm" id="regist_name" size="14"
                  class="input_box" /></td>
                  <div></div>
            </tr>
            <tr>
               <th>대표 전화번호</th>
               <td>
                   
               <input name="user_tel" id="regist_tel2"
                  class="input_box" /></td>
            </tr>
            <tr>
               <th>주변환경</th>
               <td><input name="lctCl" id="lctCl" size="14"
                  class="input_box" /></td>
            </tr>
            <tr>
               <th>짧은설명</th>
               <td><input name="lineIntro" id="lineIntro" size="14"
                  class="input_box" /></td>
            </tr>
            <tr>
               <th>자세한 설명</th>
               <td><input type="text" id="intro" placeholder="입력하세요!"
                  style="width: 350px; height: 50px; font-size: 14px;"></td>
            </tr>
            <tr>
               <th>캠핑장 종류</th>
               <td valgn="top"><select name="items1">
                     <option value="motel">일반야영</option>
                     <option value="autocamp">자동차</option>
                     <option value="motel">트레일러</option>
                     <option value="caravan">카라반</option>
                     <option value="caravan">글램핑</option></td>
            </tr>
            <tr>
               <th>우편번호</th>
               <td><input name="zipcode" id="zipcode" size="5"
                  class="input_box" readonly onclick="post_search()" /> <input
                  type="button" value="우편번호검색" class="input_button"
                  onclick="openDaumPostcode()" /></td>
            </tr>

            <tr>
               <th>주소</th>
               <td><input name="regist_addr1" id="regist_addr1" size="50"
                  class="input_box" readonly onclick="post_search()" /></td>
            </tr>


            <tr>
               <th>홈페이지</th>
               <td><input name="regist_addr2" id="regist_addr2" size="37"
                  class="input_box" /></td>
            </tr>
            <tr>
               <th>화장실 개수</th>
               <td valgn="top"><select name="items1">
                     <option value="1">1</option>
                     <option value="2">2</option>
                     <option value="3">3</option>
                     <option value="4">4</option>
                     <option value="5">5</option>
               </select></td>
            </tr>

            <tr>
               <th>샤워실 개수</th>
               <td valgn="top"><select name="items1">
                     <option value="1">1</option>
                     <option value="2">2</option>
                     <option value="3">3</option>
                     <option value="4">4</option>
                     <option value="5">5</option>
               </select></td>
            </tr>
            <tr>
               <th>개수대 개수</th>
               <td valgn="top"><select name="items1">
                     <option value="1">1</option>
                     <option value="2">2</option>
                     <option value="3">3</option>
                     <option value="4">4</option>
                     <option value="5">5</option>
               </select></td>
            </tr>
            <tr>
               <th>화로대 개수</th>
               <td valgn="top"><select name="items1">
                     <option value="1">1</option>
                     <option value="2">2</option>
                     <option value="3">3</option>
                     <option value="4">4</option>
                     <option value="5">5</option>
               </select></td>
            </tr>
            <tr>
               <th>부대시설</th>
               <td><input name="regist_addr2" id="regist_addr2" size="37"
                  class="input_box" /></td>
            </tr>
            <tr>
               <th>부대시설 기타</th>
               <td><input name="regist_addr2" id="regist_addr2" size="37"
                  class="input_box" /></td>
            </tr>
            <tr>
               <th>주변이용시설</th>
               <td><input name="regist_addr2" id="regist_addr2" size="37"
                  class="input_box" /></td>
            </tr>
            <tr>
               <th>소화기 개수</th>
               <td valgn="top"><select name="items1">
                     <option value="1">1</option>
                     <option value="2">2</option>
                     <option value="3">3</option>
                     <option value="4">4</option>
                     <option value="5">5</option>
               </select></td>
            </tr>
            <tr>
               <th>테마 환경</th>
               <td><input name="regist_addr2" id="regist_addr2" size="37"
                  class="input_box" /></td>
            </tr>
            <tr>
               <th>애완동물출입</th>
               <td><input name="regist_addr2" id="regist_addr2" size="37"
                  class="input_box" /></td>
            </tr>



         </table>

         <div id="regist_menu">
            <input type="submit" value="등록" class="input_button" /> <input
               type="reset" value="취소" class="input_button"
               onclick="$('#regist_id').focus();" />
         </div>
      </form>
   </div>


	</main>
</body>
</html>