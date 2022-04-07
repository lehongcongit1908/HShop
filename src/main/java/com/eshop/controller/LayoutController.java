package com.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshop.dao.CategoryDAO;
import com.eshop.dao.ProductDAO;
import com.eshop.entity.Category;
import com.eshop.entity.Product;
import com.eshop.service.CookieService;

@Controller
public class LayoutController {
	@Autowired
	CategoryDAO dao;
	@Autowired
	ProductDAO pdao;
	@Autowired
	CookieService cookie;
	
	@RequestMapping("/layout/cart/info")
	public String cartInfo() {
		return "user/layout/_cart-info";
	}
	
	@RequestMapping("/layout/aside/category")
	public String categoryList(Model model) {
		List<Category> list = dao.findAll();
		model.addAttribute("cates", list);
		return "user/layout/_aside-category";
	}
	
	@RequestMapping("/layout/aside/favorite")
	public String favoriteList(Model model) {
		List<Integer> ids = cookie.getFavoriteIds();
		List<Product> favos = pdao.findByIds(ids);
		model.addAttribute("favos", favos);
		return "user/layout/_aside-favorite";
	}
}
