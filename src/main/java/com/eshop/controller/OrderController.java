package com.eshop.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshop.bean.CartItem;
import com.eshop.dao.OrderDAO;
import com.eshop.dao.OrderDetailDAO;
import com.eshop.dao.ProductDAO;
import com.eshop.entity.Customer;
import com.eshop.entity.Order;
import com.eshop.entity.OrderDetail;
import com.eshop.entity.Product;
import com.eshop.service.SessionService;
import com.eshop.service.ShoppingCartService;

@Controller
public class OrderController {
	@Autowired
	ShoppingCartService cart;
	@Autowired
	SessionService session;
	@Autowired
	OrderDAO odao;
	@Autowired
	OrderDetailDAO ddao;
	@Autowired
	ProductDAO pdao;
	
	@RequestMapping("/order/checkout")
	public String checkout(Model model) {
		return "forward:/cart/view";
	}
	
	@RequestMapping("/order/purchase")
	public String purchase(Model model, Order order) {
		order.setAmount(cart.getAmount());
		Customer user = session.getAttribute("user");
		order.setCustomer(user);
		odao.save(order);
		
		Collection<CartItem> items = cart.getItems();
		for(CartItem item: items) {
			Product p = pdao.getOne(item.getId());
			OrderDetail detail = new OrderDetail();
			detail.setProduct(p);
			detail.setOrder(order);
			detail.setUnitPrice(item.getPrice());
			detail.setDiscount(item.getDisc());
			detail.setQuantity(item.getQty());
			ddao.save(detail);
		}
		cart.clear();
		return "redirect:/order/detail/"+order.getId();
	}

	@RequestMapping("/order/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Order order = odao.getOne(id);
		model.addAttribute("order", order);
		return "order/detail";
	}
	
	@RequestMapping("/order/cancel/{id}")
	public String cancel(@PathVariable("id") Integer id) {
		Order order = odao.getOne(id);
		order.setStatus(-1);
		odao.save(order);
		return "redirect:/order/list";
	}
	
	@RequestMapping("/order/list")
	public String list(Model model) {
		Customer user = session.getAttribute("user");
		List<Order> list = odao.findByCustomer(user);
		model.addAttribute("orders", list);
		return "order/list";
	}
	
	@RequestMapping("/order/items")
	public String purchasedItems(Model model) {
		Customer user = session.getAttribute("user");
		List<Product> list = pdao.findByCustomer(user);
		model.addAttribute("prods", list);
		return "order/items";
	}
	
	@ModelAttribute("status")
	public Map<Integer, String> getStatus(){
		Map<Integer, String> st = new HashMap<Integer, String>();
		st.put(0, "Mới");
		st.put(1, "Đang xác nhận");
		st.put(2, "Đã xác nhận");
		st.put(3, "Đang giao hàng");
		st.put(4, "Thành công");
		st.put(-1, "Đã hủy");
		return st;
	}
}
