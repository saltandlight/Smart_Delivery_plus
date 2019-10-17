package com.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vo.Product;

@Controller
public class OrderController {
	@RequestMapping("/order.del")
	public ModelAndView productorder(ModelAndView mv) {
		mv.addObject("center", "user/checkout");
		mv.setViewName("index");
		return mv;
	}
}
