package com.junly.front.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 指定需要访问的服务的名称
 * @FeignClient(name = "${feignClient.name.base}")
 * @author Administrator
 *
 */
@FeignClient(name = "${feignClient.name.base}")
public interface BaseService {
	/**
	 * 这里不能使用路劲传递参数的方法传递参数
	 * @param id
	 * @return
	 */
	//说明@LoadBalanced 可以不需要，因为feign自带Ribben负载均衡（默认方式为轮询）
	//@LoadBalanced
	@RequestMapping("/test")
	public Object testMethod(String id);
	
}
