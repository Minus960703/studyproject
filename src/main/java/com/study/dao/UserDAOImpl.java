package com.study.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.study.mappers.userMapper";

	@Override
	public void join(UserVO vo) throws Exception {
		sql.insert(namespace + ".join", vo);
		
	}
	
}
