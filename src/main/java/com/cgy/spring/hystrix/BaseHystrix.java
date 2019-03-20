package com.cgy.spring.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;

/**
 * 定义所有继承此类的方法，都默认开始default的hystrix配置，同时fallback
 *  是定义在此类中的 defaultCallBack
 * @author chaigy
 *
 */
@DefaultProperties(threadPoolKey="default",defaultFallback="defaultCallBack")
public abstract class BaseHystrix {

	public String defaultCallBack() {
		return "哎呀！ 服务器开小车了呢~~";
	}
}
