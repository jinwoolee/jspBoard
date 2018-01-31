package jspBoard.board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspBoard.board.model.BoardVo;
import jspBoard.board.service.BoardService;
import jspBoard.board.service.BoardServiceImpl;

@WebServlet("/formBoardList")
public class FormBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private	BoardService boardService;
	
	public FormBoardServlet() {
		super();
		boardService = new BoardServiceImpl();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/formBoard.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 파라미터
		int pBboardNo	=	Integer.parseInt(request.getParameter("pBboardNo"));
		int categoryNo	=	Integer.parseInt(request.getParameter("pcategoryNo"));
		String delYn	=	"N";
		int ord			=	0;
		String title	=	request.getParameter("title");
		String content	=	request.getParameter("content");
		String regId	=	"brown";
		
		BoardVo boardVo = new BoardVo();
		boardService.insertBoard(boardVo);
		
		response.sendRedirect("/formBoardList?boardNo=" + boardVo.getBoardNo());
	}
}
