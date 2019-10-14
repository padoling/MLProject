package com.ja.mlproject.vo;

public class BoardMemberVO {
	private BoardVO boardVO;
	private MemberVO memberVO;
	
	public BoardMemberVO() {
		
	}

	public BoardMemberVO(BoardVO boardVO, MemberVO memberVO) {
		super();
		this.boardVO = boardVO;
		this.memberVO = memberVO;
	}

	public BoardVO getBoardVO() {
		return boardVO;
	}

	public void setBoardVO(BoardVO boardVO) {
		this.boardVO = boardVO;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	
}
