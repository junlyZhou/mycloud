package com.junly.front.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junly.front.fallback.TestBaseHystrix;
/**
 * 此2种注解方式测试未成功，可能使用的方式不对
 * @author Administrator
 */
//@FeignClient(name = "${feignClient.name.base}",fallbackFactory = FeignHystrixConfig.class)
@FeignClient(name = "${feignClient.name.base}", fallback=TestBaseHystrix.class)
public interface BaseFeignHystrixService {
	@RequestMapping("/test")
	public Object testMethod(String id);
}
