package com.varxyz.jvx331.account.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.varxyz.jvx331.account.domain.Account;
import com.varxyz.jvx331.account.domain.CheckingAccount;
import com.varxyz.jvx331.account.domain.SavingsAccount;
import com.varxyz.jvx331.account.repository.AccountRepository;
import com.varxyz.jvx331.account.repository.rowmapper.AccountCustomerRowMapper;
import com.varxyz.jvx331.account.repository.rowmapper.AccountRowMapper;


@Repository("accountRepository")
public class AccountSpringJdbcImpl implements AccountRepository{

private JdbcTemplate jdbcTemplate;

	private static final String SELECT_ACCOUNT = 
			"SELECT aid, customerId, accountNum, accType, passwd, balance, "
			+ "interestRate, overAmount, regDate FROM Account";
	
	private static final String SELECT_ACCOUNT_CUSTOMER = 
			"SELECT a.aid, a.accountNum, a.accType, a.passwd, a.balance, "
			+ "a.interestRate, a.overAmount, a.regDate, c.cid, c.name, c.ssn "
			+ " FROM Account a INNER JOIN Customer c ON a.customerId = c.cid";
	
	private static final String INSERT_ACCOUNT = 
			"INSERT INTO Account(accountNum, accType, passwd, balance, "
					+ " interestRate, overAmount, customerId) "
					+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	private static final String UPDATE_ACCOUNT_BALANCE = 
			"UPDATE Account SET balance = ? WHERE accountNum = ?";

	@Autowired
	public AccountSpringJdbcImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public Account save(Account account) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			SavingsAccount sa = null;
			CheckingAccount ca = null;
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) 
														throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						INSERT_ACCOUNT, new String[] {"aid"});
				
				pstmt.setString(1, account.getAccountNum());
				pstmt.setString(2, String.valueOf(account.getAccountType()));
				pstmt.setString(3, account.getPasswd());
				pstmt.setDouble(4, account.getBalance());
				if(account instanceof SavingsAccount) {
					sa = (SavingsAccount)account;
					pstmt.setDouble(5, sa.getInterestRate());
					pstmt.setDouble(6, 0.0);
					
				}else {
					ca = (CheckingAccount)account;
					pstmt.setDouble(5, 0.0);
					pstmt.setDouble(6, ca.getOverdraftAmount());
				}
				pstmt.setLong(7, account.getCustomer().getCid());
				return pstmt;
			}
		}, keyHolder);
		
		account.setAid(keyHolder.getKey().longValue());
		return account;
	}

	@Override
	public Account findByAccountNum(String accountNum) {
		StringBuilder sql = new StringBuilder(SELECT_ACCOUNT_CUSTOMER);
		sql.append(" WHERE accountNum = ?");
		return jdbcTemplate.queryForObject(sql.toString(), 
							new AccountCustomerRowMapper(), accountNum);
	}


	@Override
	public List<Account> findByCustomerId(long customerId) {
		StringBuilder sql = new StringBuilder(SELECT_ACCOUNT);
		sql.append(" WHERE customerId = ?");
		return jdbcTemplate.query(sql.toString(), 
							new AccountRowMapper(), customerId);
	}


	@Override
	public List<Account> findAll() {
		return jdbcTemplate.query(SELECT_ACCOUNT, new AccountRowMapper());
	}


	@Override
	public void updateBalance(double balance, String accountNum) {
		jdbcTemplate.update(UPDATE_ACCOUNT_BALANCE, balance, accountNum);
	}
}
