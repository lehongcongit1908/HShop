package com.eshop.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshop.dao.OrderDAO;
import com.eshop.entity.Order;

@Controller
@RequestMapping("/admin/order")
public class OrderAController {
	@Autowired
	OrderDAO odao;
	
	@RequestMapping("index")
	public String index(Model model) {
		Order bean = new Order();
		model.addAttribute("form", bean);
		
		List<Order> list = odao.findAll();
		model.addAttribute("items", list);
		
		return "admin/order/index";
	}
	
	@RequestMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Order bean = odao.getOne(id);
		model.addAttribute("form", bean);
		
		List<Order> list = odao.findAll();
		model.addAttribute("items", list);
		return "admin/order/index";
	}
	
	@RequestMapping("create")
	public String create(Model model, @ModelAttribute("form") Order form) {
		try {
			odao.save(form);
			model.addAttribute("message", "Thêm mới thành công!");
		} catch (Exception e) {
			model.addAttribute("message", "Thêm mới thất bại!");
		}
		List<Order> list = odao.findAll();
		model.addAttribute("items", list);
		return "admin/order/index";
	}
	
	@RequestMapping("update")
	public String update(Model model, @ModelAttribute("form") Order form) {
		try {
			odao.save(form);
			model.addAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			model.addAttribute("message", "Cập nhật thất bại!");
		}
		List<Order> list = odao.findAll();
		model.addAttribute("items", list);
		return "admin/order/index";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(Model model, @PathVariable("id") Integer id) {
		try {
			odao.deleteById(id);
			model.addAttribute("message", "Xóa thành công!");
		} catch (Exception e) {
			model.addAttribute("message", "Xóa thất bại!");
		}
		Order bean = new Order();
		model.addAttribute("form", bean);
		List<Order> list = odao.findAll();
		model.addAttribute("items", list);
		return "admin/order/index";
	}
	
	@ModelAttribute("status")
	public Map<Integer, String> getStatuses(){
		Map<Integer, String> map = new HashMap<>();
		map.put(-1, "Canceled");
		map.put(0, "New");
		map.put(1, "Confirming");
		map.put(2, "Confirmed");
		map.put(3, "Shipping");
		map.put(4, "Completed");
		return map;
	}
}
