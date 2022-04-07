package com.eshop.admin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshop.dao.CategoryDAO;
import com.eshop.entity.Category;

@Controller
@RequestMapping("/admin/category")
public class CategoryAController {
	@Autowired
	CategoryDAO cdao;
	
	@RequestMapping("index")
	public String index(Model model) {
		Category bean = new Category();
		model.addAttribute("form", bean);
		
		List<Category> list = cdao.findAll();
		model.addAttribute("items", list);
		
		return "admin/category/index";
	}
	
	@RequestMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Category bean = cdao.getOne(id);
		model.addAttribute("form", bean);
		
		List<Category> list = cdao.findAll();
		model.addAttribute("items", list);
		return "admin/category/index";
	}
	
	@RequestMapping("create")
	public String create(Model model, 
			@Valid @ModelAttribute("form") Category form,
			BindingResult errors) {
		try {
			if(errors.hasErrors()) {
				model.addAttribute("message", "Vui lòng sửa lỗi sau!");
			}
			else {
				cdao.save(form);
				model.addAttribute("message", "Thêm mới thành công!");
			}
		} catch (Exception e) {
			model.addAttribute("message", "Thêm mới thất bại!");
		}
		List<Category> list = cdao.findAll();
		model.addAttribute("items", list);
		return "admin/category/index";
	}
	
	@RequestMapping("update")
	public String update(Model model, @ModelAttribute("form") Category form) {
		try {
			cdao.save(form);
			model.addAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			model.addAttribute("message", "Cập nhật thất bại!");
		}
		List<Category> list = cdao.findAll();
		model.addAttribute("items", list);
		return "admin/category/index";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(Model model, @PathVariable("id") Integer id) {
		try {
			cdao.deleteById(id);
			model.addAttribute("message", "Xóa thành công!");
		} catch (Exception e) {
			model.addAttribute("message", "Xóa thất bại!");
		}
		Category bean = new Category();
		model.addAttribute("form", bean);
		List<Category> list = cdao.findAll();
		model.addAttribute("items", list);
		return "admin/category/index";
	}
}
