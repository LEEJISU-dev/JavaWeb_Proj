package com.team.controller.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class MailSendComponent {

	public static Message message = null;

	public static void createMail(String UserId,String UPw, String Email) {
		MimeBodyPart mbp = new MimeBodyPart();
		try {
			// 메일 본문 작성
			// text 경우
			mbp.setText("ID : " + UserId + "\n" + "PW : " + UPw + "\n" + "必ずPWを変更してください。");

			// message 객체에 본문을 넣기 위하여 Multipart 객체 생성
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp);

			// 메일 제목 넣기
			message.setSubject(UserId+"様のアカウントの情報です。");

			// 메일 본문을 넣기
			message.setContent(mp);

			// 보내는 날짜
			message.setSentDate(new Date());

			// 보내는 메일 주소
			message.setFrom(new InternetAddress(Email));

			// 단건 전송일 때는 사용 start
			message.setRecipient(RecipientType.TO, new InternetAddress(Email));
			// 단건 전송일 때는 사용 end

			// 복수 건 전송일 때는 사용 start
			// InternetAddress[] receive_address = {new InternetAddress("보낼 사람의 메일 주소")};
			// message.setRecipients(RecipientType.TO, receive_address);
			// 복수 건 전송일 때는 사용 end

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void connectSMTP() {
		Properties prop = new Properties();

		// Gmail 연결을 위하여 아래 설정 적용
		// 사내 메일 망일 경우 smtp host 만 설정해도 됨 (특정 포트가 아닐경우)
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");

		// SMTP 서버 계정 정보 (GMail 용)
		MyAuthenticator authenticator = new MyAuthenticator("jslteamproject27", "xlavmfhwprxm");

		Session session = Session.getDefaultInstance(prop, authenticator);

		try {
			message = new MimeMessage(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendMail() {
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String UPw = null;
		String UserId = null;
		String Email = null;
		connectSMTP();
		createMail(UPw, UserId, Email);
		sendMail();
	}
}

class MyAuthenticator extends Authenticator {
	private String id;
	private String pw;

	public MyAuthenticator(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(id, pw);
	}
}
