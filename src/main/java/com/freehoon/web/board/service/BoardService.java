package com.freehoon.web.board.service;

import java.util.List;

import com.freehoon.web.board.model.BoardVO;

public interface BoardService {

	//게시판 리스트 출력
	public List<BoardVO> getBoardList() throws Exception;
	
	//게시판 글 추가
	public void insertBoard(BoardVO boardVO) throws Exception;
	
	//게시판 상세보기
	public BoardVO getBoardContent(int bid) throws Exception;

	//수정
	public void updateBoard(BoardVO boardVO);
	
	//삭제
	public void deleteBoard(int bid) throws Exception;
}
