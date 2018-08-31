package com.mih.board.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mih.board.user.dao.UserMapper;
import com.mih.board.user.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserMapper userDao;
	
	@RequestMapping("/user")
	public List<UserVO> userList() throws Exception{
		List<UserVO> userList = userDao.getUser();
		return userList;
	}
	
	@RequestMapping("/table")
	public String table() {
		return "tables";
	}
	
/*	//시작 화면
	@RequestMapping("/")
	public String home() {
		return "login";
	}*/
	
	//로그인
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	//회원 등록
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}

	
}
