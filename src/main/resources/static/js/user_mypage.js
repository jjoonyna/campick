

//취소버튼 클릭시
$(function(){
	$('.cancle').click(function(){
		location="user_mypage";
	});
});


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
//클릭시 후기목록 보여주기
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
	$(".boxbox").hide();
	
	$.ajax({
         type : "GET",
         url : encodeURI("http://localhost:80/user_info"),
         success : function(result){
            if(result!=null){
               //성공
               var content="<br>"+result.user_id;
               var content1="<br>"+result.user_addr1;
               $("#user_id").html(content);
               $("#user_addr1").html(content1);
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
  //내정보 수정 클릭시
$(function(){
   $("#myInfo_change").click(function(){      
      $("#join_wrap").show();
      $("#mypage").hide();
      $("#pw_change_display").hide(); 
      $("#delete_display").hide(); 
      $(".boxbox").hide();
      $.ajax({
         type : "GET",
         url : encodeURI("http://localhost:80/user_info"),
         contentType: "application/json",
         success : function(result){
            if(result!=null){
               //성공
               $("#info_id").val(result.user_id);
               $("#info_nm").val(result.user_nm);
               $("#info_nick").val(result.user_nick);
               $("#info_birth").val(result.user_birth);
               $("#info_tel").val(result.user_tel);
               $("#info_code").val(result.user_code);
               $("#info_addr1").val(result.user_addr1);
               $("#info_addr2").val(result.user_addr2);
               $("#info_email").val(result.user_email);
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

//예약목록 확인

$(function(){
	$("#appoint").click(function(){		
		$(".boxbox").show();
		$("#mypage").hide();
		$("#join_wrap").hide();
		$("#pw_change_display").hide(); 
		$("#delete_display").hide(); 
		
		$.ajax({
         type : "GET",
         url : encodeURI("http://localhost:80/user_aptlist"),
         contentType: "application/json",
         success : function(result){
            if(result!=null){
               //성공
			var content ="";
			
			 $.each(result.apt, function (index, item) {
				 
				content += "<div class='card_body'>";
				content += "<h2 class='boldtit'>"+item.user_id+"님의 예약이 완료되었습니다!</h2><br><br>";
				content += "<table class='formline'>";
				content += "<tr class='onlybottomline'>";
				content += "<td class='tabletdtext'>숙소 정보 : </td>";
				content += "<td class='tabletdtext'><div class='readdatas' id='cmp_nm' name='cmp_nm' >"+item.facltNm+"</div></td>";
				content += "</tr>";
				content += "<tr class='onlybottomline'>";
				content += "<td class='tabletdtext'>위치 : </td>";
				content += "<td class='tabletdtext'><div class='readdatas' id='cmp_addr' name='cmp_addr'>"+item.addr1+"</div></td>";
				content += "</tr>";
				content += "<tr class='onlybottomline'>";
				content += "<td class='tabletdtext'>날짜 : </td>";
				content += "<td class='tabletdtext'><div id='cmp_startdate' name='cmp_startdate'   class='readdatas'>"+item.apt_date+"</div></td>";
				content += "<td class='tabletdtext'><div  class='readdatas' id='cmp_stay' name='cmp_stay'/>"+item.apt_staydate+"일</div></td>";
				content += "</tr>";
				content += "<tr class='onlybottomline'>";
				content += "<td class='tabletdtext'>인원 : </td>";
				content += "<td class='tabletdtext'><div  class='readdatas' id='participants' name='apt_pp' required/>"+item.apt_pp+"</div></td>";
				content += "</tr>";
				content += "<tr class='onlybottomline'>";
				content += "<td class='tabletdtext'>요청 사항 : </td>";
				content += "<td class='tabletdtext'><div  class='readdatas' id='content' name='apt_req' required/>"+item.apt_req+"</div</td>";
				content += "</tr>";
				content += "<tr class='onlybottomline'>";
				content += "<td class='tabletdtext'>결제 내역 : </td>";
				content += "<td class='tabletdtext'><div class='readdatas' onchange='payment()' id='apt_price' name='apt_price' required/>"+item.apt_price+"</div></td>";
				content += "</tr>";
				content += "</table>";
				content += "</div>";
				content += "<br><br>";
				$(".boxboxbox").html(content);
				 });
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
		$("#pw_change_display").show(); 
		$("#mypage").hide();
		$("#join_wrap").hide();
		$("#delete_display").hide(); 
		$.ajax({
         type : "GET",
         url : encodeURI("http://localhost:80/user_info"),
         contentType: "application/json",
         success : function(result){
            if(result!=null){
               //성공
               $("#change_id").val(result.user_id);
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
	//회원탈퇴 클릭시
$(function(){
	$("#delete").click(function(){		
		$("#mypage").hide();
		$("#join_wrap").hide();
		$("#pw_change_display").hide(); 
		$("#delete_display").show(); 
				$.ajax({
         type : "GET",
         url : encodeURI("http://localhost:80/user_info"),
         contentType: "application/json",
         success : function(result){
            if(result!=null){
               //성공
               $("#delete_id").val(result.user_id);
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
	var memid=$("#info_nick").val();
	//1.입력글자 길이 체크
	if($.trim($("#info_nick").val()).length < 2){
		var newtext='<font color="red">닉네임은 2자 이상이어야 합니다.</font>';
		$("#nickcheck").text('');
		$("#nickcheck").show();
		$("#nickcheck").append(newtext);//span 아이디 영역에 경고문자 추가
		$("#user_nick").val("").focus();
		return false;
	};
	if($.trim($("#info_nick").val()).length >12){
		var newtext='<font color="red">닉네임은 12자 이하이어야 합니다.</font>';
		$("#nickcheck").text('');
		$("#nickcheck").show();
		$("#nickcheck").append(newtext);
		$("#user_nick").val("").focus();
		return false;
	};
	
	var user_nick = $("#info_nick").val();
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
          		$("#info_nick").val('').focus();
          		return false;
	     
      	  }else{				
      		var newtext='<font color="blue">사용가능한 닉네임입니다.</font>';
      		$("#nickcheck").text('');
      		$("#nickcheck").show();
      		$("#nickcheck").append(newtext);
      		$("#info_nick").focus();
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
	   
	 if($.trim($("#info_nm").val())==""){
		 alert("이름을 입력하세요!");
		 $("#info_nm").val("").focus();
		 return false;
	 }
	 if($.trim($("#info_nick").val())==""){
		 alert("닉네임을 입력하세요!");
		 $("#info_nick").val("").focus();
		 return false;
	 }
	 if($.trim($("#info_pw").val())==""){
		 alert("비밀번호를 입력하세요!");
		 $("#info_pw").val("").focus();
		 return false;
	 }
	 if($.trim($("#info_birth").val())==""){
		 alert("생년월일를 입력하세요!");
		 $("#info_birth").val("").focus();
		 return false;
	 }
	 if($.trim($("#info_tel").val())==""){
		 alert("휴대폰 번호를 입력하세요!");
		 $("#info_tel").val("").focus();
		 return false;
	 }
	 if($.trim($("#info_code").val())==""){
		 alert("우편번호를 입력하세요!");
		 $("#info_code").val("").focus();
		 return false;
	 }
	 if($.trim($("#info_addr1").val())==""){
		 alert("기본 주소를 입력하세요!");
		 $("#info_addr1").val("").focus();
		 return false;
	 }
	 if($.trim($("#info_addr2").val())==""){
		 alert("상세 주소를 입력하세요!");
		 $("#info_addr2").val("").focus();
		 return false;
	 }

	 if($.trim($("#info_email").val())==""){
		 alert("이메일 입력하세요!");
		 $("#info_email").val("").focus();
		 return false;
	 }
          var formdata = {
			user_id: $('#info_id').val(),
			user_pw: $('#info_pw').val(),
			user_nm: $('#info_nm').val(),
			user_nick: $('#info_nick').val(),
			user_birth: $('#info_birth').val(),
			user_tel: $('#info_tel').val(),
			user_code: $('#info_code').val(),
			user_addr1: $('#info_addr1').val(),
			user_addr2: $('#info_addr2').val(),
			user_email: $('#info_email').val(),
			};
      $.ajax({
         type : "POST",
         url : "http://localhost:80/update_user",
         contentType: "application/json",
         data : JSON.stringify(formdata),
         success : function(result){
            if(result==1){
               //성공
               alert("정보수정 완료");
               location="user_mypage";
            }else if(result==0){
               //정보 불러오기 실패
               alert("정보수정 실패");
            }else if(result==-1){
               //비번 다름
               alert("비밀번호가 틀렸습니다");
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
	   
	 if($.trim($("#change_pw").val())==""){
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
       var formdata = {
			user_id: $('#change_id').val(),
			user_pw: $('#change_pw').val(),
			};
			var new_pw = $('#new_user_pw').val();
      $.ajax({
         type : "POST",
         url : "http://localhost:80/updatemyuser_pwd/"+new_pw,
         contentType: "application/json",
         data : JSON.stringify(formdata),
         success : function(result){
            if(result==1){
               //성공
               alert("정보수정 완료");
               location="login";
            }else if(result==0){
               //정보 불러오기 실패
               alert("정보수정 실패");
            }else if(result==-1){
               //비번 다름
               alert("비밀번호가 틀렸습니다");
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
	
       var formdata = {
			user_id: $('#delete_id').val(),
			user_pw: $('#delete_pw').val(),
			};
      $.ajax({
         type : "POST",
         url : "http://localhost:80/delete_user",
         contentType: "application/json",
         data : JSON.stringify(formdata),
         success : function(result){
            if(result==1){
               //성공
               alert("회원탈퇴 완료");
               location="login";
            }else if(result==0){
               //정보 불러오기 실패
               alert("회원탈퇴 실패");
            }else if(result==-1){
               //비번 다름
               alert("비밀번호가 틀렸습니다");
            }
            
         },
         error: function(xhr, status, error) {
           console.error("AJAX 요청 실패:", status, error); 
           alert("서버에서 데이터를 가져오는 중 오류가 발생했습니다.");
          }
         
      });
   });
});
