package com.study.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.domain.BoardVO;
import com.study.service.BoardService;

@Controller
@RequestMapping(value = "/")
public class BoardController {
	
	@Inject
	BoardService service;
	
	@GetMapping("listPage")
	public void getlistpage(Model model, @RequestParam("num") int num) throws Exception{
		
		//게시물 총 갯수
		int count = service.count();
		
		//한 페이지 보여질 개수
		int postNum = 10;
		
		//하단 페이징 번호 	if ( 게시물 총 116개 일때 116/10 = 11.6 에서 올림. 12 . 12페이지 까지 존재.
		int pageNum = (int)Math.ceil((double)count/postNum);
		
		//보여질게시물들
		int displayPost = (num - 1) * postNum;	 //num(현재페이지 번호가 6 일때 ) 6-1=5 5 * 10 = 50 limit 50, 10 이 되어서 50~60 게시물 출
		
		//한번에 표시할 게시물 번호
		int pageNum_cnt = 10;
		
		//표시되는 번호중마지막 번호		//현재페이지 6 일때 6/ 10 = 0.6 올림 1 * 10 = 10. 마지막 번호는 10 출력 
		int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);
		
		//표시되는 페이지번호중 첫 번호
		int startPage = endPageNum - (pageNum_cnt - 1);
		
		//마지막 번호 재계산			116/10 = 11.6 올림 12
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;	//num이 11일때, 20까지출력이 되버리는데, endPageNum을재계산해서 넣어줌으로써 20이아닌마지막 번호
		}
		
		boolean prev = startPage == 1 ? false : true;	//startPage가 1 일때 , 맞을땐 false, 아닐땐 true;	
		boolean next = endPageNum * pageNum_cnt >= count ? false : true; 
		
		List<BoardVO> list = null;
		list = service.listPage(displayPost, postNum);
		model.addAttribute("list", list);
		model.addAttribute("pageNum", pageNum);
		
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPageNum", endPageNum);
		
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		
		model.addAttribute("select", num);
	}
	

}
