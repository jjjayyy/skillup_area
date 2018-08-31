package com.mih.board.user.dao;

import java.util.List;

import com.mih.board.user.vo.UserVO;

public interface UserMapper {
	
	public void insertUser(UserVO user) throws Exception;
	public List<UserVO> getUser() throws Exception;
}
