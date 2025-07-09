package com.yedam.app.board.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

import lombok.RequiredArgsConstructor;

@Controller // (uri+method) + service + response(view or data)
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;

	// 전체 조회 : GET - boardList
	@GetMapping("boardList")
	public String boardList(Model model) {
		// service
		List<BoardVO> list = boardService.findAll();
		// view 에 전달할 데이터 담기 : model
		model.addAttribute("boards", list);
		return "board/list"; // view
		// classpath:/templates/board/list.html
	}

	// 등록 - 페이지
	@GetMapping("boardInsert")
	public String boardInsertForm() {
		return "board/insert";
	}

	// 등록 - 처리
	@PostMapping("boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {
		boardService.createInfo(boardVO);
		return "redirect:boardList";
	}
}
