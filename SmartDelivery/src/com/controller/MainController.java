package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/customermain.del")
	public ModelAndView main(ModelAndView mv){
		mv.addObject("navi","navi");
		mv.addObject("footer","footer");
		mv.addObject("center", "index");
		mv.addObject("entire", "entire");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/customerjoin.del")
	public ModelAndView customerjoin(ModelAndView mv) {
		mv.setViewName("user/join");
		return mv;
	}
	
	@RequestMapping("/customerlogin.del")
	public ModelAndView customerlogin(ModelAndView mv) {
		mv.setViewName("user/login");
		return mv;
	}
	
	@RequestMapping("/customershop.del")
	public ModelAndView shop(ModelAndView mv) {
		mv.setViewName("user/shop");
		return mv;
	}
	
	@RequestMapping("/customerwish.del")
	public ModelAndView wishlist(ModelAndView mv) {
		mv.setViewName("user/wishlist");
		return mv;
	}
	
	@RequestMapping("/customerproduct.del")
	public ModelAndView product_single(ModelAndView mv) {
		mv.setViewName("user/product-single");
		return mv;
	}
	
	@RequestMapping("/customercart.del")
	public ModelAndView cart(ModelAndView mv) {
		mv.setViewName("user/cart");
		return mv;
	}
	
	
	@RequestMapping("/customercheck.del")
	public ModelAndView checkout(ModelAndView mv) {
		mv.setViewName("user/checkout");
		return mv;
	}
	
	@RequestMapping("/customerabout.del")
	public ModelAndView about(ModelAndView mv) {
		mv.setViewName("user/about");
		return mv;
	}
	
	@RequestMapping("/customerblog.del")
	public ModelAndView blog(ModelAndView mv) {
		mv.setViewName("user/blog");
		return mv;
	}
	
	@RequestMapping("/customerdelcheck.del")
	public ModelAndView deliverycheck(ModelAndView mv) {
		mv.setViewName("user/deliverycheck");
		return mv;
	}
}
