package com.study.dao;

import java.util.List;

import com.study.domain.BoardVO;

public interface BoardDAO {
	
	public int count() throws Exception;

	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception;
}
