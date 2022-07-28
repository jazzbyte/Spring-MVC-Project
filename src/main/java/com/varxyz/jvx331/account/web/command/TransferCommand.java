package com.varxyz.jvx331.account.web.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransferCommand {
	private String fromAccountNum;
	private String toAccountNum;
	private String receiver;
	private double amount;
	private String passwd;
	
}
