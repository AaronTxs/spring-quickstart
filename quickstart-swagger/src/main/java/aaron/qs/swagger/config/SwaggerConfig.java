package aaron.qs.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(buildApiInfo()) //将api的元信息设置为包含在json resourcelisting响应中
				//.host("127.0.0.1:8080") //设置ip和端口，或者域名
				.select()//启动用于api选择的生成器
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				//.apis(RequestHandlerSelectors.any())
				//.apis(RequestHandlerSelectors.basePackage("aaron.qs.swagger.controller"))//指定controller路径
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo buildApiInfo() {
		
		return new ApiInfoBuilder()
				// 页面标题
				.title("Spring Boot使用 Swagger2 构建RESTful API")
				// 文档描述
				.description("Swagger 示例 Restful Api 文档")
				// 联系人
				.contact(new Contact("Aaron", "https://github.com/aarontxs", "xcf_love@live.cn"))
				// 版本号
				.version("1.0")
				//.license("")//更新此API的许可证信息
				//.licenseUrl("")//更新此API的许可证Url
				//.termsOfServiceUrl("")//更新服务条款URL
				.build();
    }
 
	/*
	 * @Bean public Docket createRestfulApi() { return new
	 * Docket(DocumentationType.SWAGGER_2).apiInfo(restfulApiInfo()).select()
	 * .apis(RequestHandlerSelectors.basePackage(
	 * "aaron.springbootswagger.controllers")) .paths(PathSelectors.any()).build();
	 * }
	 */
}
