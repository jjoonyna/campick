//캠픽 정보 클릭시
$(function(){
	$("#camplist").click(function(){		
	var page=1;
	$.ajax({
         type : "GET",
         url : encodeURI("http://localhost:80/camplist/")+page,
         contentType: "application/json",
         success : function(result){
            if(result!=null){
               //성공
               location="camplist"
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

	//캠픽지도 클릭시
$(function(){
	$("#campmap").click(function(){		
		
		
		$.ajax({
         type : "GET",
         url : encodeURI("http://localhost:80/campmap"),
         contentType: "application/json",
         success : function(result){
            if(result!=null){
               //성공
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
	//캠픽후기 클릭시
$(function(){
	$("#campreview").click(function(){		
		
		
		$.ajax({
         type : "GET",
         url : encodeURI("http://localhost:80/biz_info"),
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
	//캠픽알림 클릭시
$(function(){
	$("#campnotice").click(function(){		
		
		
		$.ajax({
         type : "GET",
         url : encodeURI("http://localhost:80/biz_info"),
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
//초기화면페이지
$(document).ready(function(){
	$("#user").show();	
	$("#biz").hide(); 
});

$(document).ready(function() {
    // 사용자의 로그인 상태를 확인하고 동적으로 드롭다운 메뉴 생성
    $.ajax({
        url: "http://localhost:80/camp_list",
        type: "GET",
        success: function(response) {
            //var dynamicHtml = ''; // 동적 HTML을 담을 변수 초기화

               /* // 사용자가 로그인한 상태인 경우
                dynamicHtml += '<div class="dropdown">';
                dynamicHtml += '    <button class="dropbtn">';
                dynamicHtml += '        <img src="./icons/ico_profile_black.svg" alt="프로필 사진" class="profile-pic">';
                dynamicHtml += '        <span class="dropbtn_icon"></span>';
                dynamicHtml += '    </button>';
                dynamicHtml += '    <div class="dropdown-content">';
                if (response.user_kind == 'u') {
                    // 사용자가 일반 회원인 경우
                    dynamicHtml += '        <a id="myPageBtn" href="./user_mypage.jsp">마이페이지</a>';
	                dynamicHtml += '        <a id="logoutBtn" href="#">로그아웃</a>';
	                dynamicHtml += '    </div>';
	                dynamicHtml += '</div>';
                } else if (response.user_kind == 'b') {
                    // 사용자가 사업자 회원인 경우
                    dynamicHtml += '        <a id="myPageBtn" href="./biz_mypage.jsp">마이페이지</a>';
	                dynamicHtml += '        <a id="logoutBtn" href="#">로그아웃</a>';
	                dynamicHtml += '    </div>';
	                dynamicHtml += '</div>';
                }else {
                // 사용자가 로그인하지 않은 상태인 경우
                dynamicHtml += '<a href="login"> <img src="./icons/ico_profile_black.svg" alt="로그인"></a>';
            	} -*/
/*
                // 동적으로 생성한 HTML을 페이지에 추가
                $('#dynamicContent').html(dynamicHtml);
*/
                // 프로필 이미지 클릭 시 다이얼로그 창 열기
                $(".profile-pic").click(function() {
                    $("#dropdown").dialog("open");
                });

             /*

            // 동적으로 생성한 HTML을 페이지에 추가
            $('#dynamicContent').html(dynamicHtml);
*/

   
        },
        error: function(xhr, status, error) {
            console.error(error);
        }
    });
});
        // 마이페이지 버튼 클릭 시 마이페이지로 이동
        $("#myPageBtn").click(function() {
            window.location.href = ($(this).attr('href'));
        });
        
		// 로그아웃 버튼 클릭 시 로그아웃 처리
		$(".logoutBtn").click(function(event) {
		//$(document).ready(function() {
		    $.ajax({
		        url: "logout_user",
		        type: "POST",
		        success: function(response) {
					if(response==1){
						
					
		            alert("로그아웃 되었습니다.");
		            event.preventDefault(); // 링크의 기본 동작을 막음
		            // 여기에 추가적으로 로그아웃 후 수행할 작업을 작성할 수 있습니다.
		           location.href = "login"
		        }},
		        error: function(xhr, status, error) {
		            alert("로그아웃 요청을 처리하는 중 오류가 발생했습니다.");
		            console.error(error);
		        }
		    });
		});