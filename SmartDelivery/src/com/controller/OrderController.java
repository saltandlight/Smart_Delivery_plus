package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.DependenciesBiz;
import com.vo.Product;

@Controller
public class OrderController {
	

	@Resource(name="pbiz")
	DependenciesBiz<String, Product> pbiz;
	
	@RequestMapping("/productorder.del")
	public ModelAndView productorder(HttpServletRequest request, ModelAndView mv, Product product, String product_id) {
		
		product_id = request.getParameter("product_id");		
		System.out.println(product_id);
		
		try {
			product=pbiz.get(product_id);
			System.out.println(product.toString());
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		mv.addObject("p", product);
		mv.addObject("center", "user/order");
		mv.setViewName("index");
		return mv;
	}
	
//
//	public String addcart(HttpServletRequest request, Cart cart, Double product_price, Integer product_no,
//			HttpSession session, Customer customer) {
//		ModelAndView mv = new ModelAndView();
//		
		
	@RequestMapping("/orderdetail.del")
	public ModelAndView orderdetail(ModelAndView mv) {
		mv.addObject("center", "user/orderdetail");
		mv.setViewName("index");
		return mv;
	}
	
	

}
