package com.junly.base.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
/**
 * 实现多数据源事务管理的注册
 * @author Administrator
 *
 */
@Configuration
public class TransactionManagerConfig {
	
	@Autowired
	@Qualifier("masterDataSource")
	private DataSource masterDataSource;
	
	@Autowired
	@Qualifier("slaverDataSource")
	private DataSource slaverDataSource;
	
	/**
	 * 不同的数据源建立不同的事务管理器
	 * 这是master数据源的事务管理器
	 * PlatformTransactionManager 接口是所有事务必须实现的接口
	 * 事务的使用： 采用注解的方式：@Transactional(transactionManager="masterTransactionManager") 指定使用那个事务管理
	 * @return
	 */
	@Bean(name="masterTransactionManager")
	public PlatformTransactionManager masterTransactionManager() {
		return new DataSourceTransactionManager(masterDataSource);
	}
	
	/**
	 * 不同的数据源建立不同的事务管理器
	 * 这是slaver数据源的事务管理器
	 * @return
	 */
	@Bean(name="slaverTransactionManager")
	public PlatformTransactionManager slaverTransactionManager() {
		return new DataSourceTransactionManager(slaverDataSource);
	}
	
}
