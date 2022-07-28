package com.varxyz.jvx331.account.domain;

import java.util.Date;

import com.varxyz.jvx331.customer.domain.Customer;
import com.varxyz.jvx331.exception.InsufficientBalanceException;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class Account {

	private long aid;
	protected Customer customer;
	
	protected String accountNum;		// 계좌 번호
	private char accountType;			// 계좌 종류
	protected double balance;			// 계좌 잔고 정보
	protected String passwd;			// 이체처리 시 추가 요구사항
	
	private Date regDate;
	
	/** 
	 * 계좌에 amount 크기의 금액을 입금한다. 
	 */
	public void deposit(double amount){
		balance += amount;
	}
	
	/**
	 * 계좌 출금
	 * @param amount
	 */
	public abstract void withdraw(double amount) throws InsufficientBalanceException;

}
