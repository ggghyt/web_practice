package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("board_num");
		String page = req.getParameter("page");
		String searchCondition = req.getParameter("searchCondition");
		String keyword = req.getParameter("keyword");
		
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.searchBoard(Integer.parseInt(bno));
		
		req.setAttribute("boardVO", board);
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", searchCondition);
		req.setAttribute("keyword", keyword);
		
		req.getRequestDispatcher("board/board.tiles").forward(req, resp);
	}

}
