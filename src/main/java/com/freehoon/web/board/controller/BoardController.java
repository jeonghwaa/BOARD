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
import com.freehoon.web.board.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService boardService;

	@RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
	public String getBoardList(Model model) throws Exception {

		model.addAttribute("boardList", boardService.getBoardList());

		return "board/index";
	}

	// 글쓰기 버튼 클릭 시 호출주소 -> board/boardForm전달
	@RequestMapping("/boardForm")
	public String boardForm() {
		return "board/boardForm";
	}

	// 글쓰기 저장
	@RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
	public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO, @RequestParam("mode") String mode,
			RedirectAttributes rttr) throws Exception {

		if (mode.equals("edit")) {
			boardService.updateBoard(boardVO);
		} else {
			boardService.insertBoard(boardVO);
		}

		return "redirect:/board/getBoardList";
	}

	// 상세보기
	@RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
	public String getBoardContent(Model model, @RequestParam("bid") int bid) throws Exception {

		model.addAttribute("boardContent", boardService.getBoardContent(bid));

		return "board/boardContent";
	}

	// 수정
	@RequestMapping(value = "/editForm", method = RequestMethod.GET)
	public String editForm(@RequestParam("bid") int bid, @RequestParam("mode") String mode, Model model)
			throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		model.addAttribute("mode", mode);
		model.addAttribute("boardVO", new BoardVO());
		return "board/boardForm";
	}

	// 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteBoard(RedirectAttributes rttr, @RequestParam("bid") int bid) throws Exception {
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
