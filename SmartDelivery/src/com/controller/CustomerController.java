package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Customer;

@Controller
public class CustomerController {
	
	@Resource(name="cbiz")
	Biz<String,Customer> cbiz;
	
	@RequestMapping("/customerjoin.del")
	public ModelAndView register(Customer customer) {
		ModelAndView mv = new ModelAndView();
		try {
			cbiz.register(customer);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName("user/login");
		return mv;
//		System.out.println("333333333333333333333333333");
//		String id=request.getParameter("CUSTOMER_ID");
//		String pwd = request.getParameter("CUSTOMER_PWD");
//		String name = request.getParameter("CUSTOMER_NM");
//		String phone=request.getParameter("CUSTOMER_PHONE");
//		String addr=request.getParameter("CUSTOMER_ADDR");
//		String gender=request.getParameter("CUSTOMER_GD");
//		String age=request.getParameter("CUSTOMER_AGE");
//		Integer int_age=Integer.parseInt(age);
//		
//		Customer customer = new Customer(id, pwd, name, phone, addr, gender, int_age);
//		
//		
//		System.out.println("111111111111111111111");
//		try {
//			cbiz.register(customer);
//		} catch (Exception e) {
//			mv.addObject("join");
//			e.printStackTrace();
//		}
//		System.out.println("222222222222222222222");
//		mv.setViewName("user/login");
//		return mv;
	}
	
	
	
}
