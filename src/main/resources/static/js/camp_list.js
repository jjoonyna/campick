$(function(){
	var page=1;
	$.ajax({
		type : "GET",
		url : "http://localhost:80/camplist/"+page,
		success : function(result){		
			var no = result.listcount - (result.page - 1) * 10;    // 화면출력 번호
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
		          content += "<span>"+item.doNm+"&nbsp;+"+item.sigunguNm+"</span>";
		          content += "<img class='icon-sm' src='./icons/ico_phone_black.svg' alt='전화 아이콘'>";
		          content += "<span>"+item.tel+"</span>";
		          content += "<img class='icon-sm' src='./icons/ico_star_black.svg' alt='즐찾 아이콘'>";
		          content += "<span>"+item.cmp_fav+"회</span>";
		          content += "</div>";
		          content += "<br> <br>";
		          content += "<div>";
		          content += "<c:if test='"+item.toiletCo+" gt "+0+"'>";
		          content += "<img src='../images/wc1.png'>";
		          content += "</c:if>";
		          content += "<c:if test='not emty "+item.brazierCl+"'>";
		          content += "<img src='./images/barbeque1.png'>";
		          content += "</c:if>";
		          content += "<c:if test='"+item.swrmCo+" gt "+0+"'>";
		          content += "<img src='../images/shower2.png'>";
		          content += "</c:if>";
		          content += "<c:if test='"+item.caravSiteCo+" gt "+0+"'>";
		          content += "<img src='../images/caravan.png'>";
		          content += "</c:if>";
		          content += "<c:if test='"+item.animalCmgCl+" eq Y'>";
		          content += "<img src='../images/pet1.png'>";
		          content += "</c:if>";
		          content += "</div>";
		          content += "</div>";
		          content += "</div>";
		          content += "</div>";
		    });			
			$("#cardlist").html(content);
			
			// 페이징 처리 추가
            var pagination = "";
            for (var i = result.startPage; i <= result.endPage; i++) {
                pagination += "<span class='page-item " + (i === result.page ? "active" : "") + "'>";
                pagination += "<a id=subject href='javascript:camp_list(" + i + ")'>" + i + "</a></span>";
            }
            pagination += "</div>";
            $("#pagiset pagiset-circ").html(pagination);
			
		}			
	});	
});