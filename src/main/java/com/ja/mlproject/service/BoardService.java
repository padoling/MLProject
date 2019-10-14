package com.ja.mlproject.service;

import java.util.ArrayList;

import com.ja.mlproject.vo.BoardMemberVO;

import com.ja.mlproject.vo.BoardVO;
import com.ja.mlproject.vo.PagingVO;

public interface BoardService {
	//전체출력
	public ArrayList<BoardMemberVO> getBoardList(PagingVO requestParam);
	
	//페이징
	public ArrayList<BoardMemberVO> getBoardListWithPaging(PagingVO requestParam);
	
	//글읽기
	public BoardMemberVO readContent(BoardVO requestParam);
	
	//조회수 증가
	public void updateCount(BoardVO requestParam);
	
	//전체게시물수 가져오기
	public int boardListCount();
	
	//제목, 내용 검색 게시물수 가져오기
	public int countSearchWord(PagingVO vo);
	
	//닉네임 검색 게시물수 가져오기
	public int countSearchNick(PagingVO vo);
	
	//글삭제
	public void deleteContent(BoardVO requestParam);
	
	//글 수정
	public void updateContent(BoardVO requestParam);
	
	//글 쓰기
	public void writeContent(BoardVO requestParam);
	
}