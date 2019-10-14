package com.ja.mlproject.util;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailUtils {
	
	private JavaMailSender mailSender;
	private MimeMessage message;
	private MimeMessageHelper messageHelper;
	
	// 생성자
	public MailUtils(JavaMailSender mailSender) {
		this.mailSender = mailSender;
		message = this.mailSender.createMimeMessage();
		try {
			messageHelper = new MimeMessageHelper(message, true, "UTF-8");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	// 제목 설정
	public void setSubject(String subject) {
		try {
			messageHelper.setSubject(subject);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	// 내용 설정
	public void setText(String htmlContent) {
		try {
			messageHelper.setText(htmlContent, true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	// 발신자 설정
	public void setFrom(String email, String name) {
		try {
			messageHelper.setFrom(email, name);
		} catch (UnsupportedEncodingException | MessagingException e) {
			e.printStackTrace();
		}
	}
	
	// 수신자 설정
	public void setTo(String email) {
		try {
			messageHelper.setTo(email);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	// 내장 리소스(?)
	public void addInline(String contentId, DataSource dataSource) {
		try {
			messageHelper.addInline(contentId, dataSource);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public void send() {
		mailSender.send(message);
	}
	
}
