
$(document).ready(function campappointment(contentId){
		//contentId를 url에 숫자값 그대로 가져오는 용도
	 	var url = window.location.href;
    	var contentId = url.substring(url.lastIndexOf('/') + 1);
	$.ajax({
         type : "GET",
         url : "http://localhost:80/campappointment/"+contentId,
         dataType: "json",
         success : function(result){
			 console.log(result);
            if(result!=null){
			 	//값을 jsp에 넣기 위해 text사용함
               $("#contentId").text(result.contentId);//제목
               $("#user_id").text(result.user_id);//제목
               $("#facltNm").text(result.facltNm);//제목
               $("#intro").text(result.intro);//짧은설명(설명)
               $("#featureNm").text(result.featureNm);//자세한 설명(설명)
               $("#firstImageUrl").attr("src",result.firstImageUrl);//대표이미지
               $("#cmp_maxpp").text(result.cmp_maxpp);//최대 예약 인원
               $("#cmp_price").text(result.cmp_price);//최대 이용 금액
               $("#stay").text(result.stay);//최대 이용 금액
               
              
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
	
function calculatePrice() {
	var stayElement = document.getElementById(stay);
	var priceElement = document.getElementById(price);

	// 선택된 구역에 따라 가격을 가져오기
	var areaPrice = 100000;
	
	  // 선택한 은행 이름 가져오기
 	var selectedStay = document.getElementById("stay").value;

	if (selectedStay === "default") {
    document.getElementById("price").textContent = "";
    return;
  }
  
	// 선택된 숙박 일자에 따라 가격 연산
	var stayPrice = areaPrice
		* parseInt(stayElement.value);

	// 결과를 <div> 태그에 표시
	priceElement.textContent = stayPrice
		.toLocaleString()
		+ "원";
}

// 캠핑장 정보를 저장할 변수
var campgrounds = [
  { name: "캠핑장 A", maxCapacity: 10, price: 50000 },
  { name: "캠핑장 B", maxCapacity: 15, price: 70000 },
  { name: "캠핑장 C", maxCapacity: 20, price: 100000 }
];

// 캠핑장 선택 옵션 생성
//var campgroundSelect = document.getElementById("campground");
//campgrounds.forEach(function(campground) {
//  var option = document.createElement("option");
//  option.value = campground.maxCapacity; // 선택된 캠핑장의 최대 수용 인원 수를 저장
//  option.text = `${campground.name} (${campground.maxCapacity}명까지) - ${campground.price}원`;
//  campgroundSelect.add(option);
//});

// 캠핑장 선택 변경 시 해당 캠핑장의 최대 수용 인원 수에 맞게 예약할 인원 수 옵션을 변경
//campgroundSelect.addEventListener("change", function() {
//  var selectedMaxCapacity = parseInt(campgroundSelect.value);
//  var numberOfPeopleSelect = document.getElementById("numberOfPeople");
//  numberOfPeopleSelect.innerHTML = ''; // 기존 옵션 제거
//
//  // 최대 수용 인원 수에 맞게 옵션 추가
//  for (var i = 1; i <= selectedMaxCapacity; i++) {
//    var option = document.createElement("option");
//    option.value = i;
//    option.text = i;
//    numberOfPeopleSelect.add(option); //여기가 문제
//  }
//});

// 폼 제출 이벤트 핸들러
//document.getElementById("reservationForm").addEventListener("submit", function(event) {
//  event.preventDefault(); // 폼 제출 이벤트 기본 동작 방지

  // 폼 입력값 가져오기
//  var numberOfPeople = parseInt(document.getElementById("numberOfPeople").value);
//  var selectedCampgroundIndex = document.getElementById("campground").selectedIndex;
//  var selectedCampgroundPrice = campgrounds[selectedCampgroundIndex].price;
//
//  // 총 예약 금액 계산
//  var totalPrice = numberOfPeople * selectedCampgroundPrice;
//
//  // 예약 정보 출력
//  console.log("예약한 캠핑장:", campgrounds[selectedCampgroundIndex].name);
//  console.log("예약한 인원 수:", numberOfPeople);
//  console.log("총 예약 금액:", totalPrice);
//
//  // 예약 후 폼 초기화
//  document.getElementById("reservationForm").reset();
//});



// 결제 방식 : 은행 선택
function payment() {
  // 선택할 은행 선언
  var bankName = ["신한", "국민", "카카오"];
  
  // 각 은행에 해당하는 계좌 정보
  var bankinfo = {
    "신한": "(주)캠픽 111-111-111111",
    "국민": "(주)캠픽 222-222-222222",
    "카카오": "(주)캠픽 333-333-333333"
  };
  
  // 선택한 은행 이름 가져오기
  var user_price = document.getElementById("user_price").value;
  
  if (user_price == "default") {
    document.getElementById("paymentResult").textContent = "";
    return;
  }
  
  // 선택한 은행의 계좌 정보 가져오기
  var selectedBankInfo = bankinfo[user_price];
  
  // 결과를 <div> 태그에 표시
  var paymentResult = document.getElementById("paymentResult");
  paymentResult.textContent = `은행 : ${user_price}, 계좌번호 : ${selectedBankInfo}`;
}




// 선택한 날짜 정보 가져오기
function displaySelectedDate() {
	var selectedDate = document
		.getElementById("datepicker").value;
	document
		.getElementById("startdate").textContent = selectedDate;
}




// 캠핑장 예약하기 클릭시
//$(function(){
//	$("#camp_appointment").click(function(){		
//		$("#user").show();
//	
//		$.ajax({
//         type : "GET",
//         url : encodeURI("http://localhost:80/camp_results"+user_id),
//         contentType: "application/json",
//         success : function(result){
//            if(result!=null){
//               //성공
//               $("#facltNm").val(result.facltNm);
//               $("#addr1").val(result.addr1);
//               $("#apt_startdate").val(result.apt_startdate);
//               $("#apt_staydate").val(result.apt_staydate);
//               $("#apt_pp").val(result.apt_pp);
//               $("#apt_req").val(result.apt_req);
//               $("#apt_price").val(result.apt_price);
//			}else if(result==null){
//				//정보 불러오기 실패
//				alert("정보 불러오기 실패");
//				history.back();
//			}
//            
//         },
//         error: function(xhr, status, error) {
//           console.error("AJAX 요청 실패:", status, error); 
//           alert("서버에서 데이터를 가져오는 중 오류가 발생했습니다.");
//          }
//         
//      });
//	});
//});



// 캠핑장 예약하기 요청
$(function (){
	$("#camp_appointment_ok").click(function campappointment(contentId){
	if($.trim($("#user_nm").val())==""){
		 alert("예약자 성함을 입력해주세요.");
		 $("#user_nm").val("").focus();
		 return false;
	 }
	 if($.trim($("#apt_pp").val())==""){
		 alert("인원을 선택해주세요.");
		 $("#apt_pp").val("").focus();
		 return false;
	 }
	 if($.trim($("#apt_req").val())==""){
		 alert("요청사항을 입력해주세요.");
		 $("#apt_req").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_price").val())==""){
		 alert("결제 방식을 선택해주세요.");
		 $("#user_price").val("").focus();
		 return false;
	 }
		var formdata = {
			contentId: $('#contentId').val(),
			user_id: $('#user_id').val(),
			apt_startdate: $('#apt_startdate').val(),
			apt_staydate: $('#apt_staydate').val(),
			user_nm: $('#user_nm').val(),
			apt_pp: $('#apt_pp').val(),
			apt_req: $('#apt_req').val(),
			price: $('#cmp_price').val()
			
			};
		var url = window.location.href;
    	var contentId = url.substring(url.lastIndexOf('/') + 1);
		$.ajax({
			type : "POST",
			url : "http://localhost:80/apt_user_cmp/"+contentId,
			contentType: "application/json",
			data : JSON.stringify(formdata),
			success : function(result){
				console.log(result);
				if(result != null){
					alert("예약이 완료되었습니다.");
					location.href="../camp_result/"+result;
				}
//				if(result==1){
//					//성공
//					alert("예약이 완료되었습니다.");
//					location.href="../camp_result/"+result.apt_no;
//				}else if(result==-1){
//					//정보 불러오기 실패
//					alert("예약이 실패되었습니다.");
//					history.back();
//				}else if(result==2){
//					//예약이 실패할 경우?
//					alert("예약이 실패되었습니다.");
//					history.back();
//				}
				
			},
			error: function(xhr, status, error) {
        	console.error("AJAX 요청 실패:", status, error); 
        	alert("서버에서 데이터를 가져오는 중 오류가 발생했습니다.");
    		}
			
		});


	});
	
});





  // 캠핑장 최대 인원수를 가져오는 함수 예시
  // 여기에 서버로부터 인원수를 가져오는 AJAX 요청 등을 수행할 수 있습니다.
  // 가져온 데이터를 사용하여 아래와 같이 옵션을 동적으로 생성합니다.
  var campgrounds = ["캠핑장 A", "캠핑장 B", "캠핑장 C"]; // 임시 데이터
  var select = document.getElementById("${cmp_pp}");
  campgrounds.forEach(function(campground) {
    var option = document.createElement("option");
    option.value = campground;
    option.textContent = campground;
    select.appendChild(option);
  });
