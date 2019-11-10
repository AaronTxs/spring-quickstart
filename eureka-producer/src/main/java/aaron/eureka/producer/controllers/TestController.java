package aaron.eureka.producer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private DiscoveryClient client;

	@RequestMapping("/hello")
	public String hello() {
		List<String> instance = client.getServices();
		for (String item : instance) {
			System.out.println(item);
		}

		return instance.get(0);
	}
}
