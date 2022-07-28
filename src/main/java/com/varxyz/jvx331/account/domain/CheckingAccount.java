package com.varxyz.jvx331.account.domain;


import com.varxyz.jvx331.exception.OverdraftException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckingAccount extends Account{
	private double overdraftAmount;
	
	@Override
	public void withdraw(double amount) throws OverdraftException{

		if(balance - amount < 0){
			double overdraftNeeded = amount - balance;
			
			if (overdraftAmount < overdraftNeeded) {
				System.out.println("금액초과:잔고="+balance);
				System.out.println("금액초과:출금액="+amount);
				System.out.println("금액초과:잔여 대월액="+(overdraftAmount));
				throw new OverdraftException("에러: 대월금 초과", 
						balance,overdraftAmount );
			} else {
				balance = overdraftNeeded*-1.0;
				overdraftAmount = overdraftAmount - overdraftNeeded;
			}
		}else{
			balance -= amount;
		}
	}
	
}
