package aaron.springboot.quickstart.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("aaron.springbootmybatis.mapper")
public class QuickStartMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickStartMybatisApplication.class, args);
	}

}