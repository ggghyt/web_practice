package com.yedam.control.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String bno = req.getParameter("board_num");
		String pg = req.getParameter("page");
		String searchCondition = req.getParameter("searchCondition");
		String keyword = req.getParameter("keyword");
		BoardService svc = new BoardServiceImpl();
		if (req.getMethod().equals("GET")) {

			BoardVO board = svc.searchBoard(Integer.parseInt(bno));

			req.setAttribute("boardVO", board);
			req.setAttribute("page", pg);
			req.setAttribute("searchCondition", searchCondition);
			req.setAttribute("keyword", keyword);
			req.getRequestDispatcher("board/modifyForm.tiles").forward(req, resp);
		}
		
		else if (req.getMethod().equals("POST")) {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			

			BoardVO board = new BoardVO();
			board.setBoard_num(Integer.parseInt(bno));
			board.setTitle(title);
			board.setContent(content);

			if (svc.modifyBoard(board)) {
				resp.sendRedirect("boardList.do?searchCondition=" + searchCondition + "&keyword=" + keyword + "&page=" + pg);
			} else {
				board = svc.searchBoard(Integer.parseInt(bno));

				req.setAttribute("boardVO", board);
				req.setAttribute("msg", "nothing update");
				req.getRequestDispatcher("board/modifyForm.tiles").forward(req, resp);
			}
		}
		
	}
}
