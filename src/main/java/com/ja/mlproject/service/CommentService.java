package com.ja.mlproject.service;

import java.util.ArrayList;

import com.ja.mlproject.vo.CommentBoardVO;

public interface CommentService {
	
	public ArrayList<CommentBoardVO> getCommentList(String b_idx);
	
	public void writeComment(CommentBoardVO requestParam);
	
	public void deleteComment(CommentBoardVO requestParam);

}