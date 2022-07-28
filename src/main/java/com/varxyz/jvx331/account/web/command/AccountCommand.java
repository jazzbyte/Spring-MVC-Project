package com.varxyz.jvx331.account.web.command;

import java.util.Date;

import com.varxyz.jvx331.customer.web.command.CustomerCommand;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AccountCommand {
	
	protected String accountNum;
	protected double balance;
	protected String passwd;
	protected char accountType;
	protected Date openDate;
	protected CustomerCommand customer;
	
	public AccountCommand() {
	
	}
	
	public AccountCommand(String accountNum, double balance, String passwd,
			char accountType, Date openDate, CustomerCommand customer) {
		this.accountNum = accountNum;
		this.balance = balance;
		this.passwd = passwd;
		this.accountType = accountType;
		this.openDate = openDate;
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "Account [accountNum=" + accountNum + ", balance=" + balance
				+ ", passwd=" + passwd + ", accountType=" + accountType
				+ ", openDate=" + openDate + ", customer=" + customer + "]";
	}
	

}
