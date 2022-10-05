package com.freehoon.web.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;
import com.freehoon.web.common.Search;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;

	//게시판 리스트
	@Override
	public List<BoardVO> getBoardList(Search search) throws Exception {
		return sqlSession.selectList("com.freehoon.web.board.boardMapper.getBoardList",search);
	}

	// 총 게시글 개수 확인
	@Override
	public int getBoardListCnt(Search search) throws Exception {
		return sqlSession.selectOne("com.freehoon.web.board.boardMapper.getBoardListCnt",search);
	}

	//게시판 상세 조회
	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		return sqlSession.selectOne("com.freehoon.web.board.boardMapper.getBoardContent", bid);
	}

	//게시판 등록
	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		return sqlSession.insert("com.freehoon.web.board.boardMapper.insertBoard", boardVO);
	}

	//게시판 수정
	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		return sqlSession.update("com.freehoon.web.board.boardMapper.updateBoard", boardVO);
	}

	//게시판 삭제
	@Override
	public int deleteBoard(int bid) throws Exception {
		return sqlSession.insert("com.freehoon.web.board.boardMapper.deleteBoard", bid);
	}

	//게시판 조회 수
	@Override
	public int updateViewCnt(int bid) throws Exception {
		return sqlSession.update("com.freehoon.web.board.boardMapper.updateViewCnt", bid);
	}
	
	//댓글 리스트	
	@Override
	public List<ReplyVO> getReplyList(int bid) throws Exception {
		return sqlSession.selectList("com.freehoon.web.board.replyMapper.getReplyList", bid);
	}

	//댓글 저장
	@Override
	public int saveReply(ReplyVO replyVO) throws Exception {
		return sqlSession.insert("com.freehoon.web.board.replyMapper.saveReply", replyVO);
	}

	//댓글 수정
	@Override
	public int updateReply(ReplyVO replyVO) throws Exception {
		return sqlSession.update("com.freehoon.web.board.replyMapper.updateReply", replyVO);
	}
	
	//댓글 삭제
	@Override
	public int deleteReply(int rid) throws Exception {
		return sqlSession.delete("com.freehoon.web.board.replyMapper.deleteReply", rid);
	}
	
}
