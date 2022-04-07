package com.eshop.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class XJson {
	private static ObjectMapper mapper = new ObjectMapper();
	// Đưa Vào 1 chuỗi đổi ra thành 1 đối tượng
	public static <T> T toObject(String json, Class<T> clazz) {
		try {
			return mapper.readValue(json, clazz);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String toJson(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked") // thông báo là code đáng tin cậy k lỗi, chỉ để
	//hiển thị k có ảnh hưởng đến chạy
	public static Map<String, Object> toMap(String json) {
		return toObject(json, Map.class);
	}
	
	
	// Dùng hàm main để test
	
	public static void main(String[] args) {
		String [] l = {"Thiện","Sỹ","Công"};
		
		//		tạo 1 đối tượng map
		
		Map<String, Object> map  = new HashMap<>();
		map.put("Lý", 10);
		map.put("ngày", new Date());// lấy ngày hiện tại
		map.put("boss", 12);
		String jsonmap = XJson.toJson(map);
		String json = XJson.toJson(l);
		System.out.println(json);
		// ["Thiện","Sỹ","Công"] // đây là mã json
		
		System.out.println(jsonmap);
		//{"Lý":10,"ngày":1648694707828,"boss":12}
		
		
		//Đổi từ 1 chuỗi json sang object
		// Dòng này để biểu thị bên dưới đáng tin cậy, k lỗi, k hiện màu vàng
		@SuppressWarnings("unchecked")
		Map<String , Object> map2 = XJson.toObject(jsonmap, Map.class);
		// lấy 1 phẩn tử có key = Lý
		System.out.println(map2.get("Lý"));
		
		
		
	}
}
