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

