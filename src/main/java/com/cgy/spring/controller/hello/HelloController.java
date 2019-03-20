package com.cgy.spring.controller.hello;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cgy.spring.hystrix.BaseHystrix;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
public class HelloController extends BaseHystrix{
	
	@HystrixCommand 
	@GetMapping("/aa")
	@ResponseBody
	public String aa() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "aa";
	}
}
