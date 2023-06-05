package net.teaho.demo.spring.cloud.sentinel.core.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author teaho2015@gmail.com
 * @date 2023-06
 */
@RestController
public class TestController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/hello")
	@SentinelResource("resource_hello")
	public String hello() {
		return "Hello";
	}

	@GetMapping("/hello2")
	@SentinelResource("resource_hello2")
	public String hello2() {
		//TODO 不生效
		//		ContextUtil.enter("resource_hello", "b");
		return "Hello2";
	}

	@GetMapping("/aa")
	@SentinelResource("aa")
	public String aa(int b, int a) {
		return "Hello test";
	}

	@GetMapping("/test")
	public String test1() {
		return "Hello test";
	}

	@GetMapping("/template")
	public String client() {
		return restTemplate.getForObject("http://www.taobao.com/test", String.class);
	}

}
