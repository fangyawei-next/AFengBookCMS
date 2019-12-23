package com.book.common;

public class EmailCode {
	//收件人
	private String addressee;
	//发件人
	private String sender="206323705@qq.com";
	//字符类型
	private String charset = "UTF-8";
	//邮箱的SMTP服务器
	private String serverSMTP = "smtp.qq.com";
	//授权码
	private String authorizationCode="rmmnxblkisbhbgda";
	//用户名
	private String username = "方亚伟";
	//主题
	private String theme = "图书管理系统验证码";
	//内容开始
	private String messageStart;
	//内容开始
	private String messageEnd;
	//内容
	private String message;
	
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	public String getServerSMTP() {
		return serverSMTP;
	}
	public void setServerSMTP(String serverSMTP) {
		this.serverSMTP = serverSMTP;
	}
	public String getAuthorizationCode() {
		return authorizationCode;
	}
	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getMessageStart() {
		return messageStart;
	}
	public void setMessageStart(String messageStart) {
		this.messageStart = messageStart;
	}
	public String getMessageEnd() {
		return messageEnd;
	}
	public void setMessageEnd(String messageEnd) {
		this.messageEnd = messageEnd;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message,String message2) {
		this.messageStart = message;
		this.messageEnd = message2;
	}
	
	//收件人,授权码,内容开始,内容结尾
	public EmailCode(String addressee, String authorizationCode, String messageStart, String messageEnd) {
		super();
		this.addressee = addressee;
		this.authorizationCode = authorizationCode;
		this.messageStart = messageStart;
		this.messageEnd = messageEnd;
	}
	//收件人,发件人,字符类型,发件人,邮箱的SMTP服务器,授权码,用户名,主题,内容开始,内容结束
	public EmailCode(String addressee, String sender, String charset, String serverSMTP, String authorizationCode,
			String username, String theme, String messageStart, String messageEnd) {
		super();
		this.addressee = addressee;
		this.sender = sender;
		this.charset = charset;
		this.serverSMTP = serverSMTP;
		this.authorizationCode = authorizationCode;
		this.username = username;
		this.theme = theme;
		this.messageStart = messageStart;
		this.messageEnd = messageEnd;
	}
	//收件人,内容开始,内容结尾
	public EmailCode(String addressee, String messageStart, String messageEnd) {
		super();
		this.addressee = addressee;
		this.messageStart = messageStart;
		this.messageEnd = messageEnd;
	}
	public EmailCode() {
		super();
	}
}
