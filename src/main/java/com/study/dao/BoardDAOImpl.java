package com.study.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	SqlSession sql;
	
	private static String namespace = "com.study.mappers.boardMapper";
	
	@Override
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception {
			
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return sql.selectList(namespace + ".listPage", data);
	}

	@Override
	public int count() throws Exception {
		
		return sql.selectOne(namespace + ".count");
	}

}
