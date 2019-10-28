<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <div class="hero-wrap hero-bread" style="background-image: url('/SmartDelivery/view/user/images/bg_1.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
          	<p class="breadcrumbs"><span class="mr-2"><a href="customermain.del">Home</a></span> <span>Login</span></p>
            <h1 class="mb-0 bread">Login</h1>
          </div>
        </div>
      </div>
    </div>
        
        <div class="log_form_div">
          <div>
            <form action="loginimpl.del" method="POST" class="bg-white p-5 contact-form">
              <div class="form-group">
                <input type="text" size="10" id="id" name="CUSTOMER_ID" class="form-control" placeholder="ID">
              </div>
              <div class="form-group">
                <input type="password" size="10" id="pwd" name="CUSTOMER_PWD" class="form-control" placeholder="Password">
              </div>
             
              <div class="form-group">
                <input type="submit" size="10" value="LOGIN" class="btn btn-primary py-3 px-5">
              </div>
            </form> 
             
             
          </div>

          </div>
     
        </div>
      </div>
    </section>
  
 

</html>