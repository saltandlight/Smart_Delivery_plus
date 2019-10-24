<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>simpleMap</title>
        <script src="https://apis.openapi.sk.com/tmap/jsv2?version=1&format=javascript&appkey=8fe8578d-7236-4214-82fe-a41d45b6d10b"></script>
        <script type="text/javascript">
        $(document).ready(function(){
        	
        	initTmap();
        });
        
        
        function initTmap(){
        	var map = new Tmapv2.Map("map_div",  
        	{
        		center: new Tmapv2.LatLng(37.566481622437934,126.98502302169841), 
        		width: "890px",
        		height: "400px",
        		zoom: 15
        	});
        	 

        	var marker = new Tmapv2.Marker({
        		position: new Tmapv2.LatLng(37.566481622437934,126.98502302169841),
        		map: map
        	});	
        }
		</script>
    </head>
    <body>
        <div id="map_div"></div>        
    </body>
</html>	