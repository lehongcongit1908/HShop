package com.eshop.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eshop.dao.CustomerDAO;
import com.eshop.entity.Customer;
import com.eshop.service.CookieService;
import com.eshop.service.MailerService;
import com.eshop.service.SessionService;
import com.eshop.service.UploadService;

@Controller
public class AccountController {
	@Autowired
	CustomerDAO dao;
	@Autowired
	SessionService session;
	@Autowired
	CookieService cookie;
	@Autowired
	UploadService upload;
	@Autowired
	MailerService mailer;
	
	
	
	
	
	
	
	
	@GetMapping("/account/login")
	public String login(Model model) {
		Map<String, String> user = cookie.getUser();
		model.addAttribute("form", user);
		return "account/login";
	}
	
	
	@PostMapping("/account/login")
	public String login(Model model,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam(name="remember", defaultValue = "false") boolean remember) {
		try {
			Customer user = dao.getOne(username);
			if(!user.getPassword().equals(password)) {
				model.addAttribute("message", "Sai mật khẩu!");
			}
			else if(!user.isActivated()){
				model.addAttribute("message", "Tài khoản chưa kích hoạt!");
			}
			else {
				model.addAttribute("message", "Đăng nhập thành công!");
				
				// Đăng nhập thành công thì đẩy user vào session
				session.setAttribute("user", user);
				
				// Ghi nhớ tài khoản bằng cookie
				if(remember) {
					cookie.setUser(username, password);
				}
				else {
					cookie.delete("user");
				}
				// Trở lại trang được bảo mật
				String authUri = session.getAttribute("auth-uri");
				if(authUri != null) {
					return "redirect:" + authUri;
				}
			}
		} catch (Exception e) {
			model.addAttribute("message", "Sai tên đăng nhập");
		}
		return "account/login";
	}
	@RequestMapping("/account/logoff")
	public String logoff() {
		session.removeAttribute("user");
		return "redirect:/home/index";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/account/register")
	public String register(Model model) {
		model.addAttribute("form", new Customer());
		return "account/register";
	}
	@PostMapping("/account/register")
	public String register(Model model, @ModelAttribute("form") Customer user, 
			@RequestParam("confirm") String confirm,
			@RequestParam("photo_file") MultipartFile photo,
			HttpServletRequest req) {
		if(!confirm.equals(user.getPassword())) {
			model.addAttribute("message", "Xác nhận mật khẩu không đúng!");
		}
		else {
			try {
				File file = upload.save(photo, "/static/images/users");
				user.setPhoto(file == null ? "user.png" : file.getName());
				dao.save(user);
				
				String url = req.getRequestURL().toString().replace("register", "activate/" + user.getId());
				String from = "Hồng Công <lehongcong.present@gmail.com>";
				String to = user.getEmail();
				String subject = "Welcome to Đại Phong helmet";
				String body = "Chúc mừng bạn đã trở thành thành viên của chúng tôi. <hr/>"
						+ "Vui lòng <a href='"+url+"'>click vào đây</a> để kích hoạt tài khoản trước khi sử dụng";
				mailer.send(from, to, subject, body);
				model.addAttribute("message", "Đăng ký thành công. Vui lòng kiểm tra email!");
			} catch (Exception e) {
				model.addAttribute("message", "Đăng ký thất bại!");
			}
		}
		return "account/register";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/account/activate/{id}")
	public String activate(@PathVariable("id") String username) throws UnsupportedEncodingException {
		Customer user = dao.getOne(username);
		user.setActivated(true);
		dao.save(user);
		return "redirect:/account/login?message=" + URLEncoder.encode("Đã kích hoạt tài khoản thành công!", "utf-8");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/account/forgot")
	public String forgot() {
		return "account/forgot";
	}
	@PostMapping("/account/forgot")
	public String forgot(Model model,
			@RequestParam("username") String username,
			@RequestParam("email") String email) {
		try {
			Customer user = dao.getOne(username);
			if(!user.getEmail().equals(email)) {
				model.addAttribute("message", "Sai email!");
			}
			else {
				String from = "Hồng Công <lehaidang.present@gmail.com>";
				String to = user.getEmail();
				String subject = "Mật khẩu của bạn";
				String body = "Đây là mật khẩu của bạn: " + user.getPassword();
				mailer.send(from, to, subject, body);
				return "redirect:/account/login?message=" + URLEncoder.encode("Mật khẩu đã được gửi qua email!", "utf-8");
			}
		} catch (Exception e) {
			model.addAttribute("message", "Tài khoản chưa tồn tại!");
		}
		return "account/forgot";
	}

	
	
	
	
	
	
	
	
	
	
	@GetMapping("/account/change")
	public String change() {
		return "account/change";
	}
	@PostMapping("/account/change")
	public String change(Model model,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("newpwd") String newpwd,
			@RequestParam("confirm") String confirm) {
		if(!newpwd.equals(confirm)) {
			model.addAttribute("message", "Xác nhận mật khẩu không đúng!");
		}
		else {
			try {
				Customer user = dao.getOne(username);
				if(!user.getPassword().equals(password)) {
					model.addAttribute("message", "Sai mật khẩu!");
				}
				else {
					user.setPassword(newpwd);
					dao.save(user);
					return "redirect:/account/login?message=" +URLEncoder.encode("Đổi mật khẩu thành công!", "utf-8");
				}
			} catch (Exception e) {
				model.addAttribute("message", "Tài khoản không tồn tại!");
			}
		}
		return "account/change";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@GetMapping("/account/edit")
	public String edit(Model model) {
		model.addAttribute("form", session.getAttribute("user"));
		return "account/edit";
	}
	@PostMapping("/account/edit")
	public String edit(Model model, @ModelAttribute("form") Customer user, 
			@RequestParam("photo_file") MultipartFile photo) {
		try {
			File file = upload.save(photo, "/static/images/users");
			if(file != null) {
				user.setPhoto(file.getName());
			}
			dao.save(user);
			model.addAttribute("message", "Cập nhật thành công. Vui lòng kiểm tra email!");
		} catch (Exception e) {
			model.addAttribute("message", "Cập nhật thất bại!");
		}
		return "account/edit";
	}
}
