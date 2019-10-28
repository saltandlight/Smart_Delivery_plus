package com.util;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.vo.Customer;
import com.vo.Order;

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
	
	@AfterReturning(pointcut="execution(* com.controller.OrderController.productorder(..)) || execution(* com.controller.OrderController.orderdetail(..))",
			returning="obj")
	public void orderLogging(JoinPoint jp, Object obj) {
		// session에서 loginuser attribute를 받아와 로그인 한 유저의 행동(bboardlist와 rtmap만..) 추적
//		HttpSession session = (HttpSession) jp.getArgs()[0];k
//		Customer loginuser = (Customer)session.getAttribute("loginuser");
//		
//		
//		work_log.debug("user : " + loginuser.getCustomer_id() +
//				" at board " + jp.getSignature().getName());	
		System.out.println("order(target) : "+obj.toString());
		Order order=(Order) obj;
		
//		work_log.debug("order(target) : "+order.toS);
		work_log.debug("order(advice obj) : "+jp.getThis().toString());
	}
	

//	@Around("execution(* com.sds.component..*Service.*(..))")
//	public Object aroundLogger(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("�Լ� ���� ��");
//		System.out.println(pjp.getSignature().getName());
//		Object returnObj = pjp.proceed();
//		System.out.println(returnObj.toString());
//		System.out.println("�Լ� ���� ��");
//		return returnObj;
//	}
	
}