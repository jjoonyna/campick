$(document).ready(function(){
	$("#pw_find").show();	
	$("#pw_change").hide(); 
});
 //사업자 id찾기 확인
 $(function(){
	$("#biz_id_find").click(function(){
		
		if($.trim($("#user_nm").val())==""){
		 alert("사업자명을 입력하세요!");
		 $("#user_nm").val("").focus();
		 return false;
	 	}
	 	if($.trim($("#user_biz").val())==""){
		 alert("사업자번호를 입력하세요!");
		 $("#user_biz").val("").focus();
		 return false;
	 	}
	 	
	 	
		var formdata = {
			user_nm: $('#user_nm').val(),
			user_biz: $('#user_biz').val()
			};
		$.ajax({
			type : "POST",
			url : "http://localhost:80/findbiz_id",
			contentType: "application/json",
			data : JSON.stringify(formdata),
			success : function(result){
				if(result!=null){
					//성공
					$("#findid").html("당신의 아이디는"+result.user_id+"입니다");
				}else if(result==null){
					//정보 불러오기 실패
					alert("아이디 찾기 실패");
					widow.close();
				}
				
			},
			error: function(xhr, status, error) {
        	console.error("AJAX 요청 실패:", status, error); 
        	alert("없는 회원정보입니다");
    		}
			
		});
	});
	
});

//사업자 pw찾기
 $(function(){
	 
	$("#biz_pw_find").click(function(){
		if($.trim($("#user_id").val())==""){
		 alert("id를 입력하세요!");
		 $("#user_id").val("").focus();
		 return false;
	 	}
	 	if($.trim($("#user_biz").val())==""){
		 alert("사업자번호를 입력하세요!");
		 $("#user_biz").val("").focus();
		 return false;
	 	}
	 	
	 	
		var formdata = {
			user_id: $('#user_id').val(),
			user_biz: $('#user_biz').val(),
			};
		$.ajax({
			type : "POST",
			url : "http://localhost:80/findbiz_pwd",
			contentType: "application/json",
			data : JSON.stringify(formdata),
			success : function(result){
				if(result==1){
					//성공
					alert("비번찾기 성공! 비번을 변경해주세요!");
					$("#pw_find").hide();	
					$("#pw_change").show(); 
				}else if(result==0){
					//정보 불러오기 실패
					alert("아이디 찾기 실패");
					widow.close();
				}
				
			},
			error: function(xhr, status, error) {
        	console.error("AJAX 요청 실패:", status, error); 
        	alert("없는 회원정보입니다");
    		}
			
		});
	});
	
});
//사업자 pw변경
 $(function(){
	 
	$("#biz_pw_change").click(function(){
		if($.trim($("#user_id").val())==""){
		 alert("id를 입력하세요!");
		 $("#user_id").val("").focus();
		 return false;
	 	}
	 	if($.trim($("#user_biz").val())==""){
		 alert("사업자번호를 입력하세요!");
		 $("#user_biz").val("").focus();
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
		var formdata = {
			user_id: $('#user_id').val(),
			user_pw: $('#user_pw').val(),
			};
		$.ajax({
			type : "POST",
			url : "http://localhost:80/updatebiz_pwd",
			contentType: "application/json",
			data : JSON.stringify(formdata),
			success : function(result){
				if(result==1){
					//성공
					alert("비밀번호 변경 완료");
					window.close();
				}else if(result==0){
					//정보 불러오기 실패
					alert("비밀번호 변경 실패");
					widows.close();
				}
				
			},
			error: function(xhr, status, error) {
        	console.error("AJAX 요청 실패:", status, error); 
        	alert("서버에서 데이터를 가져오는 중 오류가 발생했습니다.");
    		}
			
		});
	});
	
});
//일반 회원 id찾기
 $(function(){
	 
	$("#user_id_find").click(function(){
		if($.trim($("#user_nm").val())==""){
		 alert("이름을 입력하세요!");
		 $("#user_nm").val("").focus();
		 return false;
	 	}
	 	if($.trim($("#user_tel").val())==""){
		 alert("전화번호를 입력하세요!");
		 $("#user_tel").val("").focus();
		 return false;
	 	}
	 	
	 	
		var formdata = {
			user_nm: $('#user_nm').val(),
			user_tel: $('#user_tel').val(),
			};
		$.ajax({
			type : "POST",
			url : "http://localhost:80/finduser_id",
			contentType: "application/json",
			data : JSON.stringify(formdata),
			success : function(result){
				if(result!=null){
					//성공
					$("#findid").html("당신의 아이디는"+result.user_id+"입니다");
				}else if(result==null){
					//정보 불러오기 실패
					alert("아이디 찾기 실패");
					widow.close();
				}
				
			},
			error: function(xhr, status, error) {
        	console.error("AJAX 요청 실패:", status, error); 
        	alert("없는 회원정보입니다");
    		}
			
		});
	});
	
});
//일반 pw찾기
 $(function(){
	 
	$("#user_pw_find").click(function(){
		if($.trim($("#user_id").val())==""){
		 alert("이름을 입력하세요!");
		 $("#user_id").val("").focus();
		 return false;
	 	}
	 	if($.trim($("#user_tel").val())==""){
		 alert("전화번호를 입력하세요!");
		 $("#user_tel").val("").focus();
		 return false;
	 	}
	 	
	 	
		var formdata = {
			user_id: $('#user_id').val(),
			user_tel: $('#user_tel').val(),
			};
		$.ajax({
			type : "POST",
			url : "http://localhost:80/finduser_pwd",
			contentType: "application/json",
			data : JSON.stringify(formdata),
			success : function(result){
				if(result==1){
					//성공
					alert("비번찾기 성공! 비번을 변경해주세요!");
					$("#pw_find").hide();	
					$("#pw_change").show(); 
				}else if(result==0){
					//정보 불러오기 실패
					alert("아이디 찾기 실패");
					widow.close();
				}
				
			},
			error: function(xhr, status, error) {
        	console.error("AJAX 요청 실패:", status, error); 
        	alert("없는 회원정보입니다");
    		}
			
		});
	});
	
});

//일반회원 비밀번호 변경
 $(function(){
	 
	$("#user_pw_change").click(function(){
		if($.trim($("#user_id").val())==""){
		 alert("이름을 입력하세요!");
		 $("#user_id").val("").focus();
		 return false;
	 	}
	 	if($.trim($("#user_pw").val())==""){
		 alert("비밀번호를 입력하세요!");
		 $("#user_pw").val("").focus();
		 return false;
	 	}if($.trim($("#user_pw").val()) != $.trim($("#user_pw2").val())){
		 var newtext='<font color="red">비밀번호가 다릅니다</font>';
      	 $("#pwdcheck").text('');
      	 $("#pwdcheck").show();
      	 $("#pwdcheck").append(newtext);
		 $("#user_pw2").val("");
		 $("#user_pw").focus();
		 return false;
	 }
	 	
	 	
		var formdata = {
			user_id: $('#user_id').val(),
			user_pw: $('#user_pw').val(),
			};
		$.ajax({
			type : "POST",
			url : "http://localhost:80/updateuser_pwd",
			contentType: "application/json",
			data : JSON.stringify(formdata),
			success : function(result){
				if(result==1){
					//성공
					alert("비밀번호 변경 완료");
					window.close();
				}else if(result==0){
					//정보 불러오기 실패
					alert("비밀번호 변경 실패");
					widows.close();
				}
				
			},
			error: function(xhr, status, error) {
        	console.error("AJAX 요청 실패:", status, error); 
        	alert("서버에서 데이터를 가져오는 중 오류가 발생했습니다.");
    		}
			
		});
	});
	
});