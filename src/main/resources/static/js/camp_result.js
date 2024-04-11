
function calculatePrice() {
	var stayElement = document.getElementById("stay");
	var priceElement = document.getElementById("price");

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
var campgroundSelect = document.getElementById("campground");
campgrounds.forEach(function(campground) {
  var option = document.createElement("option");
  option.value = campground.maxCapacity; // 선택된 캠핑장의 최대 수용 인원 수를 저장
  option.text = `${campground.name} (${campground.maxCapacity}명까지) - ${campground.price}원`;
  campgroundSelect.add(option);
});

// 캠핑장 선택 변경 시 해당 캠핑장의 최대 수용 인원 수에 맞게 예약할 인원 수 옵션을 변경
campgroundSelect.addEventListener("change", function() {
  var selectedMaxCapacity = parseInt(campgroundSelect.value);
  var numberOfPeopleSelect = document.getElementById("numberOfPeople");
  numberOfPeopleSelect.innerHTML = ''; // 기존 옵션 제거

  // 최대 수용 인원 수에 맞게 옵션 추가
  for (var i = 1; i <= selectedMaxCapacity; i++) {
    var option = document.createElement("option");
    option.value = i;
    option.text = i;
    numberOfPeopleSelect.add(option);
  }
});

// 폼 제출 이벤트 핸들러
document.getElementById("reservationForm").addEventListener("submit", function(event) {
  event.preventDefault(); // 폼 제출 이벤트 기본 동작 방지

  // 폼 입력값 가져오기
  var numberOfPeople = parseInt(document.getElementById("numberOfPeople").value);
  var selectedCampgroundIndex = document.getElementById("campground").selectedIndex;
  var selectedCampgroundPrice = campgrounds[selectedCampgroundIndex].price;

  // 총 예약 금액 계산
  var totalPrice = numberOfPeople * selectedCampgroundPrice;

  // 예약 정보 출력
  console.log("예약한 캠핑장:", campgrounds[selectedCampgroundIndex].name);
  console.log("예약한 인원 수:", numberOfPeople);
  console.log("총 예약 금액:", totalPrice);

  // 예약 후 폼 초기화
  document.getElementById("reservationForm").reset();
});



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
  var selectedBank = document.getElementById("bankSelect").value;
  
  if (selectedBank === "default") {
    document.getElementById("paymentResult").textContent = "";
    return;
  }
  
  // 선택한 은행의 계좌 정보 가져오기
  var selectedBankInfo = bankinfo[selectedBank];
  
  // 결과를 <div> 태그에 표시
  var paymentResult = document.getElementById("paymentResult");
  paymentResult.textContent = `은행 : ${selectedBank}, 계좌번호 : ${selectedBankInfo}`;
}




// 선택한 날짜 정보 가져오기
function displaySelectedDate() {
	var selectedDate = document
		.getElementById("datepicker").value;
	document
		.getElementById("startdate").textContent = selectedDate;
}




// 캠핑장 예약하기 클릭시
$(function(){
	$("#camp_appointment").click(function(){		
		$("#user").show();
	
		$.ajax({
         type : "GET",
         url : encodeURI("http://localhost:80/camp_info"),
         contentType: "application/json",
         success : function(result){
            if(result!=null){
               //성공
               $("#facltNm").val(result.facltNm);
               $("#cmp_price").val(result.cmp_price);
               $("#cmp_startdate").val(result.cmp_startdate);
               $("#cmp_maxpp").val(result.cmp_maxpp);
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



// 캠핑장 예약하기 요청
$(function(){
	$("#camp_appointment_ok").click(function(){
	if($.trim($("#user_nm").val())==""){
		 alert("예약자 성함을 입력해주세요.");
		 $("#user_nm").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_pp").val())==""){
		 alert("인원을 선택해주세요.");
		 $("#user_pp").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_request").val())==""){
		 alert("요청사항을 입력해주세요.");
		 $("#user_request").val("").focus();
		 return false;
	 }
	 if($.trim($("#user_price").val())==""){
		 alert("결제 방식을 선택해주세요.");
		 $("#user_price").val("").focus();
		 return false;
	 }
		var formdata = {
			user_nm: $('#user_nm').val(),
			user_pp: $('#user_pp').val(),
			user_request: $('#user_request').val(),
			user_price: $('#user_price').val()
			
			};
		$.ajax({
			type : "POST",
			url : "http://localhost:80/camp_appointment",
			contentType: "application/json",
			data : JSON.stringify(formdata),
			success : function(result){
				if(result==1){
					//성공
					alert("예약이 완료되었습니다.");
					location.href="./camp_result.jsp";
				}else if(result==-1){
					//정보 불러오기 실패
					alert("예약이 실패되었습니다.");
					history.back();
				}else if(result==2){
					//예약이 실패할 경우?
					alert("예약이 실패되었습니다.");
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
