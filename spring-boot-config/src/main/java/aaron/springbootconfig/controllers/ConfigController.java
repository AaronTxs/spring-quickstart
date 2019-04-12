package aaron.springbootconfig.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aaron.springbootconfig.config.MyConfig;

@RequestMapping("config")
@RestController
public class ConfigController {

	@Value("${spring.main.banner-mode}")
	private String bannerSwitch;

	@Autowired
	private MyConfig config;

	@RequestMapping("/")
	public String defaultConfig() {
		return "Banner Switch is " + bannerSwitch;
	}

	@RequestMapping("/my")
	public String getMyConfig() {
		return "myconfig name is: " + config.getName() + " and password is: " + config.getPassword() + " , desc is : "
				+ config.getDesc();
	}
}