$(document).ready(function() {
    var url = window.location.href;
    var contentId = url.substring(url.lastIndexOf('/') + 1);

    $.ajax({
        type: "GET",
        url: "http://localhost:80/campcontent2/" + contentId, // RESTful API 엔드포인트
        dataType: "json",
        success: function(result) {
			console.log(result);
            if (result != null) {
                // mapX와 mapY를 숫자로 변환
                var mapX = parseFloat(result.mapX);
                var mapY = parseFloat(result.mapY);
                initializeMap(mapX, mapY); // 지도 초기화 함수 호출
            } else {
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

function initializeMap(mapX, mapY) {
    var container = document.getElementById('map');
    var options = {
        center: new kakao.maps.LatLng(mapY, mapX),
        level: 3
    };

    var map = new kakao.maps.Map(container, options);

    var markerPosition = new kakao.maps.LatLng(mapY, mapX);

    var marker = new kakao.maps.Marker({
        position: markerPosition
    });

    marker.setMap(map);
}