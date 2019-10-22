<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  

    <div class="hero-wrap hero-bread" style="background-image: url('/SmartDelivery/view/user/images/bg_1.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
          	<p class="breadcrumbs"><span class="mr-2"><a href="customermain.del">Home</a></span> <span>Order</span></p>
            <h1 class="mb-0 bread">Order</h1>
          </div>
        </div>
      </div>
    </div>

    <section class="ftco-section">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-xl-7 ftco-animate">
						<form action="#" class="billing-form">
							<h3 class="mb-4 billing-heading">결제정보 입력하기</h3>
	          	<div class="row align-items-end">
	          		
                <div class="w-100"></div>
		          <!--   <div class="col-md-12">
		            	<div class="form-group">
		            		<label for="country">State / Country</label>
		            		<div class="select-wrap">
		                  <div class="icon"><span class="ion-ios-arrow-down"></span></div>
		                  <select name="" id="" class="form-control">
		                  	<option value="">France</option>
		                    <option value="">Italy</option>
		                    <option value="">Philippines</option>
		                    <option value="">South Korea</option>
		                    <option value="">Hongkong</option>
		                    <option value="">Japan</option>
		                  </select>
		                </div>
		            	</div>
		            </div> -->
		            <div class="w-100"></div>
		            <div class="col-md-12">
		            	<div class="form-group">
	                	<label for="streetaddress">배송지 주소</label>
	                  <input type="text" class="form-control" >
	                </div>
		            </div>
		            
		            <div class="w-100"></div>
		            <div class="col-md-12">
	                <div class="form-group">
	                	<label for="phone">수령인 전화번호</label>
	                  <input type="text" class="form-control" placeholder="">
	                </div>
	              </div>
	              
                <div class="w-100"></div>
                <div class="col-md-12">
                	<div class="form-group mt-4">
                	  <label for="country">지불 방식</label>
										<div class="radio">
										  <label class="mr-3"><input type="radio" name="pay"> 카드 </label>
										  <label><input type="radio" name="pay"> 무통장 입금</label>
										</div>
									</div>
									
                </div>
                
	            </div>
	           <p><a href="orderdetail.del"class="btn btn-primary py-3 px-4">결제하기</a></p>
	          </form><!-- END -->
					</div>
					<div class="col-xl-5">
	          <div class="row mt-5 pt-3">
	          	<div class="col-md-12 d-flex mb-5">
	          		<div class="cart-detail cart-total p-3 p-md-4">
	          			<h3 class="billing-heading mb-4">카트 총 가격</h3>
	          			<p class="d-flex">
		    						<span>가격</span>
		    						<span class="price">$${p.product_price }</span>
		    					</p>
		    					<p class="d-flex">
		    						<span>배송비</span>
		    						<span class="del_price">$20</span>
		    					</p>
		    					
		    					<hr>
		    					<p class="d-flex total-price">
		    						<span>총 가격</span>
		    						<span class="total_price"></span>
		    					</p>
								</div>
	          	</div>
	          	<!-- <div class="col-md-12">
	          		<div class="cart-detail p-3 p-md-4">
	          			<h3 class="billing-heading mb-4">Payment Method</h3>
									<div class="form-group">
										<div class="col-md-12">
											<div class="radio">
											   <label><input type="radio" name="optradio" class="mr-2"> Direct Bank Tranfer</label>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-12">
											<div class="radio">
											   <label><input type="radio" name="optradio" class="mr-2"> Check Payment</label>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-12">
											<div class="radio">
											   <label><input type="radio" name="optradio" class="mr-2"> Paypal</label>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-12">
											<div class="checkbox">
											   <label><input type="checkbox" value="" class="mr-2"> I have read and accept the terms and conditions</label>
											</div>
										</div>
									</div>
									<p><a href="#"class="btn btn-primary py-3 px-4">Place an order</a></p>
								</div>
	          	</div>
	          </div>
          </div> .col-md-8 
        </div>-->
      </div>
    </section> <!-- .section -->

		<section class="ftco-section ftco-no-pt ftco-no-pb py-5 bg-light">
      <div class="container py-4">
        <div class="row d-flex justify-content-center py-5">
          <div class="col-md-6">
          	<h2 style="font-size: 22px;" class="mb-0">Subcribe to our Newsletter</h2>
          	<span>Get e-mail updates about our latest shops and special offers</span>
          </div>
          <div class="col-md-6 d-flex align-items-center">
            <form action="#" class="subscribe-form">
              <div class="form-group d-flex">
                <input type="text" class="form-control" placeholder="Enter email address">
                <input type="submit" value="Subscribe" class="submit px-3">
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>


  <script>
  function getData(){
		$.ajax({
			url:'https://cors-anywhere.herokuapp.com/http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=',
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
				alert(temp+' '+'강수확률:'+pop+' '+ws+'\n');
				
				return false;
			}
		});
	}

  
  
  
		$(document).ready(function(){
			getData();
			var a = $('.price').text();
			var price=a.replace("$","");
			var b = $('.del_price').text();
			var del_price=b.replace("$","");
			var result;
			result = eval("result="+price +"+"+ del_price+";");
			$('.total_price').html("$"+result);
			
			
			
		var quantitiy=0;
		   $('.quantity-right-plus').click(function(e){
		        
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		            
		            $('#quantity').val(quantity + 1);

		          
		            // Increment
		        
		    });

		     $('.quantity-left-minus').click(function(e){
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		      
		            // Increment
		            if(quantity>0){
		            $('#quantity').val(quantity - 1);
		            }
		    });
		    
		});
	</script>