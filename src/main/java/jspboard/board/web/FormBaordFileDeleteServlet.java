package jspboard.board.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.board.service.BoardService;
import jspboard.board.service.BoardServiceImpl;

@WebServlet("/formBaordFileDelete")
public class FormBaordFileDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BoardService boardService;
    public FormBaordFileDeleteServlet() {
        super();
        boardService = new BoardServiceImpl();
    }


	/**
	  * @FileName : FormBaordFileDeleteServlet.java
	  * @Project : jspBoard
	  * @Date : 2018. 2. 5.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param request
	  * @param response
	  * @throws ServletException
	  * @throws IOException
	  * @프로그램 설명 : 게시물 첨부파일 삭제
	  */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//게시물 부파일번호 
		int boardNo = Integer.valueOf(request.getParameter("boardNo"));
		int fileNo = Integer.valueOf(request.getParameter("fileNo"));
		
		//게시물 첨부파일 삭제
		int deleteCnt = boardService.deleteBoardFile(fileNo);
		
		//해당 게시물 상세 페이지로 이동
		response.sendRedirect("/formBoardDetail?boardNo=" + boardNo);
	}

}
