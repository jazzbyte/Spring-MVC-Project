package com.varxyz.jvx331.exception;

public class InsufficientBalanceException extends RuntimeException{
	
	private double balance;
	
	public InsufficientBalanceException(String msg, double balance){
		super(msg);
		this.balance = balance;
	}
	
	@Override
	public String getMessage(){
		return super.getMessage()+": 현재 잔고는 "+ balance +"원 입니다.";
	}
	
	private static final long serialVersionUID = -4939796074126325623L;
}
