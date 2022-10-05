package com.freehoon.web.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freehoon.web.board.dao.BoardDAO;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;
import com.freehoon.web.common.Search;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;

	// 게시판 리스트 출력
	@Override
	public List<BoardVO> getBoardList(Search search) throws Exception {
		return boardDAO.getBoardList(search);
	}
	
	// 총 게시글 개수 확인
	@Override
	public int getBoardListCnt(Search search) throws Exception {
		return boardDAO.getBoardListCnt(search);
	}

	// 게시판 글 추가
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
	}

	// 게시판 상세보기
	@Transactional
	@Override
	public BoardVO getBoardContent(int bid) throws Exception {

		BoardVO boardVO = new BoardVO();
		boardDAO.updateViewCnt(bid);
		boardVO = boardDAO.getBoardContent(bid);

//		예외 처리
//
//		// Cate_cd에 컬럼에서 저장할 수 있는 크기보다 큰 문자열을 저장하도록 셋팅을 하고 게시물 수정 로직을 호출 합니다. 
//		// 따라서 수정 SQL 문 처리시 문제가 발생하게 됩니다.   
//		boardVO.setBid(bid);
//
//		try {
//			
//			boardVO.setBid(bid);
//			boardVO.setCate_cd("1111111111111111111111111111111111111");
//			boardDAO.updateBoard(boardVO);
//		
//		} catch (RuntimeException e) {
//		
//			throw new NotFoundException();
//		
//		}
		return boardVO;
	}

	//수정
	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
	}

	// 삭제
	@Override
	public void deleteBoard(int bid) throws Exception {
		boardDAO.deleteBoard(bid);
	}

	@Override
	public List<ReplyVO> getReplyList(int bid) throws Exception {
		return boardDAO.getReplyList(bid);
	}

	@Override
	public int saveReply(ReplyVO replyVO) throws Exception {
		return boardDAO.saveReply(replyVO);
	}

	@Override
	public int updateReply(ReplyVO replyVO) throws Exception {
		return boardDAO.updateReply(replyVO);
	}

	@Override
	public int deleteReply(int rid) throws Exception {
		return boardDAO.deleteReply(rid);
	}
	
	
	
	
	

}
