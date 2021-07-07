package com.util;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.vo.Customer;
import com.vo.Order;
import com.vo.Product;

import freemarker.log.Logger;

@Service
@Aspect
public class LogAdvisor {
	private Logger work_log = 
			Logger.getLogger("work"); 
	private Logger user_log = 
			Logger.getLogger("user"); 
	private Logger data_log = 
			Logger.getLogger("data"); 
	
	// after return
	@AfterReturning(pointcut="execution(* com.controller.CustomerController.loginimpl(..))",
			returning="obj")
	public void sessionLogging(JoinPoint jp, Object obj) {
		// User 정상 로그인 후 session에서 loginuser attribute를 받아와 로그인 한 유저의 닉네임 로깅
		HttpSession session = null;
		
		for(Object object : jp.getArgs()) {
			if(object instanceof HttpSession) {
				session = (HttpSession) object;
			}
		}
		
		Customer loginuser = (Customer)session.getAttribute("loginuser");
		
		user_log.debug("user : " + loginuser.getCustomer_id() +" logged in.");
	}
	
//	@AfterReturning(pointcut="execution(* com.controller.OrderController.productorder(..))",
//			returning="obj")
//	public void productLogging(JoinPoint jp, Object obj) {
//		
//		System.out.println("order(target) : "+obj.toString());
//		ModelAndView mv=(ModelAndView) obj;
//	    
//		System.out.println(mv.getModel().toString());
//		Product product=(Product) mv.getModel().get("p");
//		
//		work_log.debug(product.getProduct_name()+","+product.getProduct_price());
//	}
//	

	@AfterReturning(pointcut="execution(* com.controller.OrderController.orderdetail(..))",
			returning="obj")
	public void orderLogging(JoinPoint jp, Object obj) {
		ModelAndView mv=(ModelAndView)obj;
		
		Order order=(Order)mv.getModel().get("o");
		
		System.out.println(mv.getModel().toString());
		Product product=(Product) mv.getModel().get("p");
		
		work_log.debug(product.getProduct_name()+" , "+product.getProduct_price()+" , "+order.getOrder_wea());
		
		
//		data_log.debug(order.getOrder_wea());
	}
	
	
	
}