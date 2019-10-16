package com.controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Product;

@Controller
public class ProductController {

	@Resource(name="pbiz")
	Biz<String,Product> pbiz;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("/productaddimpl.del")
	public ModelAndView productaddimpl(ModelAndView mv, HttpServletRequest request, Product product) {
		
		
		String product_pic1 =product.getMf().getOriginalFilename();

		product.setProduct_pic1(product_pic1);

		try {
			pbiz.register(product);
			
			String dir = servletContext.getRealPath("/images/");
			Util.saveFile(product.getMf(), dir);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
		
		mv.addObject("center","center");		
		mv.setViewName("index");
		return mv;
	}
	
}
