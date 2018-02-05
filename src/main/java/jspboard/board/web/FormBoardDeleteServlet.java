package jspboard.board.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.board.model.BoardVo;
import jspboard.board.service.BoardService;
import jspboard.board.service.BoardServiceImpl;

@WebServlet("/formBoardDelete")
public class FormBoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService;

	public FormBoardDeleteServlet() {
		super();
		boardService = new BoardServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 게시글 파라미터
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardNo(boardNo);

		boardService.deleteBoard(boardVo);

		response.sendRedirect("/formBoardList");
	}

}
