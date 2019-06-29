package aaron.springboothello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHelloApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootHelloApplication.class, args);
		SpringApplication springApplication = new SpringApplication(SpringBootHelloApplication.class);
		springApplication.setBannerMode(org.springframework.boot.Banner.Mode.OFF);
		springApplication.run(args);		 		 
	}
}