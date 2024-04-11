$(function(page){
	$.ajax({
		type : "GET",
		url : "http://localhost:80/camplist/"+page,
		success : function(result){		
			var no = result.listcount - (result.page - 1) * 10;    // 화면출력 번호
			var content = ""
			$.each(result.camplist, function (index, item) {
		          content += "<div class='cardset cardset-hor cardset-xl' id='cardInto'>";
		          content += "<figure class='cardset-figure'>";
		          content += "<img class='cardset-img' src='"+(item.firstImageUrl)+"' alt='위치아이콘'>";
		          content += "</figure>";
		          content += "<div class='cardset-body'>";
		          content += "<h2 class='cardset-tit'>"+item.facltNm+"<h2>";
		          content += "<h6 class='cardset-desc'>"+item.lineIntro+"<h6>";
		          content += "<div class='badgeset-wrap'>"
		          content += "<div style='display: flex; align-item: center;'>";
		          
		    });			
			$("#cardlist").html(content);
			
			// 페이징 처리 추가
            var pagination = "<div style='text-align:center'>";
            for (var i = result.startPage; i <= result.endPage; i++) {
                pagination += "<span class='page-item " + (i === result.page ? "active" : "") + "'>";
                pagination += "<a id=subject href='javascript:camp_content(" + i + ")'>" + i + "</a></span>";
            }
            pagination += "</div>";
            $("#pagiset pagiset-circ").html(pagination);
			
		}			
	});	
});