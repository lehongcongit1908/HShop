package com.eshop.bean;

import lombok.Getter;
import lombok.Setter;
// Lớp dùng để nhận dữ liệu json. trong lúc chia sẻ sp qua email
@Getter @Setter
public class MailInfo {
	Integer id;
	String sender;
	String receiver;
	String subject;
	String content;
}
