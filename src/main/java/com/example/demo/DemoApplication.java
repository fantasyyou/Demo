
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
  * 修改日期:2020/3/15
  * 修改人:牟松
  * 注释:SpringBootApplication注解是整个项目的核心注解，用于
  * 启动自动配置，Spring boot的优势就在于减少了很多配置文件的操作
 **/
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
	     ApplicationContext app = SpringApplication.run(DemoApplication.class, args);
	}
	
}
