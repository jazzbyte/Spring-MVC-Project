package com.varxyz.jvx331.customer.web.controller;

public class EmailProvider {
	private String emailCode;
	private String emailHost;
	
	public EmailProvider(String emailCode, String emailHost) {
		super();
		this.emailCode = emailCode;
		this.emailHost = emailHost;
	}
	
	public String getEmailCode() {
		return emailCode;
	}
	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}
	public String getEmailHost() {
		return emailHost;
	}
	public void setEmailHost(String emailHost) {
		this.emailHost = emailHost;
	}
	
	
}
