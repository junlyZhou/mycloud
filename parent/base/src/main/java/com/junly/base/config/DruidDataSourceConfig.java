package com.junly.base.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
public class DruidDataSourceConfig {
	//初始化连接池到数量
	@Value("${spring.datasource.initialSize}")
	private int initialSize;

	//最小空闲链接
	@Value("${spring.datasource.minIdle}")
	private int minIdle;
	
	//最大连接数量
	@Value("${spring.datasource.maxActive}")
	private int maxActive;
	
	//主数据源的配置
	@Value("${spring.datasource.master.driverClassName}")
	private String masterDriverClass ;
	
	@Value("${spring.datasource.master.url}")
	private String masterurl;
	
	@Value("${spring.datasource.master.username}")
	private String masterUsername;
	
	//其他数据源的配置
	@Value("${spring.datasource.slaver.driverClassName}")
	private String slaverDriverClass ;

	@Value("${spring.datasource.slaver.url}")
	private String slaverurl;
	
	@Value("${spring.datasource.slaver.username}")
	private String slaverUsername;
	
	@Bean(name = "masterDataSource")
	@Qualifier("masterDataSource")
	@Primary
	public DataSource masterDataSource() {
		return createDataSource(masterDriverClass,masterUsername,masterurl);
	}
	
	@Bean(name = "slaverDataSource")
	@Qualifier("slaverDataSource")
	public DataSource slaverDataSource() {
		return createDataSource(slaverDriverClass,slaverUsername,slaverurl);
	}
	
	@Bean
	public ServletRegistrationBean druidServlet() {
		return new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
	}
	
	public DataSource createDataSource(String driverClass,String username,String url) {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUsername(username);
		dataSource.setUrl(url);
		//dataSource.setPassword(password);
		dataSource.setInitialSize(initialSize);
		dataSource.setMinIdle(minIdle);
		dataSource.setMaxActive(maxActive);
		return dataSource;
	}
	
}
