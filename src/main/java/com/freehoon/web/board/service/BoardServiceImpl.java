package com.freehoon.web.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.freehoon.web.board.dao.BoardDAO;
import com.freehoon.web.board.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;

	// 게시판 리스트 출력
	@Override
	public List<BoardVO> getBoardList() throws Exception {
		return boardDAO.getBoardList();
	}

	// 게시판 글 추가
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
	}
	
	//게시판 상세보기
	public BoardVO getBoardContent(int bid) throws Exception{
		
		boardDAO.updateViewCnt(bid);
		
		return boardDAO.getBoardContent(bid);
	}

}
