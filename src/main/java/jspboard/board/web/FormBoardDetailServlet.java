package jspboard.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.board.model.BoardFileVo;
import jspboard.board.model.BoardVo;
import jspboard.board.service.BoardService;
import jspboard.board.service.BoardServiceImpl;


/**
 * 게시물 상세 조회 서블릿
 * FormBoardDetailServlet.java
 * 
 * @author jw
 * @since 2018. 2. 5.
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2018. 2. 5.    jw				최초 생성
 *
 * </pre>
 */
@WebServlet("/formBoardDetail")
public class FormBoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService;

	public FormBoardDetailServlet() {
		super();
		boardService = new BoardServiceImpl();
	}

	/** 
	 * Method   : doGet
	 * 최초작성일  : 2018. 2. 5. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException 
	 * Method 설명 : 게시물 상세조회
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		BoardVo boardVo = new BoardVo();
		boardVo.setBoardNo(boardNo);

		//게시물 조회
		BoardVo resultVo = boardService.getBoardDetail(boardVo);
		request.setAttribute("boardVo", resultVo);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/formBoardDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
