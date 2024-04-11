$(function(){
	$.ajax({
         type : "GET",
         url : "http://localhost:80/cmp_content/"+contentId,
         contentType: "application/json",
         success : function(result){
            if(result!=null){
               //성공
               alert("성공");
               $("#contentId").val(result.contentId);//API번호
               $("#user_id").val(result.user_id);//사업자번호
               //$("#facltNm").val(result.facltNm);//제목
               //$("#lctCl").val(result.lctCl);//주변환경(환경)
               //$("#intro").val(result.intro);//짧은설명(설명)
               //$("#featureNm").val(result.featureNm);//자세한 설명(설명)
               //$("#induty").val(result.induty);//캠핑장종류(설명)
               //$("#zipcode").val(result.zipcode);//우편번호(찾아오는길)
               //$("#addr1").val(result.addr1);//도로명주소(찾아오는길)
               //$("#tel").val(result.tel);//대표번호(찾아오는길)
               //$("#homepage").val(result.homepage);//홈페이지(찾아오는길)
               // $("#toietCo").val(result.toietCo);//화장실개수(물품)
               //$("#swrmCo").val(result.swrmCo);//샤워실개수(물품)
               //$("#wtrplCo").val(result.wtrplCo);//개수대개수(물품)
               //$("#brazierCl").val(result.brazierCl);//화로대개수(물품)
               //$("#sbrsCl").val(result.sbrsCl);//부대시설(환경)
               // $("#sbrsEtc").val(result.sbrsEtc);//부대시설기타(환경)
               //$("#posblFcltyCl").val(result.posblFcltyCl);//주변이용시설(환경)
               //$("#extshrCo").val(result.extshrCo);//소화기개수(물품)
               //$("#themaEnvrnCl").val(result.themaEnvrnCl);//테마환경(환경)
               //$("#animalCmgCl").val(result.animalCmgCl);//애완동물출입(환경)
               //$("#firstImageUrl").val(result.firstImageUrl);//대표이미지
               //$("#cmp_pic").val(result.cmp_pic);//캠핑장이미지
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
	
