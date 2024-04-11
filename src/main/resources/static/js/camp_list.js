

//캠핑장 목록, 검색 호출 및 출력!!!!+페이징처리 아직 페이징 처리 작업중
$(function(){
	
//	var formdata = {
//		induty: $("#induty option:selected").val(),
//		doNm: $("#doNm option:selected").val(),
//		sigunguNm: $("#sigunguNm option:selected").val(),
//		search: $("#search option:selected").val(),
//	};	
	
	var page=1;
	$.ajax({
		type : "GET",
		url : "http://localhost:80/camplist/"+page,
//		contentType: "application/json",
//        data : JSON.stringify(formdata),
		success : function(result){		
			var content = ""
			$.each(result.camplist, function (index, item) {
		          content += "<div class='cardset cardset-hor cardset-xl' id='cardInto'>";
		          content += "<figure class='cardset-figure'>";
		          content += "<img class='cardset-img' src='"+(item.firstImageUrl)+"' alt='카드이미지'>";
		          content += "</figure>";
		          content += "<div class='cardset-body'>";
		          content += "<h2 class='cardset-tit'>"+item.facltNm+"<h2>";
		          content += "<h6 class='cardset-desc'>"+item.lineIntro+"<h6>";
		          content += "<div class='badgeset-wrap'>";
		          content += "<div>";
		          content += "<img class='icon-sm' src='./icons/ico_location_black.svg' alt='위치아이콘'>";
		          content += "<span>"+item.doNm+"&nbsp;"+item.sigunguNm+"</span>";
		          content += "<img class='icon-sm' src='./icons/ico_phone_black.svg' alt='전화 아이콘'>";
		          content += "<span>"+item.tel+"</span>";
		          content += "<img class='icon-sm' src='./icons/ico_star_black.svg' alt='즐찾 아이콘'>";
		          content += "<span>"+item.cmp_fav+"회</span>";
		          content += "</div>";
		          content += "<br> <br>";
		          content += "<div>";
		          if(item.toiletCo>0){
		          content += "<img class='icon-big' src='../images/wc1.png'>";
				  }
		          if(item.brazierCl!=null){
		          content += "<img class='icon-big' src='./images/barbeque1.png'>";
				  }
				  if(item.swrmCo>0){
		          content += "<img class='icon-big' src='../images/shower2.png'>";
				  }
				  if(item.caravSiteCo>0){
		          content += "<img class='icon-big' src='../images/caravan.png'>";
				  }
				  if(item.animalCmgCl=="가능"){
		          content += "<img class='icon-big' src='../images/pet1.png'>";
				  }
		          content += "</div>";
		          content += "</div>";
		          content += "</div>";
		          content += "</div>";
		    });			
			$("#cardlist").html(content);
			
			// 페이징 처리 추가
            var pagination = "<br><br>";
             pagination += "<nav id='pagiset pagiset-circ'>";
             pagination += "<div class='pagiset-ctrl'>";
             if(search==null && induty==null && doNm==nulll && sigunguNm==nulll){
			 
             pagination += "<a href='camplist?page=1' class='pagiset-link pagiset-first'>";
             pagination += "class='pagiset-link pagiset-first'";
             pagination += ">";
             pagination += "처음";
             pagination += "</a>";
             pagination += "</div>";
             if(result.page>1){
             pagination += "<div class='pagiset-ctrl'>";
             pagination += "<a href='camplist?page="+result.startPage - 1+"class='pagiset-link pagiset-first'>";
             pagination += ">";
             pagination += "이전";
             pagination += "</a>";
             pagination += "</div>";
			 }
             pagination += "<div class='pagiset-list'>";
             
            for (var i = result.startPage; i <= result.endPage; i++) {
                pagination += "<a href='camplist?page="+i+"class='pagiset-link";
                if(result.page==i){
					pagination += "active-fill"
				}
                pagination += ">";
                pagination += i;
                pagination += "</a>";
            }
            if(result.page<result.pageCount){
            pagination += "<div class='pagiset-ctrl'>";
            pagination += "<a href='camplist?page="+result.endPage + 1+"class='pagiset-link pagiset-next'";
            pagination += ">";
            pagination += "다음";
            pagination += "</a>";
            pagination += "</div>";
			}
            pagination += "<div class='pagiset-ctrl'>";
            pagination += "<a ";
            pagination += "href='camplist?page="+result.lastPage+"class='pagiset-link pagiset-last'";
            pagination += ">";
            pagination += "마지막";
            pagination += "</a>";
            pagination += "</div>";
            pagination += "</nav>";
            }
            $("#pagein").html(pagination);
			
		}			
	});	
});



