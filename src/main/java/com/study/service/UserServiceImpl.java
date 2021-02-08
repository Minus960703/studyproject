package com.study.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.study.dao.UserDAO;
import com.study.domain.UserVO;

@Service
public class UserServiceImpl implements UserService{

	@Inject
	UserDAO dao;

	@Override
	public void join(UserVO vo) throws Exception {
		dao.join(vo);
	}
	
	
}
