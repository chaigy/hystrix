package com.cgy.spring.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgy.spring.hystrix.BaseHystrix;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
/**
 * 测试hystrix
 * @author chaigy
 *
 */
@RestController
public  class IndexController extends BaseHystrix{
	/**
	 * 测试此方法具体 独立的配置信息，其余没有设置的使用默认配置
	 * @return
	 */
	@HystrixCommand(threadPoolKey="my",fallbackMethod="error")
	@GetMapping("/index")
	public String index() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("index信息....");
		return "index";
	}
	/**
	 * 此方法没有设置hystrix 则使用默认配置信息
	 * @return
	 */
	@HystrixCommand
	@GetMapping("/index2")
	public String index2() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("index2信息....");
		return "index2";
	}
	
	public String error() {
		System.out.println("我走到了降级页面");
		return "我是特定类的fallback信息..";
	}
}
