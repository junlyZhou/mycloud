package com.junly.base.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@AutoConfigureAfter(value=DruidDataSourceConfig.class)
public class MybatisConfig {
	
	static final String MAPPER_LOCATION = "classpath:com/**/mapper/*/*.xml";

	@Autowired
	@Qualifier("masterDataSource")
	private DataSource masterDataSource;
	
	@Autowired
	@Qualifier("slaverDataSource")
	private DataSource slaverDataSource;
	
	@Bean(name = "masterSSF")
	@Primary
	public SqlSessionFactory masterSSF() throws Exception {
		return createSqlSessionFactory(masterDataSource);
	}
	
	@Bean(name = "slaverSSF")
	public SqlSessionFactory slaverSSF()throws Exception{
		return createSqlSessionFactory(slaverDataSource);
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory masterSSF) {
		return new SqlSessionTemplate(masterSSF);
	}
	
	public SqlSessionFactory createSqlSessionFactory(DataSource dataSource)throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources(MAPPER_LOCATION));
		return sessionFactoryBean.getObject();
	}
	
}
