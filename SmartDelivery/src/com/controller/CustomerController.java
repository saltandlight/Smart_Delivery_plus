package com.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Customer;

@Controller
public class CustomerController {
	
	@Resource(name="cbiz")
	Biz<String,Customer> cbiz;
	
	@RequestMapping("/checkId.del")
	@ResponseBody
	public ModelAndView checkId(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String CUSTOMER_ID1 = request.getParameter("CUSTOMER_ID");
		String result="";
		try {
			System.out.println(CUSTOMER_ID1);
			Customer dbuser = cbiz.get(CUSTOMER_ID1);
			if(dbuser == null) {
				result = "0";
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.write(result);
				out.close();
				
			}else {
				result = "1";
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.write(result);
				out.close();
			}
			System.out.println("result:"+result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			mv.addObject("center","user/signup");
			mv.setViewName("home");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	
	
	@RequestMapping("/customerjoinimpl.del")
	public ModelAndView register(ModelAndView mv, HttpServletRequest request) {
		String id=request.getParameter("CUSTOMER_ID");
		String pwd = request.getParameter("CUSTOMER_PWD");
		String name = request.getParameter("CUSTOMER_NM");
		String phone=request.getParameter("CUSTOMER_PHONE");
		String addr=request.getParameter("CUSTOMER_ADDR");
		String gender=request.getParameter("CUSTOMER_GD");
		String age=request.getParameter("CUSTOMER_AGE");
		Integer int_age=Integer.parseInt(age);
		
		Customer customer = new Customer(id, pwd, name, phone, addr, gender, int_age, 0);
		
		try {
			cbiz.register(customer);
		} catch (Exception e) {
			mv.addObject("join");
			e.printStackTrace();
		}
		mv.addObject("center","user/signin");
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/loginimpl.del")
	public ModelAndView login(ModelAndView mv, HttpServletRequest request,
			HttpSession session) {
		String id=request.getParameter("CUSTOMER_ID");
		String pwd = request.getParameter("CUSTOMER_PWD");
		
		Customer customer=new Customer();
		
		try {
			customer=cbiz.get(id);
			System.out.println(customer.toString());
			if(pwd.equals(customer.getCustomer_pwd())) {
				session.setAttribute("loginuser", customer);
				mv.addObject("center","user/shop");
				mv.setViewName("index");
			}else {
				mv.addObject("center", "user/signin");
				mv.setViewName("home");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;		
		
	}
	
}
