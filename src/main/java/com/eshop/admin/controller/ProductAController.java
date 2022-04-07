package com.eshop.admin.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eshop.dao.CategoryDAO;
import com.eshop.dao.ProductDAO;
import com.eshop.entity.Category;
import com.eshop.entity.Product;
import com.eshop.service.UploadService;

@Controller
@RequestMapping("/admin/product")
public class ProductAController {
	@Autowired
	ProductDAO pdao;
	@Autowired
	UploadService upload;
	
	@RequestMapping("index")
	public String index(Model model) {
		Product bean = new Product();
		model.addAttribute("form", bean);
		
		List<Product> list = pdao.findAll();
		model.addAttribute("items", list);
		
		return "admin/product/index";
	}
	
	@RequestMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Product bean = pdao.getOne(id);
		model.addAttribute("form", bean);
		
		List<Product> list = pdao.findAll();
		model.addAttribute("items", list);
		return "admin/product/index";
	}
	
	@RequestMapping("create")
	public String create(Model model, 
			@ModelAttribute("form") Product form,
			@RequestParam("image_file") MultipartFile image) {
		try {
			File file = upload.save(image, "/static/images/users");
			form.setImage(file == null ? "item.png" : file.getName());
			pdao.save(form);
			model.addAttribute("message", "Thêm mới thành công!");
		} catch (Exception e2) {
			model.addAttribute("message", "Thêm mới thất bại!");
		}
		
		List<Product> list = pdao.findAll();
		model.addAttribute("items", list);
		return "admin/product/index";
	}
	
	@RequestMapping("update")
	public String update(Model model, 
			@ModelAttribute("form") Product form,
			@RequestParam("image_file") MultipartFile image) {
		try {
			File file = upload.save(image, "/static/images/users");
			if(file != null){
				form.setImage(file.getName());
			}
			pdao.save(form);
			model.addAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			model.addAttribute("message", "Cập nhật thất bại!");
		}
		List<Product> list = pdao.findAll();
		model.addAttribute("items", list);
		return "admin/product/index";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(Model model, @PathVariable("id") Integer id) {
		try {
			pdao.deleteById(id);
			model.addAttribute("message", "Xóa thành công!");
		} catch (Exception e) {
			model.addAttribute("message", "Xóa thất bại!");
		}
		Product bean = new Product();
		model.addAttribute("form", bean);
		List<Product> list = pdao.findAll();
		model.addAttribute("items", list);
		return "admin/product/index";
	}
	
	@Autowired
	CategoryDAO cdao;
	@ModelAttribute("cates")
	public List<Category> getCategories(){
		return cdao.findAll();
	}
}
