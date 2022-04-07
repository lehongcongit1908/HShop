package com.eshop;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailer = new JavaMailSenderImpl();
		mailer.setProtocol("smtp");
		mailer.setHost("smtp.gmail.com");
		mailer.setPort(587);
		mailer.setDefaultEncoding("utf-8");
		
		mailer.setUsername("lehongcong.present@gmail.com");
		mailer.setPassword("0379557096");

		Properties props = mailer.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		//props.put("mail.debug", "true");

		return mailer;
	}
}
