package jspboard.board.web;

import java.io.IOException;
import java.util.Map;

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
 * Servlet implementation class FormBoardServlet
 */
@WebServlet("/formBoardList")
public class FormBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormBoardListServlet() {
		super();
	}

	/** 
	 * Method   : doGet
	 * 최초작성일  : 2018. 2. 6. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException 
	 * Method 설명 : 게시판 리스트 조회
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 게시판 분류 확인
		String categoryNoParam = request.getParameter("categoryNo");
		Integer categoryNo = (categoryNoParam == null || categoryNoParam.equals("")) ? 1
				: Integer.parseInt(categoryNoParam);

		// 게시판 페이지
		String pageStr = request.getParameter("page");
		Integer page = pageStr == null ? 1 : Integer.parseInt(pageStr);

		BoardVo boardVo = new BoardVo(categoryNo, page, 10);

		BoardService boardService = new BoardServiceImpl();

		Map<String, Object> resultMap = boardService.getBoardPagingList(boardVo);
		request.setAttribute("boardList", resultMap.get("boardList"));
		request.setAttribute("boardTotalCnt", resultMap.get("boardTotalCnt"));

		// 게시판 페이징 처리

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/formBoardList.jsp");
		rd.forward(request, response);
	}
}
