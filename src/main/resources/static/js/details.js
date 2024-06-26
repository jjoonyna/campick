

$(document).ready(function campcontent(contentId){
		//contentId를 url에 숫자값 그대로 가져오는 용도
	 	var url = window.location.href;
    	var contentId = url.substring(url.lastIndexOf('/') + 1);
	$.ajax({
         type : "GET",
         url : "http://localhost:80/campcontent/"+contentId,
         dataType: "json",
         success : function(result){
			 
            if(result!=null){
			 	//값을 jsp에 넣기 위해 text사용함
               $("#contentId").text(result.contentId);//API번호
               $("#user_id").text(result.user_id);//사업자아이디
               $("#facltNm").text(result.facltNm);//제목
               $("#facltNm1").text(result.facltNm);//제목
               $("#lctCl").text(result.lctCl);//주변환경(환경)
               $("#intro").text(result.intro);//짧은설명(설명)
               $("#featureNm").text(result.featureNm);//자세한 설명(설명)
               $("#induty").text(result.induty);//캠핑장종류(설명)
               $("#zipcode").text(result.zipcode);//우편번호(찾아오는길)
               $("#addr1").text(result.addr1);//도로명주소(찾아오는길)
               $("#tel").text(result.tel);//대표번호(찾아오는길)
//               $("#homepage").text(result.homepage);//홈페이지(찾아오는길)
               $("#toietCo").text(result.toietCo);//화장실개수(물품)
               $("#swrmCo").text(result.swrmCo);//샤워실개수(물품)
               $("#wtrplCo").text(result.wtrplCo);//개수대개수(물품)
               $("#brazierCl").text(result.brazierCl);//화로대개수(물품)
               $("#sbrsCl").text(result.sbrsCl);//부대시설(환경)
               $("#sbrsEtc").text(result.sbrsEtc);//부대시설기타(환경)
               $("#posblFcltyCl").text(result.posblFcltyCl);//주변이용시설(환경)
               $("#extshrCo").text(result.extshrCo);//소화기개수(물품)
               $("#themaEnvrnCl").text(result.themaEnvrnCl);//테마환경(환경)
               $("#animalCmgCl").text(result.animalCmgCl);//애완동물출입(환경)
               $("#firstImageUrl").attr("src",result.firstImageUrl);//대표이미지
               $("#cmp_pic").text(result.cmp_pic);//캠핑장이미지
               $("#cmp_maxpp").text(result.cmp_maxpp);//최대 예약 인원
               $("#cmp_staydate ").text(result.cmp_staydate);//최대 숙박 일자
               $("#cmp_price").text(result.cmp_price);//최대 이용 금액
               $("#cmp_kind").text(result.cmp_kind);//최대 이용 금액
               
               
                //homepage 주소값 넣기
                var homepage = result.homepage;
                $("#homepage").attr("href", homepage); 
               
               //if문 사용해서 이미지 바꾸기
                 var dynamicHtml = '';
                 //상태가 u인경우
            if (result.cmp_kind === 'u') {
                dynamicHtml += '<div class="main-conteiner">';
                dynamicHtml += '    <div class="imageset-img">';
                dynamicHtml += '        <img src='+result.firstImageUrl+' alt="캠프 이미지">';
                dynamicHtml += '    </div>';
                dynamicHtml += '    <div class="contents-right">';
                dynamicHtml += '        <div>최대예약인원 : <span>'+result.cmp_maxpp+'</span></div><br/>';
                dynamicHtml += '        <div>최대숙박일자 : <span>'+result.cmp_staydate+'</span></div><br/>';
                dynamicHtml += '        <div>최대이용금액 : <span>'+result.cmp_price+'</span></div><br/>';
                dynamicHtml += '        <div class="contents-button">';
                dynamicHtml += '            <div><a href="../camp_appointment/' + contentId + '" class="inqry">예약하기</a></div>';
                dynamicHtml += '            <div><a href="#"><img src="../icons/ico_bell_black.svg"></a></div>';
                dynamicHtml += '            <div><a href="#"><img src="../icons/ico_star_black.svg"></a></div>';
                dynamicHtml += '            <div><a href="#"><img src="../icons/ico_heart_black.svg"></a></div>';
                dynamicHtml += '        </div>';
                dynamicHtml += '    </div>';
                dynamicHtml += '</div>';
            } else {	//u가 아닌경우
                dynamicHtml += '<div class="imageset-img1">';
                dynamicHtml += '    <img src='+result.firstImageUrl+' alt="캠프 이미지">';
                dynamicHtml += '</div>';
            }

            // 동적으로 생성한 HTML을 페이지에 추가
            $('#dynamicContent').html(dynamicHtml);

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
	


