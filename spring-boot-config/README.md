[TOC]
# 1.SpringBoot配置项读取

SpringBoot项目读取的核心配置文件为`application.properties`或`application.yml`，但由于项目经常会接入其他组件，如mysql，redis，mq等，使用独立的配置文件进行管理更利于开发&运维。

## 1.1 读取核心配置文件

## 1.2 读取自定义配置文件

Spring Boot是通过`@PropertySource`或者`@PropertySources`来完成配置文件到实体的映射的。

这两个注解可以标注在启动类或者实体上。示例代码如下：

```java
package aaron.springbootconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value= {"classpath:myconfig.yml"})
public class SpringBootConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigApplication.class, args);
	}
}
```

```java
package aaron.springbootconfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/*
   * 添加@Component注解，让spring在启动的时候扫描到该类，并添加到spring容器中
   * 使用@ConfigurationProperties(prefix="") 设置前缀
   * 使用@PropertySource读取指定配置文件
 * */
@Component
@ConfigurationProperties(prefix = "root")
@PropertySource(value= {"classpath:myconfig.yml"})
public class MyConfig {
	@Value("${name}")
	private String name;

	@Value("${password}")
	private String password;

	@Value("${desc}")
	private String desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
```



# 附录


## 1. 参考
* [Spring Boot 所有配置](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)
* [Spring Boot 系列（三）属性配置&自定义属性配置](https://www.cnblogs.com/magicalSam/p/7189421.html)