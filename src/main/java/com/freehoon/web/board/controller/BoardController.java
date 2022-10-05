package com.freehoon.web.board.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;
import com.freehoon.web.board.service.BoardService;
import com.freehoon.web.common.Pagination;
import com.freehoon.web.common.Search;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService boardService;

	@RequestMapping(value = "/getBoardList", method = RequestMethod.GET)	
	public String getBoardList(Model model			
							, @RequestParam(required = false, defaultValue = "1") int page			
							, @RequestParam(required = false, defaultValue = "1") int range	
							, @RequestParam(required = false, defaultValue = "title") String searchType	
							, @RequestParam(required = false) String keyword
							) throws Exception {
		//검색
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);

		//전체 게시글 개수		
		int listCnt = boardService.getBoardListCnt(search);
		
		//검색
		search.pageInfo(page,range,listCnt);
		
		//Pagination 객체생성		
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, range, listCnt);

		//페이징
		model.addAttribute("pagination", search);

		//게시판 화면 출력
		model.addAttribute("boardList", boardService.getBoardList(search));
		
		return "board/index";
	}
													

	// 글쓰기 버튼 클릭 시 호출주소 -> board/boardForm전달
	@RequestMapping("/boardForm")
	public String boardForm(@ModelAttribute("boardVO") BoardVO vo, Model model) {
		return "board/boardForm";
	}

	// 글쓰기 저장
	@RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
	public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO
						  , @RequestParam("mode") String mode
						  , RedirectAttributes rttr) throws Exception {

		if (mode.equals("edit")) {
			boardService.updateBoard(boardVO);
		} else {
			boardService.insertBoard(boardVO);
		}

		return "redirect:/board/getBoardList";
	}

	// 상세보기 // 동기식 방법 
	@RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
	public String getBoardContent(Model model, @RequestParam("bid") int bid) throws Exception {

		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		model.addAttribute("replyVO", new ReplyVO());

		return "board/boardContent";
	}
	

	// 수정
	@RequestMapping(value = "/editForm", method = RequestMethod.GET)
	public String editForm(@RequestParam("bid") int bid
						 , @RequestParam("mode") String mode
						 , Model model
						 )throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		model.addAttribute("mode", mode);
		model.addAttribute("boardVO", new BoardVO());
		return "board/boardForm";
	}

	// 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteBoard(RedirectAttributes rttr
							, @RequestParam("bid") int bid) throws Exception {
		
		boardService.deleteBoard(bid);
		
		return "redirect:/board/getBoardList";
	}

	// 예외처리
	@ExceptionHandler(RuntimeException.class)
	public String exceptionHandler(Model model, Exception e) {
		logger.info("exception : " + e.getMessage());
		model.addAttribute("exception", e);
		return "error/exception";
	}

}
