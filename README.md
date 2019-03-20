# hystrix
测试hystrix的使用

本文主要是测试hystrix的一些使用方法，配置文件在resource下的config.properties 文件中，主要是对hystrix的配置信息
  
  定义了一个抽象类，把默认的hystrix配置信息，配置在此类上，所有继承此类的类，只要添加注解@HystrixCommand 则姐姐具有默认配置
  
  如果需要给特定的方法加上信息，则在方法上，编辑对应的属性新信息
