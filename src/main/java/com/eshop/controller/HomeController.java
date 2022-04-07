package com.eshop.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshop.dao.CategoryDAO;
import com.eshop.dao.ProductDAO;
import com.eshop.entity.Category;
import com.eshop.entity.Product;

@Controller
public class HomeController {
	@Autowired
	CategoryDAO cdao;
	@Autowired
	ProductDAO pdao;
	
	@RequestMapping({"/", "/home/index"})
	public String index(Model model) {
		List<Category> list = cdao.findAll();
		Collections.shuffle(list);
		list =  list.subList(0, 4);
		for(Category cate: list) {
			Collections.shuffle(cate.getProducts());
			cate.setProducts(cate.getProducts().subList(0, 4));
		}
		model.addAttribute("list", list);
		
		List<Product> prods = pdao.findBySpecial();
		model.addAttribute("prods", prods);
		
		return "home/index";
	}
	
	@RequestMapping("/home/about")
	public String about() {
		return "home/about";
	}
	
	@RequestMapping("/home/contact")
	public String contact() {
		return "home/contact";
	}
	
	@RequestMapping("/home/feedback")
	public String feedback() {
		return "home/feedback";
	}
	
	@RequestMapping("/home/layout")
	public String faq() {
		return "home/layout";
	}
	
	@ResponseBody
	@RequestMapping("/home/lang")
	public void lang() {}
}
