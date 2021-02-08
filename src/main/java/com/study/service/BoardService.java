package com.study.service;

import java.util.List;

import com.study.domain.BoardVO;

public interface BoardService {

	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception;
	
	public int count() throws Exception;
}
