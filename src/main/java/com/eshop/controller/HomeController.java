package com.eshop.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = { "/", "/home/index" }, method = RequestMethod.GET)
	public String index(Model model, @RequestParam("p") Optional<Integer> p) {
		List<Category> list = cdao.findAll();
//		Collections.shuffle(list);
//		list =  list.subList(0, 4);
//		for(Category cate: list) {
//			Collections.shuffle(cate.getProducts());
//			cate.setProducts(cate.getProducts().subList(0, 4));
//		}
		Pageable pageable = PageRequest.of(p.orElse(0), 9);// số trang, số lượng phần tử

		Page<Product> page = pdao.findAll(pageable);
				

		model.addAttribute("prods", page);
		//model.addAttribute("list", list);

		//List<Product> prods = pdao.findBySpecial();
		//model.addAttribute("prods", prods);

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
	public void lang() {
	}
}
