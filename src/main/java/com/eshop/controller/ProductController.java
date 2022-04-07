package com.eshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshop.bean.MailInfo;
import com.eshop.dao.ProductDAO;
import com.eshop.entity.Product;
import com.eshop.service.CookieService;
import com.eshop.service.MailerService;

@Controller
public class ProductController {
	@Autowired
	ProductDAO pdao;
	@Autowired
	CookieService cookie;
	@Autowired
	MailerService mailer;
	
	@RequestMapping("/product/find-by-category/{id}")
	public String listByCategory(Model model, @PathVariable("id") Integer categoryId) {
		List<Product> list = pdao.findAllByCategory(categoryId);
		model.addAttribute("prods", list);
		return "product/list";
	}
	
	@RequestMapping("/product/find-by-keywords")
	public String listByKeywords(Model model, @RequestParam("keywords") String keywords) {
		List<Product> list = pdao.findByKeywords(keywords);
		model.addAttribute("prods", list);
		return "product/list";
	}
	
	@RequestMapping("/product/find-by-special/{special}")
	public String listBySpecials(Model model, @PathVariable("special") Integer special) {
		List<Product> list;
		switch(special) {
		case 0: // best sellers
			list = pdao.findByBestSellers(PageRequest.of(0, 9));
			break;
		case 1: // latest
			list = pdao.findByLatest();
			break;
		case 2: // sales off
			list = pdao.findBySalesOff(PageRequest.of(0, 9));
			break;
		case 3: // most viewed
			list = pdao.findByMostViewed(PageRequest.of(0, 9));
			break;
		case 4: // special
			list = pdao.findBySpecial();
			break;
		default:
			list = pdao.findAll();
		}
		model.addAttribute("prods", list);
		return "product/list";
	}
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product p = pdao.getOne(id);
		// Tăng số lần xem
		p.setClickCount(p.getClickCount() + 1);
		pdao.save(p);
		
		// Ghi nhận các mặt hàng đã xem
		List<Integer> ids = cookie.getVisitedIds();
		if(!ids.contains(id)) {
			ids.add(id);
			cookie.setVisitedIds(ids);
		}
		// Truy vấn các mặt hàng đã xem
		List<Product> visits = pdao.findByIds(ids);
		model.addAttribute("visits", visits);
		
		model.addAttribute("prod", p);
		return "product/detail";
	}
	
	@ResponseBody
	@RequestMapping("/product/share/{id}")
	public void share(@PathVariable("id") Integer id, MailInfo mail, HttpServletRequest req) {
		String link = req.getRequestURL().toString().replace("share", "detail");
		String body = mail.getContent() + "<hr/>Vui lòng <a href='"+link+"'>Click</a> để xem chi tiết";
		mailer.send(mail.getSender(), mail.getReceiver(), mail.getSubject(), body);
	}
	
	@RequestMapping("/product/like/{id}")
	public String like(@PathVariable("id") Integer id) {
		List<Integer> ids = cookie.getFavoriteIds();
		if(!ids.remove(id)) {
			ids.add(id);
		}
		cookie.setFavoriteIds(ids);
		return "redirect:/layout/aside/favorite";
	}
}