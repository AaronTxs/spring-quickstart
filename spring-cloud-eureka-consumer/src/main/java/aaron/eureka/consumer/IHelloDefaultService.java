package aaron.eureka.consumer;

import org.springframework.stereotype.Component;

@Component
public class IHelloDefaultService implements IHelloRemote {

	@Override
	public String hello(String name) {

		return "Hello world! " + name;
	}
}
