package com.varxyz.jvx331.customer.repository.impl;

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

import com.varxyz.jvx331.customer.domain.Customer;
import com.varxyz.jvx331.customer.repository.CustomerRepository;
import com.varxyz.jvx331.customer.repository.rowmapper.CustomerRowMapper;

@Repository("customerRepository")
public class CustomerSpringJdbcImpl implements CustomerRepository{
	
	private static final String SELECT_CUSTOMER = 
			"SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";
	
	private static final String INSERT_CUSTOMER = 
			"INSERT INTO Customer(email, passwd, name, ssn, phone) "
			+ " VALUES(?, ?, ?, ?, ?)";
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CustomerSpringJdbcImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Customer save(Customer customer) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) 
														throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
									INSERT_CUSTOMER, new String[] {"cid"});
				pstmt.setString(1, customer.getEmail());
				pstmt.setString(2, customer.getPasswd());
				pstmt.setString(3, customer.getName());
				pstmt.setString(4, customer.getSsn());
				pstmt.setString(5, customer.getPhone());
				
				return pstmt;
			}
		}, keyHolder);
		customer.setCid(keyHolder.getKey().longValue());
		return customer;
	}

	@Override
	public Customer findBySsn(String ssn) {
		StringBuilder sql = new StringBuilder(SELECT_CUSTOMER);
		sql.append(" WHERE ssn = ?");
		return jdbcTemplate.queryForObject(sql.toString(), 
							new CustomerRowMapper(), ssn);
	}

	@Override
	public List<Customer> findByPhone(String phone) {
		StringBuilder sql = new StringBuilder(SELECT_CUSTOMER);
		sql.append(" WHERE phone = ?");
		return jdbcTemplate.query(sql.toString(), new CustomerRowMapper(), phone);
	}

	@Override
	public List<Customer> findAll() {
		String sql = SELECT_CUSTOMER;
		return jdbcTemplate.query(sql, new CustomerRowMapper());
	}

	@Override
	public Customer findByEmail(String email) {
		StringBuilder sql = new StringBuilder(SELECT_CUSTOMER);
		sql.append(" WHERE email = ?");
		return jdbcTemplate.queryForObject(sql.toString(), new CustomerRowMapper(), email);
	}
	

}
