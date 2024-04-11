//취소버튼 클릭시
$(function(){
	$('.cancle').click(function(){
		location="biz_mypage";
	});
});
	 	 
function post_search(){
	alert("우편번호 검색 버튼을 클릭하세요!");
}

function post_check(){
	window.open("zipcode_find.do","우편번호검색","width=420,height=200,scrollbars=yes");
}

// 아이디 중복 체크
function id_check(){
	$("#idcheck").hide();//idcheck span 아이디 영역을 숨긴다.
	var memid=$("#user_id").val();
	//1.입력글자 길이 체크
	if($.trim($("#user_id").val()).length < 4){
		var newtext='<font color="red">아이디는 4자 이상이어야 합니다.</font>';
		$("#idcheck").text('');
		$("#idcheck").show();
		$("#idcheck").append(newtext);//span 아이디 영역에 경고문자 추가
		$("#user_id").val("").focus();
		return false;
	};
	if($.trim($("#user_id").val()).length >12){
		var newtext='<font color="red">아이디는 12자 이하이어야 합니다.</font>';
		$("#idcheck").text('');
		$("#idcheck").show();
		$("#idcheck").append(newtext);
		$("#user_id").val("").focus();
		return false;
	};
	//입력아이디 유효성 검사
	if(!(validate_userid(memid))){
		var newtext='<font color="red">아이디는 영문소문자,숫자,_ 조합만 가능합니다.</font>';
		$("#idcheck").text('');		
		$("#idcheck").show();		
		$("#idcheck").append(newtext);
		$("#user_id").val("").focus();
		return false;
	};
	
	var user_id = $("#user_id").val();
	//아이디 중복확인
    $.ajax({
        type:"GET",
        url:"http://localhost:80/nickname_check/"+user_id,
        success: function (data) { 
//        	alert("return success="+data);
      	  if(data==1){			//중복 ID
      		var newtext='<font color="red">중복 아이디입니다.</font>';
      			$("#idcheck").text('');
        		$("#idcheck").show();
        		$("#idcheck").append(newtext);
          		$("#user_id").val('').focus();
          		return false;
	     
      	  }else{				//사용 가능한 ID
      		var newtext='<font color="blue">사용가능한 아이디입니다.</font>';
      		$("#idcheck").text('');
      		$("#idcheck").show();
      		$("#idcheck").append(newtext);
      		$("#user_pw1").focus();
      	  }  	    	  
        }
        ,
    	  error:function(e){
    		  alert("data error"+e);
    	  }
      });//$.ajax		
};

// 닉네임 중복 체크
function nick_check(){
	$("#nickcheck").hide();//idcheck span 아이디 영역을 숨긴다.
	var memid=$("#user_nick").val();
	//1.입력글자 길이 체크
	if($.trim($("#user_nick").val()).length < 2){
		var newtext='<font color="red">닉네임은 2자 이상이어야 합니다.</font>';
		$("#nickcheck").text('');
		$("#nickcheck").show();
		$("#nickcheck").append(newtext);//span 아이디 영역에 경고문자 추가
		$("#user_nick").val("").focus();
		return false;
	};
	if($.trim($("#user_nick").val()).length >12){
		var newtext='<font color="red">닉네임은 12자 이하이어야 합니다.</font>';
		$("#nickcheck").text('');
		$("#nickcheck").show();
		$("#nickcheck").append(newtext);
		$("#user_nick").val("").focus();
		return false;
	};
	
	var user_nick = $("#user_nick").val();
	//닉네임 중복확인
    $.ajax({
        type:"GET",
        url:"http://localhost:80/nickname_check/"+user_nick,
        success: function (data) { 
//        	alert("return success="+data);
      	  if(data==1){			
      		var newtext='<font color="red">중복된 닉네임입니다.</font>';
      			$("#nickcheck").text('');
        		$("#nickcheck").show();
        		$("#nickcheck").append(newtext);
          		$("#user_nick").val('').focus();
          		return false;
	     
      	  }else{				
      		var newtext='<font color="blue">사용가능한 닉네임입니다.</font>';
      		$("#nickcheck").text('');
      		$("#nickcheck").show();
      		$("#nickcheck").append(newtext);
      		$("#user_nick").focus();
      	  }  	    	  
        }
        ,
    	  error:function(e){
    		  alert("data error"+e);
    	  }
      });//$.ajax	
};


// 정규 표현식 검사
function validate_userid(memid){
  var pattern= new RegExp(/^[a-z0-9_]+$/);  //영문 소문자,숫자 ,_가능,정규표현식
  
  return pattern.test(memid);
};
 
function domain_list() {
	var num=f.mail_list.selectedIndex;  //selectedIndex속성은 select객체하위의 속성으로서 해당리스트 목록번호를 반환
	
	if ( num == -1 ) {					//num==-1은 해당 리스트목록이 없다
		return true;
	}
	if(f.mail_list.value=="0"){  		// 직접입력
		 f.join_maildomain.value="";
		 f.join_maildomain.readOnly=false;
		 f.join_maildomain.focus();
	}else {								//리스트목록을 선택했을때	 
		f.join_maildomain.value=f.mail_list.options[num].value;
		f.join_maildomain.readOnly=true;
	 }
 }
//프로필 사진 출력
	function setThumbnail(event) {
        const reader = new FileReader();
        const imageContainer = document.getElementById('image_container');
        imageContainer.innerHTML = ''; // 이미지 컨테이너 초기화

        if (event.target.files && event.target.files[0]) {
            const file = event.target.files[0];

            reader.onload = function(event) {
                let img = document.createElement("img");
                img.setAttribute("src", event.target.result);
                imageContainer.appendChild(img);
            };

            reader.readAsDataURL(file);
        }
    }

// 우편
	function openDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				document.getElementById('user_code').value = data.zonecode;
				document.getElementById('user_addr1').value = data.address;
			}
		}).open();
	};

//가입완료 내용(일반)
$(function(){
   $("#user_join_ok").click(function(){
  	
	 if($.trim($("#user_nm").val())==""){
		 alert("이름을 입력하세요!");
		 $("#user_nm").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_nick").val())==""){
		 alert("닉네임을 입력하세요!");
		 $("#user_nick").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_id").val())==""){
		 alert("아이디를 입력하세요!");
		 $("#user_id").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_pw").val())==""){
		 alert("비밀번호를 입력하세요!");
		 $("#user_pw").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_pw2").val())==""){
		 alert("비밀번호 확인을 입력하세요!");
		 $("#user_pw2").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_pw").val()) != $.trim($("#user_pw2").val())){
		 var newtext='<font color="red">비밀번호가 다릅니다</font>';
      	 $("#pwdcheck").text('');
      	 $("#pwdcheck").show();
      	 $("#pwdcheck").append(newtext);
		 $("#user_pw2").val("");
		 $("#user_pw2").focus();
		 return false;
	 }
	 if($.trim($("#user_birth").val())==""){
		 alert("생년월일를 입력하세요!");
		 $("#user_birth").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_tel").val())==""){
		 alert("휴대폰 번호를 입력하세요!");
		 $("#user_tel").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_code").val())==""){
		 alert("우편번호를 입력하세요!");
		 $("#user_code").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_addr1").val())==""){
		 alert("기본 주소를 입력하세요!");
		 $("#user_addr1").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_addr2").val())==""){
		 alert("상세 주소를 입력하세요!");
		 $("#user_addr2").val("").focus();
		 return false;
	 }

	 if($.trim($("#user_email").val())==""){
		 alert("이메일 입력하세요!");
		 $("#user_email").val("").focus();
		 return false;
	 }
	 if(id_check()==false){
		 return false;
	 }
	 if(nick_check()==false){
		 return false;
	 }
		var formdata = {
			user_id: $('#user_id').val(),
			user_pw: $('#user_pw').val(),
			user_nm: $('#user_nm').val(),
			user_nick: $('#user_nick').val(),
			user_gender: $('input[name="gender"]:checked').val(),
			user_birth: $('#user_birth').val(),
			user_tel: $('#user_tel').val(),
			user_code: $('#user_code').val(),
			user_addr1: $('#user_addr1').val(),
			user_addr2: $('#user_addr2').val(),
			user_email: $('#user_email').val(),
			user_kind: $('#user_kind').val()
			};
      $.ajax({
         type : "POST",
         url : encodeURI("http://localhost:80/insert_user"),
         contentType: "application/json",
         data : JSON.stringify(formdata),
         success : function(result){
            if(result==1){
               //성공
               alert("회원가입 완료");
               location.href="login";
			}else if(result==0){
				//정보 불러오기 실패
				alert("로그인 실패");
				history.back();
			}else if(result==2){
				//비번 다름
				alert("비밀번호가 다릅니다");
				history.back();
			}
            
         },
         error: function(xhr, status, error) {
           console.error("AJAX 요청 실패:", status, error); 
           alert("서버에서 데이터를 가져오는 중 오류가 발생했습니다.");
          }
         
      });
   });
});
//가입완료 내용(사업자)
$(function(){
   $("#biz_join_ok").click(function(){
	  if($.trim($("#user_biz").val())==""){
		 alert("사업자 등록 입력하세요!");
		 $("#user_biz").val("").focus();
		 return false;
	 }

	 if($.trim($("#user_nm").val())==""){
		 alert("이름을 입력하세요!");
		 $("#user_nm").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_nick").val())==""){
		 alert("닉네임을 입력하세요!");
		 $("#user_nick").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_id").val())==""){
		 alert("아이디를 입력하세요!");
		 $("#user_id").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_pw").val())==""){
		 alert("비밀번호를 입력하세요!");
		 $("#user_pw").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_pw2").val())==""){
		 alert("비밀번호 확인을 입력하세요!");
		 $("#user_pw2").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_pw").val()) != $.trim($("#user_pw2").val())){
		 var newtext='<font color="red">비밀번호가 다릅니다</font>';
      	 $("#pwdcheck").text('');
      	 $("#pwdcheck").show();
      	 $("#pwdcheck").append(newtext);
		 $("#user_pw2").val("");
		 $("#user_pw").focus();
		 return false;
	 }

	 if($.trim($("#user_birth").val())==""){
		 alert("생년월일를 입력하세요!");
		 $("#user_birth").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_tel").val())==""){
		 alert("휴대폰 번호를 입력하세요!");
		 $("#user_tel").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_code").val())==""){
		 alert("우편번호를 입력하세요!");
		 $("#user_code").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_addr1").val())==""){
		 alert("기본 주소를 입력하세요!");
		 $("#user_addr1").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_addr2").val())==""){
		 alert("상세 주소를 입력하세요!");
		 $("#user_addr2").val("").focus();
		 return false;
	 }

	 if($.trim($("#user_email").val())==""){
		 alert("이메일 입력하세요!");
		 $("#user_email").val("").focus();
		 return false;
	 }
		 if(checkCorporateRegiNumber()==false){
		 alert("사업자 번호가 틀렸습니다");
		 return false;
	 }
	 if(id_check()==false){
		 alert("id가 중복입니다");
		 return false;
	 }
	 if(nick_check()==false){
		 alert("닉네임이 중복입니다");
		 return false;
	 }
	 if(businessNumber()==false){
		 alert("사업자 번호가 틀렸습니다");
		 return false;
	 }
	 
		var formdata = {
			user_biz: $('#user_biz').val(),
			user_id: $('#user_id').val(),
			user_pw: $('#user_pw').val(),
			user_nm: $('#user_nm').val(),
			user_nick: $('#user_nick').val(),
			user_gender: $('input[name="gender"]:checked').val(),
			user_birth: $('#user_birth').val(),
			user_tel: $('#user_tel').val(),
			user_code: $('#user_code').val(),
			user_addr1: $('#user_addr1').val(),
			user_addr2: $('#user_addr2').val(),
			user_email: $('#user_email').val(),
			user_kind: $('#user_kind').val(),
			};
      $.ajax({
         type : "POST",
         url : "http://localhost:80/insert_biz",
         contentType: "application/json",
         data : JSON.stringify(formdata),
         success : function(result){
            if(result==1){
               //성공
               alert("회원가입 완료");
               location.href="login";
			}else if(result==0){
				//정보 불러오기 실패
				alert("로그인 실패");
				history.back();
			}else if(result==2){
				//비번 다름
				alert("비밀번호가 다릅니다");
				history.back();
			}
            
         },
         error: function(xhr, status, error) {
           console.error("AJAX 요청 실패:", status, error); 
           alert("서버에서 데이터를 가져오는 중 오류가 발생했습니다.");
          }
         
      });
   });
});


// 사업자 회원 유효성 검사
function checkCorporateRegiNumber(){

	 if($.trim($("#user_biz").val())==""){
		 alert("사업자등록번호를 입력하세요.");
		 $("#user_biz").val("").focus();
		 return false;
	 }

// 사업자등록 번호인지 유효성 검사
/* 123 : 국세청 / 세무서별 코드
   45  : 개인 법인 구분코드
   6789: 과세/면세/법인 사업자 등록/지정일자 일련번호
   0   : 검증번호 
   */
	let num = document.getElementById('user_biz').value;
	console.log(num);
	var numberMap = num.replace(/-/gi, '').split('').map(function (d){
		return parseInt(d, 10);
	});
	
	if(numberMap.length == 10){
		var keyArr = [1, 3, 7, 1, 3, 7, 1, 3, 5];
		var chk = 0;
		
		keyArr.forEach(function(d, i){
			chk += d * numberMap[i];
		});
		
		chk += parseInt((keyArr[8] * numberMap[8])/ 10, 10);
		console.log(chk);
		return Math.floor(numberMap[9]) === ( (10 - (chk % 10) ) % 10);
	}
	return false;
}
function businessNumber(){	// 사업자번호 인증 API 이용
	let num = document.getElementById('user_biz').value;	// 사업자번호
	console.log(num);
    var data = {
        "b_no": [num] // 폼 넘버 가져오기 - 기본 형식
    };
    console.log(data);
    $.ajax({
        url: "https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=h4USNpqN74y3KXWY%2BvxDY94A%2FZOYk8BJOWRzjI9qGCx48eBq%2FGVEhmtR0ExWypep9EPfAHeiHdhJZrggLC5V2g%3D%3D",  // serviceKey 값을 xxxxxx에 입력
        type: "POST",
        data: JSON.stringify(data), // json 을 string으로 변환하여 전송
        dataType: "JSON",
        traditional: true,
        contentType: "application/json; charset:UTF-8",
        accept: "application/json",
        success: function(result) {
                        console.log(result.data[0]['b_stt_cd']); //사업자 01 번 호출
                    var valid = result.data[0]['b_stt_cd'];
					console.log(valid);
                    if (valid == '01'){
                        msg1();
                    }else {
                        msg2();
                        return false;
                    }

                },
                error: function(result) {
                    console.log(result.responseText); //responseText의 에러메세지 확인
                }
            });

    }

    function msg1(){
        let msg = document.getElementById('bizcheck');
        msg.innerHTML = "<br>사업자 회원가입이 가능합니다.";
    }

    function msg2(){
        let msg = document.getElementById('bizcheck');
        msg.innerHTML = "<br>사업자 회원가입을 할 수 없습니다.";

    }


