<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="/SmartDelivery/user/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="/SmartDelivery/user/css/animate.css">
    
    <link rel="stylesheet" href="/SmartDelivery/user/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/SmartDelivery/user/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="/SmartDelivery/user/css/magnific-popup.css">

    <link rel="stylesheet" href="/SmartDelivery/user/css/aos.css">

    <link rel="stylesheet" href="/SmartDelivery/user/css/ionicons.min.css">

    <link rel="stylesheet" href="/SmartDelivery/user/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="/SmartDelivery/user/css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="/SmartDelivery/user/css/flaticon.css">
    <link rel="stylesheet" href="/SmartDelivery/user/css/icomoon.css">
    <link rel="stylesheet" href="/SmartDelivery/user/css/style.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>


    <script>
	function joinCheck(obj) {		
		var regex = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/;
		if (!obj.CUSTOMER_ID.value || obj.CUSTOMER_ID.value.trim().length == 0) {
			alert("아이디가 입력되지 않았습니다.");
			obj.CUSTOMER_ID.value = "";
			obj.CUSTOMER_ID.focus();
			return false;
		}
		//아이디 길이 체크
		if(obj.CUSTOMER_ID.value.length<4 || obj.CUSTOMER_ID.value.length>12){
			alert("아이디를 4~12자까지 입력해주세요.")
            obj.CUSTOMER_ID.focus();
            obj.CUSTOMER_ID.select();
            return false;
		
		}
		//아이디 유효성 검사 (영문소문자, 숫자만 허용)
        for (i = 0; i < obj.CUSTOMER_ID.value.length; i++) {
            ch = obj.CUSTOMER_ID.value.charAt(i);
            if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')) {
                alert("아이디는 대소문자, 숫자만 입력가능합니다.")
                obj.CUSTOMER_ID.focus();
                obj.CUSTOMER_ID.select();
                return false;
            }
        }
		//아이디에 공백 사용하지 않기
        if (obj.CUSTOMER_ID.value.indexOf(" ") >= 0) {
            alert("아이디에 공백을 사용할 수 없습니다.")
            obj.CUSTOMER_ID.focus();
            obj.CUSTOMER_ID.select();
            return false;
        }
		
		
		if (!obj.CUSTOMER_PWD.value
				|| obj.CUSTOMER_PWD.value.trim().length == 0) {
			alert("비밀번호가 입력되지 않았습니다.");
			obj.CUSTOMER_PWD.value = "";
			obj.CUSTOMER_PWD.focus();
			return false;
		}
		
		 if (obj.CUSTOMER_PWD.value == obj.CUSTOMER_ID.value) {
	            alert("아이디와 비밀번호가 같습니다.")
	            obj.CUSTOMER_PWD.focus();
	            return false;
	      }
		 
		
		
		if (regex.test(obj.CUSTOMER_PWD.value) === false) {
			 alert("비밀번호가 6~20 영문 대소문자와 최소 1개의 숫자 혹은 특수 문자를 포함해야 합니다.");
	         obj.CUSTOMER_PWD.focus();
	         obj.CUSTOMER_PWD.select();
	         return false;
        }
		
		if (!obj.CUSTOMER_NM.value || obj.CUSTOMER_NM.value.trim().length == 0) {
			alert("이름이 입력되지 않았습니다.");
			obj.CUSTOMER_NM.value = "";
			obj.CUSTOMER_NM.focus();
			return false;
		}
		if(obj.CUSTOMER_NM.value.length<2){
	            alert("이름을 2자 이상 입력해주십시오.");
	            obj.CUSTOMER_NM.focus();
	            return false;
	     }
		if (!obj.CUSTOMER_PHONE.value
				|| obj.CUSTOMER_PHONE.value.trim().length == 0) {
			alert("번호가 입력되지 않았습니다.");
			obj.CUSTOMER_PHONE.value = "";
			obj.CUSTOMER_PHONE.focus();
			return false;
		}
		if (!obj.CUSTOMER_ADDR.value
				|| obj.CUSTOMER_ADDR.value.trim().length == 0) {
			alert("주소가 입력되지 않았습니다.");
			obj.CUSTOMER_ADDR.value = "";
			obj.CUSTOMER_ADDR.focus();
			return false;
		}
	}
	
	
	$(document).ready(function() {
		$('input[name="CUSTOMER_PWD2"]').keyup(function() {
			var pw = $('input[name="CUSTOMER_PWD"]').val();
			var pw2 = $('input[name="CUSTOMER_PWD2"]').val();
			if(pw != pw2 || pw2 == ''){
			 $('.same').html('<span style="color:red">비밀번호가 맞지 않아요</span>');
			 $('input[name="registerok"]').attr('disabled','disabled');
			 return false;
				
			}else if(pw == pw2){
				$('.same').html('<span style="color:blue">비밀번호가 맞습니다.</span>');
				$('input[name="registerok"]').removeAttr('disabled');
				return false;
			}
			
		});
		$('input[name="registerok"]').click(function() {
			alert("회원가입이 완료 되었습니다.(환영합니다!)")
		});
		$('input[name="idceck"]').click(function() {
			
			var CUSTOMER_ID = $('input[name="CUSTOMER_ID"]').val();
			
			$.ajax({
				url:"checkId.del",
				data:{'CUSTOMER_ID':CUSTOMER_ID},
				method:"POST",
				success:function(result){
					if(result == '1'){
						alert("아이디 중복입니다.");
						$('input[name="registerok"]').attr('disabled','disabled');
						$('.idsame').html('<span style="color:red">아이디 중복입니다.</span>');
						return false;
					}else if(result == '0'){
						alert("사용 가능한 아이디 입니다.");
						$('input[name="registerok"]').removeAttr('disabled');
						$('.idsame').html('<span style="color:red"></span>');
						return false;
					}
					
					
					
				}
			
			});
			
		});
	});
</script>

    
    
  </head>
  <!--  
  <style>
  .join_form_div{
	margin: auto 0;
	padding: 200px;
   }

  
  
  </style>-->
  <body class="goto-here">
		<div class="py-1 bg-primary">
    	<div class="container">
    		<div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
	    		<div class="col-lg-12 d-block">
		    		<div class="row d-flex">
		    			<div class="col-md pr-4 d-flex topper align-items-center">
					    	<div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-phone2"></span></div>
						    <span class="text">+ 1235 2355 98</span>
					    </div>
					    
					    <div class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
						    <span class="text">3-5 Business days delivery &amp; Free Returns</span>
					    </div>
				    </div>
			    </div>
		    </div>
		  </div>
    </div>
    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="/SmartDelivery/index.jsp">Vegefoods</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item"><a href="/SmartDelivery/index.jsp" class="nav-link">Home</a></li>
	          <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Shop</a>
              <div class="dropdown-menu" aria-labelledby="dropdown04">
              	<a class="dropdown-item" href="shop.jsp">Shop</a>
              	<a class="dropdown-item" href="wishlist.jsp">Wishlist</a>
                <a class="dropdown-item" href="product-single.jsp">Single Product</a>
                <a class="dropdown-item" href="cart.jsp">Cart</a>
                <a class="dropdown-item" href="checkout.jsp">Checkout</a>
              </div>
            </li>
	          <li class="nav-item"><a href="about.jsp" class="nav-link">About</a></li>
	          <li class="nav-item"><a href="blog.jsp" class="nav-link">Blog</a></li>
	          <li class="nav-item"><a href="join.jsp" class="nav-link">Join</a></li>
	          <li class="nav-item active"><a href="login.jsp" class="nav-link">Login</a></li>
	          <!-- 로그인한 후에만 들어갈 수 있게 해야 함  -->
	          <li class="nav-item"><a href="deliverycheck.jsp" class="nav-link">DeliveryCheck</a></li>
	          <li class="nav-item cta cta-colored"><a href="cart.jsp" class="nav-link"><span class="icon-shopping_cart"></span>[0]</a></li>

	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->

    <div class="hero-wrap hero-bread" style="background-image: url('/SmartDelivery/user/images/bg_1.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
          	<p class="breadcrumbs"><span class="mr-2"><a href="/SmartDelivery/index.jsp">Home</a></span> <span>Join us</span></p>
            <h1 class="mb-0 bread">Join</h1>
          </div>
        </div>
      </div>
    </div>


        <div class="join_form_div">
          <div>
            <form action="customerjoinimpl.del" method="POST" onclick="return joinCheck(this)" class="bg-white p-5 contact-form">
             <div class="form-group"> 
                <input type="text"  size="7" id="id" name="CUSTOMER_ID" class="form-control" placeholder="ID">
            
                <input type="button" class="btn btn-primary py-3 px-20" name="idceck" value="중복확인" />
       
               </div>
              <div class="form-group">
                <input type="password"  size="10"  name="CUSTOMER_PWD" class="form-control" placeholder="Password">
              </div>
             <div class="form-group"> 
                <input type="password"  size="10" name="CUSTOMER_PWD2" onchange="isSame()" class="form-control" placeholder="Password Check">
                <span class="same"></span>
             </div> 
             <div class="form-group"> 
                <input type="text" size="10"  id="name" name="CUSTOMER_NM" class="form-control" placeholder="Name">
            </div> 

             <div class="form-group">	
                <input type="text"  size="10"  id="gender"  name="CUSTOMER_GD" class="form-control" placeholder="Gender">
             </div> 

              <div class="form-group"> 
                <input type="text"  size="10" id="age" name="CUSTOMER_AGE" class="form-control" placeholder="Age">
              </div> 
              
            <div class="form-group">   
                <input type="text"  size="10" id="phonenumber" name="CUSTOMER_PHONE" class="form-control" placeholder="Phone Number">
             </div> 
             
             <div class="form-group">
                <input type="text" size="10"  id="useraddr" name="CUSTOMER_ADDR" class="form-control" placeholder="Address">
             </div>
             <div class="form-group">
                <input type="submit" value="JOIN" name="registerok" class="btn btn-primary py-3 px-5" >
              </div> 
            </form> 
             
             
          </div>
<!--  
          <div class="col-md-6 d-flex">
          	<div id="map" class="bg-white"></div>     
          -->
          </div>
     
        </div>
      </div>
    </section>

    <footer class="ftco-footer ftco-section">
      <div class="container">
      	<div class="row">
      		<div class="mouse">
						<a href="#" class="mouse-icon">
							<div class="mouse-wheel"><span class="ion-ios-arrow-up"></span></div>
						</a>
					</div>
      	</div>
        <div class="row mb-5">
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Vegefoods</h2>
              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4 ml-md-5">
              <h2 class="ftco-heading-2">Menu</h2>
              <ul class="list-unstyled">
                <li><a href="shop.jsp" class="py-2 d-block">Shop</a></li>
                <li><a href="about.jsp" class="py-2 d-block">About</a></li>
                <li><a href="#" class="py-2 d-block">Journal</a></li>
                <li><a href="login.jsp" class="py-2 d-block">Login</a></li>
                
              </ul>
            </div>
          </div>
          <div class="col-md-4">
             <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Help</h2>
              <div class="d-flex">
	              <ul class="list-unstyled mr-l-5 pr-l-3 mr-4">
	                <li><a href="#" class="py-2 d-block">Shipping Information</a></li>
	                <li><a href="#" class="py-2 d-block">Returns &amp; Exchange</a></li>
	                <li><a href="#" class="py-2 d-block">Terms &amp; Conditions</a></li>
	                <li><a href="#" class="py-2 d-block">Privacy Policy</a></li>
	              </ul>
	              <ul class="list-unstyled">
	                <li><a href="#" class="py-2 d-block">FAQs</a></li>
	                <li><a href="#" class="py-2 d-block">Contact</a></li>
	              </ul>
	            </div>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Have a Questions?</h2>
            	<div class="block-23 mb-3">
	              <ul>
	                <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
	                <li><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a></li>
	                <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a></li>
	              </ul>
	            </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 text-center">

            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart color-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
						  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
          </div>
        </div>
      </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  </body>
    <script src="/SmartDelivery/user/js/jquery.min.js"></script>
  <script src="/SmartDelivery/user/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="/SmartDelivery/user/js/popper.min.js"></script>
  <script src="/SmartDelivery/user/js/bootstrap.min.js"></script>
  <script src="/SmartDelivery/user/js/jquery.easing.1.3.js"></script>
  <script src="/SmartDelivery/user/js/jquery.waypoints.min.js"></script>
  <script src="/SmartDelivery/user/js/jquery.stellar.min.js"></script>
  <script src="/SmartDelivery/user/js/owl.carousel.min.js"></script>
  <script src="/SmartDelivery/user/js/jquery.magnific-popup.min.js"></script>
  <script src="/SmartDelivery/user/js/aos.js"></script>
  <script src="/SmartDelivery/user/js/jquery.animateNumber.min.js"></script>
  <script src="/SmartDelivery/user/js/bootstrap-datepicker.js"></script>
  <script src="/SmartDelivery/user/js/scrollax.min.js"></script>
  <script src="/SmartDelivery/user/js/google-map.js"></script>
  <script src="/SmartDelivery/user/js/main.js"></script>
  
    
</html>