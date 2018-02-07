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
 * 게시물 댓글 서블릿 
 * FormBoardRepServlet.java
 * 
 * @author jw
 * @since 2018. 2. 6.
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2018. 2. 6.         jw				최초 생성
 *
 * </pre>
 */
@WebServlet("/formBoardRep")
public class FormBoardRepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardRepService boardRepService;
	
    public FormBoardRepServlet() {
        super();
        boardRepService = new BoardRepServiceImpl();
    }

	/**
	  * @FileName : FormBoardRepServlet.java
	  * @Project : jspBoard
	  * @Date : 2018. 2. 6.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param request
	  * @param response
	  * @throws ServletException
	  * @throws IOException
	  * @프로그램 설명 : 게시물 댓글 입력 
	  */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String content = request.getParameter("content");
		String regId = "brown";
		
		BoardRepVo boardRepVo = new BoardRepVo();
		boardRepVo.setBoardNo(boardNo);
		boardRepVo.setContent(content);
		boardRepVo.setRegId(regId);
		
		boardRepService.insertBoardRep(boardRepVo);
		
		response.sendRedirect("/formBoardDetail?boardNo=" + boardNo);
	}
}
