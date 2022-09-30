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

	// 게시판 상세보기
	@Override
	public BoardVO getBoardContent(int bid) throws Exception{
		
		BoardVO boardVO = new BoardVO();		
		boardDAO.updateViewCnt(bid);	
		// boardVO = boardDAO.getBoardContent(bid);
		//		<= 기존 상세내역 조회 부분은 주석 처리 합니다.
		
		// Cate_cd에 컬럼에서 저장할 수 있는 크기보다 큰 문자열을 저장하도록 셋팅을 하고 게시물 수정 로직을 호출 합니다.  
		// 따라서 수정 SQL 문 처리시 문제가 발생하게 됩니다.   
		boardVO.setBid(bid);		
		boardVO.setCate_cd("1111111111111111111111111111111111111");
		boardDAO.updateBoard(boardVO);
		
		return boardVO;
		
	}

	// 수정
	@Override
	public void updateBoard(BoardVO boardVO) {

		// 상세내용조회에서 사용했던 Service(getBoardContent() 메소드)를 재사용
	}

	// 삭ㅈ[
	@Override
	public void deleteBoard(int bid) throws Exception {
		boardDAO.deleteBoard(bid);

	}

}
