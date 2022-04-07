package com.eshop.utils;

import java.util.Map;
import java.util.TreeMap;

public class OrderStatus{
	public static Map<Integer, String> getOrderStatus(){
		Map<Integer, String> map = new TreeMap<>();
		map.put(0, "New");
		map.put(1, "Confirming");
		map.put(2, "Confirmed");
		map.put(3, "Shipping");
		map.put(4, "Completed");
		map.put(-1, "Cancel");
		return map;
	}
}