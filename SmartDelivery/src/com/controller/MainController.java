package com.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/customermain.del")
	public ModelAndView main(ModelAndView mv){
		
		mv.addObject("center","center");
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/customerjoin.del")
	public ModelAndView customerjoin(ModelAndView mv) {
		mv.addObject("center","user/signup");
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/customerlogin.del")
	public ModelAndView customerlogin(ModelAndView mv) {
		mv.addObject("center","user/signin");
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/customershop.del")
	public ModelAndView shop(ModelAndView mv) {
		mv.addObject("center","user/shop");
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/customerwish.del")
	public ModelAndView wishlist(ModelAndView mv) {
		mv.addObject("center","user/wishlist");
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/customerproduct.del")
	public ModelAndView product_single(ModelAndView mv) {
		mv.addObject("center","user/product-single");
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/customercart.del")
	public ModelAndView cart(ModelAndView mv) {
		mv.addObject("center","user/cart");
		mv.setViewName("home");
		return mv;
	}
	
	
	@RequestMapping("/customercheck.del")
	public ModelAndView checkout(ModelAndView mv) {
		mv.addObject("center","user/checkout");
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/customerabout.del")
	public ModelAndView about(ModelAndView mv) {
		mv.addObject("center","user/about");
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/customerblog.del")
	public ModelAndView blog(ModelAndView mv) {
		mv.addObject("center","user/blog");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/customerdelcheck.del")
	public ModelAndView deliverycheck(ModelAndView mv) {
		mv.addObject("center","user/deliverycheck");
		mv.setViewName("index");
		return mv;
	}
	
	
	
}
