package com.ja.mlproject.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.mlproject.mapper.CommentBoardSQLMapper;
import com.ja.mlproject.service.CommentService;
import com.ja.mlproject.vo.CommentBoardVO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentBoardSQLMapper commentBoardSQLMapper;
	
	@Override
	public ArrayList<CommentBoardVO> getCommentList(String b_idx) {
		return commentBoardSQLMapper.selectAll(b_idx);
	}

	@Override
	public void writeComment(CommentBoardVO requestParam) {
		commentBoardSQLMapper.insertcomment(requestParam);
	}

	@Override
	public void deleteComment(CommentBoardVO requestParam) {
		commentBoardSQLMapper.deleteByIdx(requestParam);
	}

}