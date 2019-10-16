<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
		
    <div class="hero-wrap hero-bread" style="background-image: url('/SmartDelivery/view/user/images/bg_1.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
          	<p class="breadcrumbs"><span class="mr-2"><a href="/SmartDelivery/index.jsp">Home</a></span> <span>Join us</span></p>
            <h1 class="mb-0 bread">Join</h1>
          </div>
        </div>
      </div>
    </div>
   </div>

        <div class="pro_add">
          <div>
            <form enctype="multipart/form-data" action="productaddimpl.del" method="POST"  class="bg-white p-5 contact-form">
             
              <div class="form-group">
                <input type="text"  size="5" name="PRODUCT_NAME" class="form-control" placeholder="Product Name">
                <label class="stext-102 cl3" for="name">IMGNAME1</label>
				<input class="size-111 bor8 stext-102 cl2 p-lr-20" id="pro_img1" type="file" name="mf">
              </div>
             
             <div class="form-group"> 
                <input type="text" size="10"  name="PRODUCT_PRICE" class="form-control" placeholder="Product Price">
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

