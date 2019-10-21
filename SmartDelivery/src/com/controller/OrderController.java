package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
	@RequestMapping("/productorder.del")
	public ModelAndView productorder(ModelAndView mv) {
		mv.addObject("center", "user/order");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/orderdetail.del")
	public ModelAndView orderdetail(ModelAndView mv) {
		mv.addObject("center", "user/orderdetail");
		mv.setViewName("index");
		return mv;
	}
}
