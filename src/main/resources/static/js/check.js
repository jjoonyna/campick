

$(document).ready(function campcheck(apt_no){
		var url = window.location.href;
    	var apt_no = url.substring(url.lastIndexOf('/') + 1);
	$.ajax({
		type :"GET",
		url : "http://localhost:80/campcheck/"+apt_no,
		datatype : "json",
		success : function(result){
				console.log(result);
			if(result!=null){
				$("#facltNm").text(result.facltNm); //숙소정보
				$("#addr1").text(result.addr1); //위치
				$("#apt_startdate").text(result.apt_startdate); //숙박날짜
				$("#apt_staydate").text(result.apt_staydate); //숙박날짜
				$("#apt_pp").text(result.apt_pp); //인원
				$("#apt_req").text(result.apt_req); //요청 사항
				$("#apt_price").text(result.apt_price); //결제 내역
				$("#apt_at").text(result.apt_at); //계좌 번호
			
			}else if(result==null){
				aldert("정보 불러오기 실패");
				history.back(); 
			}
		},
		error: function(xhr,status, error){
			console.errer("AJAX.요청 실패: ",status,error);
			alert("서버에서 데이터를 가져오는 중 오류가 발생했습니다.");
		}	
	});
});

$(function(){
	$(".aptbutton").click(function(){		
		location="../user_mypage";
	});
});