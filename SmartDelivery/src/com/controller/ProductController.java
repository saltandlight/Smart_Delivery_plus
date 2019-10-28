package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.DependenciesBiz;
import com.vo.Product;

@Controller
public class ProductController {

	@Resource(name="pbiz")
	DependenciesBiz<String, Product> pbiz;
	
	@Autowired
	ServletContext servletContext;
	
	
	@RequestMapping("/productadd.del")
	public ModelAndView productadd(ModelAndView mv) {
		mv.addObject("center","user/productadd");
		mv.setViewName("index");
		return mv;
	}
	
	
	@RequestMapping("/productaddimpl.del")
	public ModelAndView productaddimpl(ModelAndView mv, HttpServletRequest request, Product product) {
		
		
		String product_pic1 =product.getMf().getOriginalFilename();

		product.setProduct_pic1(product_pic1);
		
		
		System.out.println(product.toString());
		try {
			Product product2 = pbiz.pidmaxselect();
			
			if(product2 != null) { //테이블이 비어있지 않다면--> 그대로 값을 증가시키면 되겠음
				System.out.println(product2.toString());
				String str_sub_id2=product2.getProduct_id();
				str_sub_id2=str_sub_id2.substring(3);
				int sub_id2=Integer.parseInt(str_sub_id2);
					  
				product.setSub_id2(sub_id2++);
				product.setProduct_id("PID"+sub_id2);
			}else {
				product.setSub_id2(1);
				product.setProduct_id("PID"+1);
			}
			
			pbiz.register(product);
			
//			String dir = servletContext.getRealPath("/view/user/images/");
//			System.out.println("dir:"+dir);
//			Util.saveFile(product.getMf(), dir);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
		
		mv.addObject("center","user/productadd");		
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/productlist.del")
	public ModelAndView productaddimpl(ModelAndView mv, ArrayList<Product> list) {

		
		try {
			list = pbiz.get();
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		mv.addObject("plist", list);
		mv.addObject("center","user/shop");
		mv.setViewName("index");
		return mv;
	}
}
