package com.mih.board.user.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mih.board.user.dao.UserMapper;
import com.mih.board.user.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserMapper userDao;
	
	//시작 페이지
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "login";
	}
	
	//로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String login(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	//회원 등록 페이지
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup() {
		return "signup";
	}

	//회원 등록
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(UserVO user) throws Exception {
		userDao.insertUser(user);
		return "login";
	}
	
	//회원 로그인
	@RequestMapping(value="/member", method=RequestMethod.POST)
	public String memberCheck(UserVO user, HttpSession session) throws Exception {
		List<UserVO> userList = userDao.getUser();
		for(UserVO member : userList) {
			if(user.getUserEmail().equalsIgnoreCase(member.getUserEmail()) &&
					user.getUserPw().equalsIgnoreCase(member.getUserPw())) {
				session.setAttribute("userId", user.getUserEmail());	
				session.setAttribute("userNo", member.getUserNo());
				session.setAttribute("userNm", member.getUserNm());
				return "forward:/boardMain";
			}
		}
		return "login";
	}
	
	//아이디 중복체크
	@RequestMapping(value="/memberId", method=RequestMethod.POST)
	public boolean memberIdCheck(UserVO user) throws Exception {
		List<UserVO> userList = userDao.getUser();
		for(UserVO member : userList) {
			if(user.getUserEmail().equalsIgnoreCase(member.getUserEmail())) {
				return false;
			}
		}
		return true;
	}
	
}
