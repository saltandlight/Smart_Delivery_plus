<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script type = "text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=df116b91074c75173a292ac4cc5a4c04"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
var cnt = 0;
//날씨 rss카운트를 해줘야 해당 시간에 맞는 정보를 가져올 수 있음
function getData(){
	$.ajax({
		url:'https://cors-anywhere.herokuapp.com/http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2635061000',
		/*크로스 도메인 문제 해결을 위해 https://cors-anywhere.herokuapp.com/ 주소 붙여줌  */
		success: function(data){
			parsing(data);
		}
	})
}

function parsing(data){
	//02,05,08,11,14,17,20,23 (1일 8회 업데이트)
	var d = new Date();
	var h = d.getHours();
	/*d.getHours(); //현재 시간*/
	var temp = "";
	var pop = "";
	var ws = "";
	var weather = $(data).find('data');
	var seq = $(weather).attr('seq');
	weather.each(function(index, weather){
		if(seq == "0"){
			var hour = $(this).find('hour').text();
			hour = "("+((Number(hour))-3) + "시 ~ " + hour +"시)";
			var temp = $(this).find('temp').text();
			temp += "°C";
			var pop = $(this).find('pop').text();
			pop += "%";
			var ws = $(this).find('ws').text();
			ws += "m/s";
			$('#hour').append(hour);
			$('#temp').append(temp);
			$('#pop').append(pop);
			$('#ws').append(ws);
			return false;
		}
	});
}


/*---------------------------------------------------------------------------------*/
function makeMap(){
	var mapContainer = document.getElementById('map'),
	mapOption = {
			center : new kakao.maps.LatLng(35.15876, 129.159),
			level : 3
	};
	var map = new kakao.maps.Map(mapContainer, mapOption);
	var markerPosition = new kakao.maps.LatLng(35.15876, 129.159);
	var marker = new kakao.maps.Marker({
		position: markerPosition
	});
	marker.setMap(map);
	var iwContent = '<div style="padding:5px;">해운대 해수욕장<br><a href="http://tour.busan.go.kr/board/view.busan?boardId=ATTRACTION&menuCd=DOM_000000101001013000&startPage=1&dataSid=485" style="color:blue" target="_blank">사이트 이동</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwPosition = new kakao.maps.LatLng(35.15876, 129.159); //인포윈도우 표시 위치입니다

	// 인포윈도우를 생성합니다
	var infowindow = new kakao.maps.InfoWindow({
	    position : iwPosition,
	    content : iwContent
	});

	// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
	infowindow.open(map, marker);
};
/*---------------------------------------------------------------------------------*/

	$(document).ready(function(){
		////02,05,08,11,14,17,20,23 (1일 8회 업데이트) 해주니까 setInterval 잘 설정하기
		makeMap();
		getData();
		/* setInterval(getData, 3600000); */ //1시간마다 업데이트
	});
</script>
 <div class="container">
            <div class="inner-sec-w3pvt py-lg-5 py-3">
                <h3 class="tittle text-center mb-lg-5 mb-3 px-lg-5">오늘의 날씨<span id = "hour"></span></h3>
                <div class="feature-grids row mt-3 mb-lg-5 mb-3 mt-lg-5 text-center">

                    <div class="col-lg-4" data-aos="fade-up">
                        <div class="bottom-gd px-3">
                            <span class="fas fa-temperature-high" aria-hidden="true"></span>
                            <h3 class="my-4" id = "temp"></h3>
                            <!-- <p>Integer sit amet mattis quam, sit amet ultricies velit. Praesent ullamcorper dui turpis.</p> -->
                        </div>
                    </div>

                    <div class="col-lg-4" data-aos="fade-up">
                        <div class="bottom-gd2-active px-3">
                            <span class="fas fa-cloud-rain" aria-hidden="true"></span>
                            <h3 class="my-4"  id = "pop"></h3>
                            <!-- <p>Integer sit amet mattis quam, sit amet ultricies velit. Praesent ullamcorper dui turpis.</p> -->
                        </div>
                    </div>

                    <div class="col-lg-4" data-aos="fade-up">
                        <div class="bottom-gd px-3">
                            <span class="fas fa-wind" aria-hidden="true"></span>
                            <h3 class="my-4" id = "ws"></h3>
                            <!-- <p>Integer sit amet mattis quam, sit amet ultricies velit. Praesent ullamcorper dui turpis.</p> -->
                        </div>
                    </div>

                </div>

				<div class="fetured-info pt-lg-5">
                    <div class="row fetured-sec mt-lg-5 mt-3">
                        <div class="col-lg-6 p-0">
                            <div class="img-effect">
                            	<div id = "map" style="width:100%; height:350px;">
                            	</div>
                                <!-- <img src="images/bmap.png" alt="" class="img-fluid image1"> -->
                            </div>

                        </div>
                        <div class="col-lg-6 serv_bottom feature-grids pl-lg-5">
                            <div class="featured-left text-left">
                                <div class="bottom-gd px-3">
                                    <span class="fas fa-list-ol" aria-hidden="true"></span>
                                    <h2>인기 순위</h2>
									<h3 class="my-4">1. 해운대 해수욕장</h3><br>
									<h3 class="my-4"> 2. </h3><br>
									<h3 class="my-4"> 3. </h3><br>
									<h3 class="my-4"> 4.</h3><br>	
                                    <!-- <p>Integer sit amet mattis quam, sit amet ultricies velit. Praesent ullamcorper dui turpis.</p> -->
                                </div>
                                <!-- <div class="bottom-gd fea active p-4" data-aos="fade-left">
                                    <span class="fa fa-rocket" aria-hidden="true"></span>
                                    <h3 class="my-3 ">Mattis Quam</h3>
                                    <p>Integer sit amet mattis quam, sit amet ultricies velit. Praesent ullamcorper dui turpis.</p>
                                </div> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
