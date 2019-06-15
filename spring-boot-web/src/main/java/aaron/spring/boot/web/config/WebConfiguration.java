package aaron.spring.boot.web.config;

import aaron.spring.boot.web.filters.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//WebMvcConfigurerAdapter已经过时,@SuppressWarnings("deprecation")用来忽略编译器警告
@SuppressWarnings("deprecation")
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter
{
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
	        AntPathMatcher matcher = new AntPathMatcher();
	        matcher.setCaseSensitive(false);
	        configurer.setPathMatcher(matcher);
	    }
	
	@Bean
	public FilterRegistrationBean<MyFilter> testFilterRegistration() {
 		FilterRegistrationBean<MyFilter> registration =new FilterRegistrationBean<MyFilter>();
		registration.setFilter(new MyFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("MyFilter");
		registration.setOrder(1);
		return registration;
	}
	
}
