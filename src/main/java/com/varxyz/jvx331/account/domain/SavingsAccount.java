package com.varxyz.jvx331.account.domain;

import com.varxyz.jvx331.exception.InsufficientBalanceException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingsAccount extends Account{

	private double interestRate;
	
	/**
	 * 계좌에 amount 크기의 금액을 출금한다. 출금 성공시 true를 리턴한다. 
	 * 출금액이 입금액 보다 크면 출금 실패로 간주한다.
	 */
	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		if(balance - amount < 0){
			throw new InsufficientBalanceException("에러: 잔고부족", balance);
		}else{
			balance -= amount;
		}
	}
}
