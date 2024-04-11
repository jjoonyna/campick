$(function(){
	var page=1;
	var doNm = $('input[name="gender"]:checked').val();
	$.ajax({
         type : "GET",
         url : encodeURI("http://localhost:80/camplist/"+page),
         contentType: "application/json",
         data : JSON.stringify(doNm),
         success : function(result){
            if(result!=null){
               //성공
               var content="<br>"+result.user_id;
               var content1="<br>"+result.user_addr1;
               $("#biz_id").html(content);
               $("#biz_addr1").html(content1);
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