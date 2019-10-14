package com.ja.mlproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.mlproject.service.CommentService;
import com.ja.mlproject.vo.CommentBoardVO;

@Controller
public class CommentBoardController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/writeCommentAction")
	public String writeCommentAction(CommentBoardVO vo) {
		commentService.writeComment(vo);
		
		return "redirect:readContentPage?b_idx="+vo.getB_idx()+"";
	}
	
	@RequestMapping("/deleteCommentAction")
	public String deleteCommentAction(CommentBoardVO vo) {
		commentService.deleteComment(vo);
		
		return "redirect:readContentPage?b_idx="+vo.getB_idx()+"";
	}
}