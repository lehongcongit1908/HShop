package com.eshop.admin.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
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
	@ResponseBody
	@RequestMapping("date")
	public String hi() {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		//Date t =  new Date();
		//t = s.format(t);
		
		Product	p = pdao.getOne(41);
		System.out.println(p.getProductDate());
		System.out.println(s.format(p.getProductDate()));
		return p.getProductDate().toString();
		//return s.format(t);
		//return t.toString(); 
	}
	
	@RequestMapping("date2")
	public String hi2(Model model) {
		Product	p = pdao.getOne(41);
		//
		//SimpleDateFormat s = new SimpleDateFormat("yyy/MM/dd");
		//Date d2 = new Date();
		//model.addAttribute("date",d.toString()) ;
		
		return "admin/product/date2";
	}
	
	
	
	
	
	
	
	
	@RequestMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Product bean = pdao.getOne(id);
		model.addAttribute("form", bean);
		System.out.println(bean.getId());
		String date = bean.getProductDate().toString();		
		System.out.println(date);
		model.addAttribute("date", date);
		List<Product> list = pdao.findAll();
		model.addAttribute("items", list);
		return "admin/product/index";
	}
	
	
	
	
	
	
	
	
	@RequestMapping("create")
	public String create(Model model, 
			@ModelAttribute("form") Product form,
			@RequestParam("image_file") MultipartFile image) {
		try {
			File file = upload.save(image, "/static/images/items");
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
			File file = upload.save(image, "/static/images/items");
			if(file != null){
				form.setImage(file.getName());
			}

			pdao.save(form);
			model.addAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			model.addAttribute("message", "Cập nhật thất bại!");
		}
		List<Product> list = pdao.findAll();
		model.addAttribute("form", list);
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
	
	
	
	
////String date = form.getProductDate().toString();	
////Date date2 = new SimpleDateFormat("yyyy-mm-dd").parse(date);
////form.setProductDate(date2);
////String date = form.getProductDate().toString();	
//
////String sDate = form.getProductDate().toString();
////SimpleDateFormat sd = new  SimpleDateFormat("yyyy-mm-dd");
//
////Date productdate = form.getProductDate();
////form.setProductDate(date2);
//
////System.out.println(sDate + "\t" + date);
////form.setProductDate(new Date());
//
////System.out.println(date);
//// Date date2 = new SimpleDateFormat("yyyy-mm-dd").parse(date);
////form.setProductDate(date2);
//
//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//
////String dateInString = "7-Jun-2013";
//Date date = formatter.parse(dateinput);
//form.setProductDate(date);
	
}
