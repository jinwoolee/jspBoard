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
 * 게시물 리스트 서블릿
 * FormBoardListServlet.java
 * 
 * @author jw
 * @since 2018. 2. 7.
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2018. 2. 7.    jw				최초 생성
 *
 * </pre>
 */
@WebServlet("/boardList")
public class BoardListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService;
	
	public BoardListViewServlet() {
		super();
		boardService = new BoardServiceImpl();
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

		Map<String, Object> resultMap = boardService.getBoardPagingList(boardVo);
		request.setAttribute("boardList", resultMap.get("boardList"));
		request.setAttribute("boardTotalCnt", resultMap.get("boardTotalCnt"));
		request.setAttribute("pageNav", resultMap.get("pageNav"));

		// 게시판 페이징 처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/formBoardList.jsp");
		rd.forward(request, response);
	}
}
