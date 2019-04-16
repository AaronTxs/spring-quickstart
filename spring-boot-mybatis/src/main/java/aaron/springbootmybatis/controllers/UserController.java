package aaron.springbootmybatis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import aaron.springbootmybatis.mapper.UserMapper;
import aaron.springbootmybatis.model.*;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("")
	public List<User> getUsers() {
		List<User> users = userMapper.getAll();
		return users;
	}

	@RequestMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		User user = userMapper.getOne(id);
		return user;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void save(User user) {
		userMapper.insert(user);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void update(User user) {
		userMapper.update(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		userMapper.delete(id);
	}
}
