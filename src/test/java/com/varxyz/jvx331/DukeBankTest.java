package com.varxyz.jvx331;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


/**
 * 
 * @author Sage R Lee
 *
 */

@SpringJUnitConfig(classes = {
			com.varxyz.jvx331.config.WebMVCConfig.class
		})
@Transactional
@EnableTransactionManagement
@WebAppConfiguration
public class DukeBankTest {
	private long start;
	
	public void start(String methodName) {
		this.start = System.currentTimeMillis();
		System.out.println("\n\n-----------------------------------[" + methodName +"]\n");
	}
	
	public void end() {
		long end = System.currentTimeMillis();
		double processTime = (end - start)/1000.0;
		System.out.println("\n-----------------------------------[" + processTime + " sec]\n");
	}
}
