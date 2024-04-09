
//초기화면페이지
$(document).ready(function(){
	$("#user").show();	
	$("#biz").hide(); 
});

	//사업자 로그인 클릭시
$(function(){
	$("#biz_login").click(function(){		
		$("#user").hide();
		$("#biz").show();
		$("#biz_login").css("color","#F57804")
		$("#user_login").css("color","black")
	});
});

	//일반 로그인 클릭시
$(function(){
	$("#user_login").click(function(){		
		$("#user").show();
		$("#biz").hide();
		$("#user_login").css("color","#F57804")
		$("#biz_login").css("color","black")
	});
});

//일반회원 로그인 요청
$(function(){
	$("#user_login_ok").click(function(){
	if($.trim($("#id").val())==""){
		 alert("로그인 아이디를 입력하세요!");
		 $("#id").val("").focus();
		 return false;
	 }
	 if($.trim($("#pwd").val())==""){
		 alert("비밀번호를 입력하세요!");
		 $("#pwd").val("").focus();
		 return false;
	 }
		var formdata = {
			user_id: $('#id').val(),
			user_pw: $('#pwd').val()
			};
		$.ajax({
			type : "POST",
			url : "http://localhost:80/login_user",
			contentType: "application/json",
			data : JSON.stringify(formdata),
			success : function(result){
				if(result==1){
					//성공
					alert("로그인 완료");
					location.href="./user_mypage";
				}else if(result==-1){
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
//사업자 로그인 요청
$(function(){
	$("#biz_login_ok").click(function(){
	if($.trim($("#biz_id").val())==""){
		 alert("로그인 아이디를 입력하세요!");
		 $("#biz_id").val("").focus();
		 return false;
	 }
	 if($.trim($("#biz_pwd").val())==""){
		 alert("비밀번호를 입력하세요!");
		 $("#biz_pwd").val("").focus();
		 return false;
	 }
		var formdata = {
			user_id: $('#biz_id').val(),
			user_pw: $('#biz_pwd').val()
			};
		$.ajax({
			type : "POST",
			url : "http://localhost:80/login_biz",
			contentType: "application/json",
			data : JSON.stringify(formdata),
			success : function(result){
				if(result==1){
					//성공
					alert("로그인 완료");
					location.href="./biz_mypage";
				}else if(result==-1){
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
//카카오 로그인 요청
$(function(){
	$("#kakao_login_ok").click(function(){
		var formdata = $('#kakao_login_ok').serialize();
		$.ajax({
			type : "POST",
			url : "http://localhost:80/kakao_login_ok",
			contentType: "application/json",
			data : JSON.stringify(formdata),
			success : function(result){
				
			},
			error: function(xhr, status, error) {
        	console.error("AJAX 요청 실패:", status, error); 
        	alert("서버에서 데이터를 가져오는 중 오류가 발생했습니다.");
    		}
			
		});
	});
	
});
//구글 로그인 요청
$(function(){
	$("#google_login_ok").click(function(){
		var formdata = $('#google_login_ok').serialize();
		$.ajax({
			type : "POST",
			url : "http://localhost:80/google_login_ok",
			contentType: "application/json",
			data : JSON.stringify(formdata),
			success : function(result){
				
			},
			error: function(xhr, status, error) {
        	console.error("AJAX 요청 실패:", status, error); 
        	alert("서버에서 데이터를 가져오는 중 오류가 발생했습니다.");
    		}
			
		});
	});
	
});
//네이버 로그인 요청
$(function(){
	$("#naver_login_ok").click(function(){
		var formdata = $('#naver_login_ok').serialize();
		$.ajax({
			type : "POST",
			url : "http://localhost:80/naver_login_ok",
			contentType: "application/json",
			data : JSON.stringify(formdata),
			success : function(result){
				
			},
			error: function(xhr, status, error) {
        	console.error("AJAX 요청 실패:", status, error); 
        	alert("서버에서 데이터를 가져오는 중 오류가 발생했습니다.");
    		}
			
		});
	});
	
});

$(function(){
	$("#user_id_find").click(function(){
		window.open("user_id_find","ID찾기","width=600px,height=500px,top=150,left=500");
	});
});

$(function(){
	$("#user_pw_find").click(function(){
		window.open("user_pw_find","PW찾기","width=600px,height=500px,top=150,left=500");
	});
});

$(function(){
	$("#biz_id_find").click(function(){
		window.open("biz_id_find","ID찾기","width=600px,height=500px,top=150,left=500");
	});
});

$(function(){
	$("#biz_pw_find").click(function(){
		window.open("biz_pw_find","PW찾기","width=600px,height=500px,top=150,left=500");
	});
});