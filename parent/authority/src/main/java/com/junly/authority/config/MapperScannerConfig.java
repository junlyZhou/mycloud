package com.junly.authority.config;

import java.lang.annotation.Annotation;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.junly.authority.mapper.annotation.MasterDBS;
import com.junly.authority.mapper.annotation.SlaverDBS;

@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MapperScannerConfig {

	/**
	 * 实现主mapper的扫描
	 * @return
	 */
	@Bean
	public MapperScannerConfigurer masterMapperScanner() {
		String basePackage = "com.junly.authority.mapper.master";
		return createMapperScannerConfigurer(basePackage,"masterSSF",MasterDBS.class);
	}
	
	/**
	 * 实现次mapper的扫描（与主数据库不存在主重关系）
	 * @return
	 */
	@Bean
	public MapperScannerConfigurer slaverMapperScanner() {
		String basePackage = "com.junly.authority.mapper.slaver";
		return createMapperScannerConfigurer(basePackage,"slaverSSF",SlaverDBS.class);
	}
	/**
	 * 扫描包和自定义注解，并注入对应的数据源
	 * @param basePackage
	 * @param sqlSessionFactoryName
	 * @param annotationClass
	 * @return
	 */
	public MapperScannerConfigurer createMapperScannerConfigurer(String basePackage,
			String sqlSessionFactoryName, 
			Class<? extends Annotation> annotationClass) {
		
		MapperScannerConfigurer mapperScanner = new MapperScannerConfigurer();
		mapperScanner.setBasePackage(basePackage);
		mapperScanner.setSqlSessionFactoryBeanName(sqlSessionFactoryName);
		mapperScanner.setAnnotationClass(annotationClass);
		
		return mapperScanner;
	}
	
}
