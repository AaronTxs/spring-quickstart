package aaron.springbootconfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/*
   * 添加@Component注解，让spring在启动的时候扫描到该类，并添加到spring容器中
   * 使用@ConfigurationProperties(prefix="") 设置前缀，属性上不需要添加注解
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
