//내정보 클릭시 내정보목록 보여주기 
$(function(){
	$("#myInfo").click(function(){
		var submenu = $(this).next("ul");
		if(submenu.is(":visible")){
			submenu.slideUp();
		}else{
			submenu.slideDown();
		}
	});
});
//후기 클릭시 후기목록 보여주기
 $(function(){
	$("#review").click(function(){
		var submenu = $(this).next("ul");
		if(submenu.is(":visible")){
			submenu.slideUp();
		}else{
			submenu.slideDown();
		}
	});
});


//초기화면페이지
$(document).ready(function(){
	$("#mypage").show();	
	$("#join_wrap").hide(); 
	$("#pw_change_display").hide(); 
	$("#delete_display").hide(); 
	
});

	//내정보 수정 클릭시
$(function(){
	$("#myInfo_change").click(function(){		
		$("#mypage").hide();
		$("#join_wrap").show();
		$("#pw_change_display").hide(); 
		$("#delete_display").hide(); 
	
	$.ajax({
         type : "GET",
         url : encodeURI("http://localhost:80/biz_info"),
         contentType: "application/json",
         success : function(result){
            if(result!=null){
               //성공
               $("#user_id").val(result.user_id);
               $("#user_biz").val(result.user_biz);
               $("#user_nm").val(result.user_nm);
               $("#user_nick").val(result.user_nick);
               $("#user_birth").val(result.user_birth);
               $("#user_tel").val(result.user_tel);
               $("#user_code").val(result.user_code);
               $("#user_addr1").val(result.user_addr1);
               $("#user_addr2").val(result.user_addr2);
               $("#user_email").val(result.user_email);
			}else if(result==null){
				//정보 불러오기 실패
				alert("정보 불러오기 실패");
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

	//비번 변경 클릭시
$(function(){
	$("#pw_change").click(function(){		
		$("#mypage").hide();
		$("#join_wrap").hide();
		$("#pw_change_display").show(); 
		$("#delete_display").hide(); 
		
	});
});
	//회원탈퇴 클릭시
$(function(){
	$("#delete").click(function(){		
		$("#mypage").hide();
		$("#join_wrap").hide();
		$("#pw_change_display").hide(); 
		$("#delete_display").show(); 
		
	});
});

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
//정보수정 완료(일반)
$(function(){
   $("#user_change_ok").click(function(){
	
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
	 if($.trim($("#info_pw").val())==""){
		 alert("비밀번호를 입력하세요!");
		 $("#info_pw").val("").focus();
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
      var user = $('#user_change_ok').serialize();
      $.ajax({
         type : "POST",
         url : "http://localhost:80/user_change_ok",
         contentType: "application/json",
         data : JSON.stringify(user),
         success : function(result){
            if(result==1){
               //성공
            }else if(result==-1){
               //정보 불러오기 실패
            }else if(result==2){
               //비번 다름
            }
            
         },
         error: function(xhr, status, error) {
           console.error("AJAX 요청 실패:", status, error); 
           alert("서버에서 데이터를 가져오는 중 오류가 발생했습니다.");
          }
         
      });
   });
});
//비밀번호 변경 완료(일반)
$(function(){
   $("#pw_change_ok").click(function(){
	   
	 if($.trim($("#user_pw").val())==""){
		 alert("현재 비밀번호를 입력하세요!");
		 $("#user_pw").val("").focus();
		 return false;
	 }
	 if($.trim($("#new_user_pw").val())==""){
		 alert("새 비밀번호를 입력하세요!");
		 $("#new_user_pw").val("").focus();
		 return false;
	 }
	 if($.trim($("#new_user_pw2").val())==""){
		 alert("새 비밀번호 확인을 입력하세요!");
		 $("#new_user_pw2").val("").focus();
		 return false;
	 }
	 if($.trim($("#new_user_pw").val()) != $.trim($("#new_user_pw2").val())){
		 alert("비밀번호가 다릅니다!");
		 $("#new_user_pw").val("");
		 $("#new_user_pw2").val("");
		 $("#new_user_pw").focus();
		 return false;
	 }
      var user = $('#pw_change_ok').serialize();
      $.ajax({
         type : "POST",
         url : "http://localhost:80/pw_change_ok",
         contentType: "application/json",
         data : JSON.stringify(user),
         success : function(result){
            if(result==1){
               //성공
            }else if(result==-1){
               //정보 불러오기 실패
            }else if(result==2){
               //비번 다름
            }
            
         },
         error: function(xhr, status, error) {
           console.error("AJAX 요청 실패:", status, error); 
           alert("서버에서 데이터를 가져오는 중 오류가 발생했습니다.");
          }
         
      });
   });
});
//회원탈퇴 완료(일반)
$(function(){
   $("#delete_ok").click(function(){
	   
	 if($.trim($("#delete_pw").val())==""){
		 alert("비밀번호를 입력하세요!");
		 $("#delete_pw").val("").focus();
		 return false;
	 }
	
      var user = $('#delete_ok').serialize();
      $.ajax({
         type : "POST",
         url : "http://localhost:80/delete_ok",
         contentType: "application/json",
         data : JSON.stringify(user),
         success : function(result){
            if(result==1){
               //성공
            }else if(result==-1){
               //정보 불러오기 실패
            }else if(result==2){
               //비번 다름
            }
            
         },
         error: function(xhr, status, error) {
           console.error("AJAX 요청 실패:", status, error); 
           alert("서버에서 데이터를 가져오는 중 오류가 발생했습니다.");
          }
         
      });
   });
});
