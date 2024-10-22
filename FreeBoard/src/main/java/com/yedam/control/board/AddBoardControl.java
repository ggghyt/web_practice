package com.yedam.control.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1025 * 5;
		MultipartRequest mr = new MultipartRequest(
				req, // 요청정보
				savePath, // 저장경로
				maxSize, // 최대크기
				"utf-8", // 인코딩 방식
				new DefaultFileRenamePolicy() // 리네임 정책
				);
		
		
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String img = mr.getFilesystemName("img");
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		board.setImg(img);
		
		BoardService svc = new BoardServiceImpl();
		try {
			svc.registerBoard(board);
			resp.sendRedirect("boardList.do");
		} catch (Exception e) {
			req.setAttribute("msg", "something error");
			req.getRequestDispatcher("board/boardForm.tiles").forward(req, resp);
		}
	}

}
