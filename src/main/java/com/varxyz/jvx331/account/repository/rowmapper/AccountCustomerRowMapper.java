package com.varxyz.jvx331.account.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jvx331.account.domain.Account;
import com.varxyz.jvx331.account.domain.CheckingAccount;
import com.varxyz.jvx331.account.domain.SavingsAccount;
import com.varxyz.jvx331.customer.domain.Customer;



public class AccountCustomerRowMapper implements RowMapper<Account>{

	/**
	 * private static final String SELECT_ACCOUNT_CUSTOMER = 
			"SELECT a.aid, a.accountNum, a.accType, a.passwd, a.balance, "
			+ "a.interestRate, a.overAmount, a.regDate, c.cid, c.name, c.ssn "
			+ " FROM Account INNER JOIN Customer c ON a.customerId = c.cid";
	 */
	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = null;
		long aid = rs.getLong("aid");
		String accountNum = rs.getString("accountNum");
		char accountType = rs.getString("accType").charAt(0);
		String passwd = rs.getString("passwd");
		double balance = rs.getDouble("balance");
		double interestRate = rs.getDouble("interestRate");
		double overAmount = rs.getDouble("overAmount");
		Date regDate = rs.getTimestamp("regDate");
		
		
		Customer customer = new Customer();
		customer.setCid(rs.getLong("cid"));
		customer.setName(rs.getString("name"));
		customer.setSsn(rs.getString("ssn"));
		
		if(accountType == 'S') {
			account = new SavingsAccount();
			((SavingsAccount)account).setInterestRate(interestRate);
		}else {
			account = new CheckingAccount();
			((CheckingAccount)account).setOverdraftAmount(overAmount);
		}
		account.setAid(aid);
		account.setCustomer(customer);
		account.setAccountNum(accountNum);
		account.setAccountType(accountType);
		account.setPasswd(passwd);
		account.setBalance(balance);
		account.setRegDate(regDate);
		
		return account;
	}

}
