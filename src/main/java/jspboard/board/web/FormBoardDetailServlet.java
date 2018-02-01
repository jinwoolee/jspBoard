package jspboard.board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.board.model.BoardVo;
import jspboard.board.service.BoardService;
import jspboard.board.service.BoardServiceImpl;

/**
 * Servlet implementation class FormBoardDetailServlet
 */
@WebServlet("/formBoardDetail")
public class FormBoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService;
	
    public FormBoardDetailServlet() {
        super();
        boardService = new BoardServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardNo(boardNo);
		
		BoardVo resultVo = boardService.getBoardDetail(boardVo);
		request.setAttribute("boardVo", resultVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/formBoardDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
