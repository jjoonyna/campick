$(function(page){
	$.ajax({
		type : "GET",
		url : "http://localhost:80/camplist/"+page,
		success : function(result){		
			var content = "<div><span>"
			 content = "<h2 class='textset-tit'>"
			 content = " 총&nbsp; "+result.listcount+"개의 Pick!<img src='./icons/flag1.gif''>"
			 content = "</h2></span></div>"
			$.each(result.camplist, function (index, item) {
		          content += "<div class='cardset cardset-hor cardset-xl' id='cardInto'>";
		          content += "<figure class='cardset-figure'>";
		          content += "<img class='cardset-img' src='"+(item.firstImageUrl)+"' alt='위치아이콘'">";
		          content += "</figure>";
		          content += "<div class='cardset-body'>";
		          content += "<h2 class='cardset-tit'>"+item.facltNm+"<h2>";
		          content += "<h6 class='cardset-desc'>"+item.lineIntro+"<h6>";
		          content += "<div style='display: flex; align-item: center;'>";
		    });			
			$("#cardlist").html(content);
			
			// 페이징 처리 추가
            var pagination = "<br><br>";
             pagination += "<nav id='pagiset pagiset-circ'>";
             pagination += "<div class='pagiset-ctrl'>";
			 
             pagination += "<a class='pagiset-link pagiset-first' href='camp_list?page=1'";
             pagination += "class='pagiset-link pagiset-first'";
             pagination += ">";
             pagination += "처음";
             pagination += "</a>";
             pagination += "</div>";
             if(result.page>1){
             pagination += "<div class='pagiset-ctrl'>";
             pagination += "<a class='pagiset-link pagiset-first' href='camp_list?page="+result.startPage - 1;
             pagination += ">";
             pagination += "이전";
             pagination += "</a>";
             pagination += "</div>";
			 }
             pagination += "<div class='pagiset-list'>";
             
            for (var i = result.startPage; i <= result.endPage; i++) {
                pagination += "<a class='pagiset-link' href='camp_list?page="+i;
                if(result.page==i){
					pagination += "active-fill"
				}
                pagination += ">";
                pagination += i;
                pagination += "</a>";
            }
            if(result.page<result.pageCount){
            pagination += "<div class='pagiset-ctrl'>";
            pagination += "<a class='pagiset-link pagiset-next' href='camp_list?page="+result.endPage + 1;
            pagination += ">";
            pagination += "다음";
            pagination += "</a>";
            pagination += "</div>";
			}
            pagination += "<div class='pagiset-ctrl'>";
            pagination += "<a class='pagiset-link pagiset-last'";
            pagination += "href='camp_list?page="+result.lastPage;
            pagination += ">";
            pagination += "마지막";
            pagination += "</a>";
            pagination += "</div>";
            pagination += "</nav>";
            $("#pagein").html(pagination);
			
		}			
	});	
});




