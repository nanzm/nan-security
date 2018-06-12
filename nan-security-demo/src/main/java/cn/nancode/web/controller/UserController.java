package cn.nancode.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.nancode.dto.User;

@RestController
public class UserController {

	@RequestMapping(value = "/")
	public String hello() {
		return "hello world";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> query() {
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}
}
