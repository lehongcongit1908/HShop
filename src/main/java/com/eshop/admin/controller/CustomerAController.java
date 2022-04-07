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

import com.eshop.dao.CustomerDAO;
import com.eshop.entity.Customer;
import com.eshop.service.UploadService;

@Controller
@RequestMapping("/admin/customer")
public class CustomerAController {
	@Autowired
	CustomerDAO cdao;
	@Autowired
	UploadService upload;
	
	@RequestMapping("index")
	public String index(Model model) {
		Customer bean = new Customer();
		model.addAttribute("form", bean);
		
		List<Customer> list = cdao.findAll();
		model.addAttribute("items", list);
		
		return "admin/customer/index";
	}
	
	@RequestMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		Customer bean = cdao.getOne(id);
		model.addAttribute("form", bean);
		
		List<Customer> list = cdao.findAll();
		model.addAttribute("items", list);
		return "admin/customer/index";
	}
	
	@RequestMapping("create")
	public String create(Model model, 
			@ModelAttribute("form") Customer form,
			@RequestParam("photo_file") MultipartFile photo,
			@RequestParam("confirm") String confirm) {
		if(!form.getPassword().equals(confirm)) {
			model.addAttribute("message", "Xác nhận mật khẩu không đúng!");
		}
		else {
			try {
				Customer user = cdao.getOne(form.getId());
				model.addAttribute("message", "Username đã được sử dụng!");
			} catch (Exception e1) {
				try {
					File file = upload.save(photo, "/static/images/users");
					form.setPhoto(file == null ? "user.png" : file.getName());
					cdao.save(form);
					model.addAttribute("message", "Thêm mới thành công!");
				} catch (Exception e2) {
					model.addAttribute("message", "Thêm mới thất bại!");
				}
			}
		}
		
		List<Customer> list = cdao.findAll();
		model.addAttribute("items", list);
		return "admin/customer/index";
	}
	
	@RequestMapping("update")
	public String update(Model model, 
			@ModelAttribute("form") Customer form,
			@RequestParam("photo_file") MultipartFile photo) {
		try {
			File file = upload.save(photo, "/static/images/users");
			if(file != null){
				form.setPhoto(file.getName());
			}
			cdao.save(form);
			model.addAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			model.addAttribute("message", "Cập nhật thất bại!");
		}
		List<Customer> list = cdao.findAll();
		model.addAttribute("items", list);
		return "admin/customer/index";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(Model model, @PathVariable("id") String id) {
		try {
			cdao.deleteById(id);
			model.addAttribute("message", "Xóa thành công!");
		} catch (Exception e) {
			model.addAttribute("message", "Xóa thất bại!");
		}
		Customer bean = new Customer();
		model.addAttribute("form", bean);
		List<Customer> list = cdao.findAll();
		model.addAttribute("items", list);
		return "admin/customer/index";
	}
}
