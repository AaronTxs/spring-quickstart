package aaron.qs.docker.maven.controller;

import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/docker")
public class  DockerController {

    @GetMapping("/")
	public String Index() {
        return "hello, docker!";
	}
}
