package aaron.eureka.consumer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aaron.eureka.consumer.IHelloRemote;

@RestController
public class ConsumerController {

	@Autowired
	IHelloRemote IHello;

	@RequestMapping("/hello/{name}")
	public String index(@PathVariable("name") String name) {
		return IHello.hello(name);
	}
}
