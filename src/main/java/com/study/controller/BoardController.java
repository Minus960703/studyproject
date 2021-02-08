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
		
		//�Խù� �� ����
		int count = service.count();
		
		//�� ������ ������ ����
		int postNum = 10;
		
		//�ϴ� ����¡ ��ȣ 	if ( �Խù� �� 116�� �϶� 116/10 = 11.6 ���� �ø�. 12 . 12������ ���� ����.
		int pageNum = (int)Math.ceil((double)count/postNum);
		
		//�������Խù���
		int displayPost = (num - 1) * postNum;	 //num(���������� ��ȣ�� 6 �϶� ) 6-1=5 5 * 10 = 50 limit 50, 10 �� �Ǿ 50~60 �Խù� ��
		
		//�ѹ��� ǥ���� �Խù� ��ȣ
		int pageNum_cnt = 10;
		
		//ǥ�õǴ� ��ȣ�߸����� ��ȣ		//���������� 6 �϶� 6/ 10 = 0.6 �ø� 1 * 10 = 10. ������ ��ȣ�� 10 ��� 
		int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);
		
		//ǥ�õǴ� ��������ȣ�� ù ��ȣ
		int startPage = endPageNum - (pageNum_cnt - 1);
		
		//������ ��ȣ ����			116/10 = 11.6 �ø� 12
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;	//num�� 11�϶�, 20��������� �ǹ����µ�, endPageNum�������ؼ� �־������ν� 20�̾ƴѸ����� ��ȣ
		}
		
		boolean prev = startPage == 1 ? false : true;	//startPage�� 1 �϶� , ������ false, �ƴҶ� true;	
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
