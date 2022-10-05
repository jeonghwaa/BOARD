package com.freehoon.web.board.dao;

import java.util.List;

import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;
import com.freehoon.web.common.Search;

public interface BoardDAO {

	// 게시판 리스트 출력
	public List<BoardVO> getBoardList(Search search) throws Exception;

	// 총 게시글 개수 확인
	public int getBoardListCnt(Search search) throws Exception;

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

	// 댓글 리스트
	public List<ReplyVO> getReplyList(int bid) throws Exception;

	//댓글 저장
	public int saveReply(ReplyVO replyVO) throws Exception;

	//댓글 수정
	public int updateReply(ReplyVO replyVO) throws Exception;

	//댓글 삭제
	public int deleteReply(int rid) throws Exception;

}
