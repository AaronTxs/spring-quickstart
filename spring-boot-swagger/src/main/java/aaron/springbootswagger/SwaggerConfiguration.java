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
