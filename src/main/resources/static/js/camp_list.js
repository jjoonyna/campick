//검색버튼 눌렀을때
$(function(){
	$("#searchBtn").click(function(){
		camplist(1);
	});
});

camplist(1);

function camplist(page){
	var formdata={
		search: $("#search").val(),
		induty: $("#induty").val(),
		doNm: $("#doNm").val(),
		sigunguNm: $("#sigunguNm").val()
	}
   $.ajax({
      type : "Post",
      url : "http://localhost:80/camplist/"+page,
      contentType: "application/json",
      data : JSON.stringify(formdata),
      success : function(result){      
		  console.log(result.search);
		  console.log(result.induty);
		  console.log(result.doNm);
		  console.log(result.sigunguNm);
         var content = ""
         $.each(result.camplist, function (index, item) {
              content += "<hr><a src='camp_content/'"+item.contentId+">";
                content += "<div class='cardset cardset-hor cardset-xl' id='cardInto'>";
                content += "<figure class='cardset-figure'>";
                content += "<img class='cardset-img' src='"+(item.firstImageUrl)+"' alt='카드이미지'>";
                content += "</figure>";
                content += "<div class='cardset-body'>";
                content += "<h2 class='cardset-tit' onClick='campDetail(" +  item.contentId + ")'>"+item.facltNm+"<h2>";
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
                content += "<c:if test='"+item.toiletCo+" gt "+0+"'>";
                content += "<img class='icon-big' src='../images/wc1.png'>";
                content += "</c:if>";
                content += "<c:if test='not emty "+item.brazierCl+"'>";
                content += "<img class='icon-big' src='./images/barbeque1.png'>";
                content += "</c:if>";
                content += "<c:if test='"+item.swrmCo+" gt "+0+"'>";
                content += "<img class='icon-big' src='../images/shower2.png'>";
                content += "</c:if>";
                content += "<c:if test='"+item.caravSiteCo+" gt "+0+"'>";
                content += "<img class='icon-big' src='../images/caravan.png'>";
                content += "</c:if>";
                content += "<c:if test='"+item.animalCmgCl+" eq Y'>";
                content += "<img class='icon-big' src='../images/pet1.png'>";
                content += "</c:if>";
                content += "</div>";
                content += "</div>";
                content += "</div>";
                content += "</div>";
                content += "</a>"
          });         
         $("#cardlist").html(content);
         
			if(result.search== null && result.induty==null && result.doNm==null && result.sigunguNm==null){
			// 페이징 처리 추가
            var pagination = "<br><br>";
             pagination += "<nav id='pagiset pagiset-circ'>";
             pagination += "<div class='pagiset-ctrl'>";
			 
             pagination += "<a class='pagiset-link pagiset-first' href='javascript:camplist(" + (1) + ")'";
             pagination += "class='pagiset-link pagiset-first'";
             pagination += ">";
             pagination += "처음";
             pagination += "</a>";
             pagination += "</div>";
             if(result.page>1){
             pagination += "<div class='pagiset-ctrl'>";
             pagination += "<a class='pagiset-link pagiset-first' href='javascript:camplist(" + (result.startPage-10) + ")'>";
             pagination += "이전";
             pagination += "</a>";
             pagination += "</div>";
			 }
			 
             pagination += "<div class='pagiset-list'>";
            for (var i = result.startPage; i <= result.endPage; i++) {
                pagination += "<span class='page-item " + (i === result.page ? "active" : "") + "'>";
                pagination += "<a id=subject href='javascript:camplist(" + i + ")'>" + i + "</a></span>";
            }
            if(result.endPage<result.pageCount){
            pagination += "<div class='pagiset-ctrl'>";
            pagination += "<a class='pagiset-link pagiset-next' href='javascript:camplist(" + (result.startPage+10) + ")'>";
            pagination += "다음";
            pagination += "</a>";
            pagination += "</div>";
			}
            pagination += "<div class='pagiset-ctrl'>";
            pagination += "<a class='pagiset-link pagiset-last'";
            pagination += "href='javascript:camplist(" + (result.pageCount) + ")'>";
            pagination += "마지막";
            pagination += "</a>";
            pagination += "</div>";
            pagination += "</nav>";
            $("#pagein").html(pagination);
			
		}			
         
			if(result.search!= null || result.induty!=null || result.doNm!=null || result.sigunguNm!=null){
			// 페이징 처리 추가
            var pagination = "<br><br>";
             pagination += "<nav id='pagiset pagiset-circ'>";
             pagination += "<div class='pagiset-ctrl'>";
			 
             pagination += "<a class='pagiset-link pagiset-first' href='javascript:camplist(" + (1) + ")'";
             pagination += "class='pagiset-link pagiset-first'";
             pagination += ">";
             pagination += "처음";
             pagination += "</a>";
             pagination += "</div>";
             if(result.page>1){
             pagination += "<div class='pagiset-ctrl'>";
             pagination += "<a class='pagiset-link pagiset-first' href='javascript:camplist(" + (result.startPage-10) + ")'>";
             pagination += "이전";
             pagination += "</a>";
             pagination += "</div>";
			 }
			 
             pagination += "<div class='pagiset-list'>";
            for (var i = result.startPage; i <= result.endPage; i++) {
                pagination += "<span class='page-item " + (i === result.page ? "active" : "") + "'>";
                pagination += "<a id=subject href='javascript:camplist(" + i + ")'>" + i + "</a></span>";
            }
            if(result.endPage<result.pageCount){
            pagination += "<div class='pagiset-ctrl'>";
            pagination += "<a class='pagiset-link pagiset-next' href='javascript:camplist(" + (result.startPage+10) + ")'>";
            pagination += "다음";
            pagination += "</a>";
            pagination += "</div>";
			}
            pagination += "<div class='pagiset-ctrl'>";
            pagination += "<a class='pagiset-link pagiset-last'";
            pagination += "href='javascript:camplist(" + (result.pageCount) + ")'>";
            pagination += "마지막";
            pagination += "</a>";
            pagination += "</div>";
            pagination += "</nav>";
            $("#pagein").html(pagination);
			
		}			
			}

	});	
};


//상세보기 이동
function campDetail(contentId){
   location="camp_content/"+contentId;
}



