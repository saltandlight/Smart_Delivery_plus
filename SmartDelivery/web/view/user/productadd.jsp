<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
		
    <div class="hero-wrap hero-bread" style="background-image: url('/SmartDelivery/view/user/images/bg_1.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
          	<p class="breadcrumbs"><span class="mr-2"><a href="/SmartDelivery/index.jsp">Home</a></span> <span>Product</span></p>
            <h1 class="mb-0 bread">Product</h1>
          </div>
        </div>
      </div>
    </div>
   </div>

        <div class="pro_add">
          <div>
            <form enctype="multipart/form-data" action="productaddimpl.del" method="POST"  class="bg-white p-5 contact-form">
             
              <div class="form-group">
                <input type="text"  size="5" name="product_name" class="form-control" placeholder="Product Name">
                <label class="stext-102 cl3" for="name">IMGNAME1</label>
				<input class="size-111 bor8 stext-102 cl2 p-lr-20" id="pro_img1" type="file" name="mf">
              </div>
             
             <div class="form-group"> 
                <input type="text" size="10"  name="product_price" class="form-control" placeholder="Product Price">
            </div> 
             <div class="form-group">
                <input type="submit" value="Add" name="addok" class="btn btn-primary py-3 px-5" >
              </div> 
            </form> 
             
             
          </div>
          </div>
     
        </div>
      </div>
    </section>
