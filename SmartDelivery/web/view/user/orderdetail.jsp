<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  

<style>
.table1{
	border-collapse:collapse;
	width:100%;
}

th, td{
 padding: 8px;
 text-align:left;
 border-bottom: 1px solid #ddd;
}

</style>
    <div class="hero-wrap hero-bread" style="background-image: url('/SmartDelivery/view/user/images/bg_1.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
          	<p class="breadcrumbs"><span class="mr-2"><a href="customermain.del">Home</a></span> <span>OrderDetail</span></p>
            <h1 class="mb-0 bread">OrderDetail</h1>
          </div>
        </div>
      </div>
    </div>

   <section class="ftco-section">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-xl-7 ftco-animate">
				<h2 class="mb-4 billing-heading">주문 #${o.order_id }</h2>
	          	<div class="row align-items-end">
	          		
                <div class="w-100"></div>
		            <div class="col-md-12">
		              <p>주문 #${o.order_id }가 ${o.order_date }에 이루어졌으며 현재 입금확인 중입니다.</p>
		            	
		            	</div>
		            </div>
		            <br>
		            <div class="w-100"></div>
		            <div class="col-md-12">
		            	<div class="form-group">
	                	<h4>주문 업데이트</h4>
	                	<br>
	                    <p>${o.customer_id }님 $${o.order_price } 입금</p>
	                </div>
		            </div>
		            
		            <div class="w-100"></div>
		            <br>
		            <div class="col-md-12">
	                <div class="form-group">
	                	<h4>주문 상세</h4>
	                	<br>
	                 	 <table class="table1">
	                 	   <tr><td>상품</td><td>통계</td></tr>
	                       <tr><td>${p.product_name }</td><td>$${p.product_price }</td></tr>
	                 	   <tr><td>배송</td><td>$20</td></tr>
	                       <tr><td>합계</td><td>$${o.order_price }</td></tr>	  
	                       <tr><td>지불 방법</td><td>${o.order_pay }</td></tr>	  
	                       <tr><td>총계</td><td>$${o.order_price }</td></tr>	                  
	                    </table>
	                </div>
	              </div>
	              
                <!-- <div class="w-100"></div>
                <div class="col-md-12">
                	<div class="form-group mt-4">
                	  <label for="country">지불 방식</label>
										<div class="radio">
										  <label class="mr-3"><input type="radio" name="pay"> 카드 </label>
										  <label><input type="radio" name="pay"> 무통장 입금</label>
										</div>
									</div>-->
									
                </div>
                
	            </div> 
					</div>
					<div class="col-xl-5">
	       <!--    <div class="row mt-5 pt-3">
	          	<div class="col-md-12 d-flex mb-5">
	          		<div class="cart-detail cart-total p-3 p-md-4">
	          			<h3 class="billing-heading mb-4">카트 총 가격</h3>
	          			<p class="d-flex">
		    						<span>가격</span>
		    						<span>$20.60</span>
		    					</p>
		    					<p class="d-flex">
		    						<span>배송비</span>
		    						<span>$0.00</span>
		    					</p>
		    					
		    					<hr>
		    					<p class="d-flex total-price">
		    						<span>총 가격</span>
		    						<span>$20.60</span>
		    					</p>
								</div>
	          	</div> 
	          	<div class="col-md-12">
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
          </div>-->
        </div>
      </div>
    </section> 

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
		$(document).ready(function(){

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
	
	