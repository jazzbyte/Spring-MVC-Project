package com.varxyz.jvx331.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 
 * @author Sage R Lee
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.varxyz.jvx331")
public class WebMVCConfig implements WebMvcConfigurer {
	

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}
	
	//[DataSource]----------------------------------------------
	/**
	 * DataSource 설정
	 * 
	 * @return
	 */
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jvx330?serverTimezone=Asia/Seoul");
		ds.setUsername("jvx330");
		ds.setPassword("jvx330");
		
		ds.setInitialSize(2);		//커넥션 풀 초기화시 생성할 초기 커넥션 개수 (기본값 10)
		ds.setMaxActive(10);		//풀에서 가져올 수 있는 최대 커넥션 개수 (기본값 100)
		ds.setMaxIdle(10);			//풀에 유지할 수 있는 최대 커넥션 개수 (기본값 maxActive와 동일)
		
		return ds;
	}
}
