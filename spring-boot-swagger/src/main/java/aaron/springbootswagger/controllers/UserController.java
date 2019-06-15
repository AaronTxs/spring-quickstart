package aaron.springbootswagger.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aaron.springbootswagger.beans.ResObject;
import aaron.springbootswagger.beans.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {

	@ApiOperation(value = "新增用户", notes = "新增注册")
	@RequestMapping(value = "/createUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResObject createUser(@RequestBody User user) {
		System.out.println("createUser:::" + user.toString());
		return new ResObject(HttpStatus.OK.value(), "新增成功.");
	}

	@ApiOperation(value = "修改用户", notes = "修改用户")
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResObject updateUser(@RequestBody User user) {
		System.out.println("updateUser:::" + user.toString());
		return new ResObject(HttpStatus.OK.value(), "修改成功.");
	}

	@ApiOperation(value = "删除用户", notes = "删除用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String") })
	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
	public ResObject deleteUser(@RequestParam("userId") String userId) {
		System.out.println("deleteUser:::" + userId);
		return new ResObject(HttpStatus.OK.value(), "删除成功.");
	}

	@ApiOperation(value = "查询用户", notes = "查询用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String") })
	@RequestMapping(value = "/queryUser", method = RequestMethod.GET)
	public ResObject queryUser(@RequestParam("userId") String userId) {
		System.out.println("queryUser:::" + userId);
		User user = new User(userId, "张三", "******", "mao2080@sina.com");
		return new ResObject(HttpStatus.OK.value(), user);
	}
}
