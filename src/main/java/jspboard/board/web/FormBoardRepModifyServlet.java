package jspboard.board.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.board.model.BoardRepVo;
import jspboard.board.service.BoardRepService;
import jspboard.board.service.BoardRepServiceImpl;

/**
 * 게시물 댓글 수정 서블릿 FormBoardRepModifyServlet.java
 * 
 * @author jw
 * @since 2018. 2. 7.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2018. 2. 7.    jw				최초 생성
 *
 *      </pre>
 */
@WebServlet("/formBoardRepModify")
public class FormBoardRepModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardRepService boardRepService;

	public FormBoardRepModifyServlet() {
		super();
		boardRepService = new BoardRepServiceImpl();
	}

	/**
	 * Method : doPost 최초작성일 : 2018. 2. 7. 작성자 : jw 변경이력 :
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 *             Method 설명 : 게시글 댓글 수정
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int repNo = Integer.parseInt(request.getParameter("repNo"));
		String content = request.getParameter("content");
		BoardRepVo boardRepVo = new BoardRepVo();
		boardRepVo.setRepNo(repNo);
		boardRepVo.setContent(content);

		boardRepService.modifyBoardRep(boardRepVo);

		response.sendRedirect("/formBoardDetail?boardNo=" + boardNo);
	}
}
