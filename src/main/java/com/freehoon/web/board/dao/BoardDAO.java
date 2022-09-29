package com.freehoon.web.board.dao;

import java.util.List;

import com.freehoon.web.board.model.BoardVO;

public interface BoardDAO {

	// 게시판 리스트 출력
	public List<BoardVO> getBoardList() throws Exception;

	// 게시판 상세보기
	public BoardVO getBoardContent(int bid) throws Exception;

	// 게시판 등록
	public int insertBoard(BoardVO boardVO) throws Exception;	

	// 게시판 수정
	public int updateBoard(BoardVO boardVO) throws Exception;

	// 게시판 삭제
	public int deleteBoard(int bid) throws Exception;

	// 게시판 뷰 수
	public int updateViewCnt(int bid) throws Exception;


	
}
