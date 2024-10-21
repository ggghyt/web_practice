package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class RemoveBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String bno = req.getParameter("board_num");
		BoardService svc = new BoardServiceImpl();
		if (req.getMethod().equals("GET")) {

			BoardVO board = svc.searchBoard(Integer.parseInt(bno));

			req.setAttribute("boardVO", board);
			req.getRequestDispatcher("board/deleteForm.tiles").forward(req, resp);
		}
		
		else if (req.getMethod().equals("POST")) {
			if(svc.removeBoard(Integer.parseInt(req.getParameter("board_num")))) {
				resp.sendRedirect("boardList.do");
			} else {
				req.setAttribute("msg", "something error");
				req.getRequestDispatcher("board/deleteForm.tiles").forward(req, resp);
			}
		}

	}

}
