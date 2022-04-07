package com.eshop.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshop.dao.ReportDAO;
import com.eshop.entity.Report;

@Controller
@CrossOrigin
@RequestMapping("/admin/report")
public class ReportAController {
	@Autowired
	ReportDAO dao;
	
	@RequestMapping("chart")
	public String chart(){
		return "admin/report/chart";
	}
	
	@RequestMapping("index")
	public String report(){
		return "admin/report/index";
	}
	
	@ResponseBody
	@RequestMapping("summary")
	public Map<Integer, Long> summary() {
		return dao.getSummary();
	}
	
	@ResponseBody
	@RequestMapping("{name}")
	public List<Report> report(@PathVariable("name") String name) {
		switch(name) {
		case "inventory-by-category":
			return dao.getInventoryByCategory();
		case "revenue-by-category":
			return dao.getRevenueByCategory();
		case "revenue-by-customer":
			return dao.getRevenueByCustomer(PageRequest.of(0, 10));
		case "revenue-by-year":
			return dao.getRevenueByYear();
		case "revenue-by-quarter":
			return dao.getRevenueByQuarter();
		default:
			return dao.getRevenueByMonth();
		}
	}
}