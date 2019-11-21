﻿Spring Boot集成Swagger2
===
[TOC]
# 引入Swagger jar包
pom.xml中加入

```xml
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.9.2</version>
</dependency>
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.9.2</version>
</dependency>
```
# 配置Swagger入口
新建SwaggerConfiguration.java配置&开启Swagger
- @Configuration：自动配置Swagger信息，
- @EnableSwagger2：启用Swagger功能
- basePackage：指明需要扫描的包路径
- apiInfo：创建Api的基本信息（作者、版本、描述等）
- select：用ApiSelectorBuilder来控制哪些接口暴露给Swagger（除了标记有@ApiIgnore的接口外）

```java
package aaron.springbootswagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	/*
	 * swagger2的配置文件，配置一些基本的内容
	 */
	@Bean
	public Docket createRestfulApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(restfulApiInfo()).select()				 
				.apis(RequestHandlerSelectors.basePackage("aaron.springbootswagger.controllers"))
				.paths(PathSelectors.any()).build();
	}

	/*
	 * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个 
	 */
	private ApiInfo restfulApiInfo() {
		return new ApiInfoBuilder()
				// 页面标题
				.title("Spring Boot使用 Swagger2 构建RESTful API")
				// 创建人
				.contact(new Contact("Aaron", "https://github.com/aarontxs", ""))
				// 版本号
				.version("1.0")
				// 描述
				.description("API 描述").build();
	}
}
```

# Controller

# 附录
## Swagger常用注解
swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。

- @Api：修饰整个类，描述Controller的作用
- @ApiOperation：描述一个类的一个方法，或者说一个接口
- @ApiParam：单个参数描述
- @ApiModel：用对象来接收参数
- @ApiProperty：用对象接收参数时，描述对象的一个字段
- @ApiResponse：HTTP响应其中1个描述
- @ApiResponses：HTTP响应整体描述
- @ApiIgnore：使用该注解忽略这个API
- @ApiError ：发生错误返回的信息
- @ApiParamImplicitL：一个请求参数
- @ApiParamsImplicit 多个请求参数

# 参考
* [SpirngBoot之整合Swagger2](https://www.cnblogs.com/zhangyinhua/p/9286391.html)
* [Spring Boot 2.X(十五)：集成 Swagger2 开发 API 文档（在线+离线）](https://juejin.im/post/5dc2260f6fb9a04aad0158bf)