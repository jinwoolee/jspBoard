package jspboard.board.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.ibatis.session.SqlSession;

import jspboard.board.dao.BoardDao;
import jspboard.board.dao.IBoardDao;
import jspboard.board.model.BoardFileVo;
import jspboard.board.model.BoardVo;
import jspboard.board.service.BoardService;
import jspboard.board.service.BoardServiceImpl;
import jspboard.mybatis.SqlMapSessionFactory;

/**
 * Servlet implementation class FormBoardModifySevlet
 */
@MultipartConfig(maxFileSize = 10 * 1024 * 1024, maxRequestSize = 100 * 1024 * 1024)
@WebServlet("/formBoardModify")
public class FormBoardModifySevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService;

	public FormBoardModifySevlet() {
		super();
		boardService = new BoardServiceImpl();
	}

	// 게시글 상세 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		BoardVo boardVo = new BoardVo();
		boardVo.setBoardNo(boardNo);

		BoardVo resultVo = boardService.getBoardDetail(boardVo);
		request.setAttribute("boardVo", resultVo);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/formBoardModify.jsp");
		rd.forward(request, response);
	}

	// 게시글 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 게시글 파라미터
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String regId = "brown";

		// parts
		Collection<Part> parts = request.getParts();
		
		String uploadPath = getServletContext().getRealPath("/uploadFolder") + File.separator;
		
		List<BoardFileVo> boardFileList = new ArrayList<BoardFileVo>();
		for (Part part : parts) {
			if("uploadFile".equals(part.getName()) && part.getSize() > 0) {
				String fileOrgNm = null;
				String fileNm = UUID.randomUUID().toString();
				String[] contentDisposition = part.getHeader("Content-Disposition").split(";");
				for(String str : contentDisposition)
				  if(str.startsWith(" filename"))
				    fileOrgNm = str.substring(str.indexOf("=")+1).replace("\"", "");
				part.write(uploadPath + fileNm);
				
				BoardFileVo boardFileVo = new BoardFileVo();
				boardFileVo.setFileNm(fileNm);
				boardFileVo.setFileOrgNm(fileOrgNm);
				boardFileVo.setFilePath("/uploadFolder" + File.separator);
				boardFileVo.setFileType(part.getContentType());
				boardFileVo.setFileSize(part.getSize());
				boardFileList.add(boardFileVo);
			}
		}
				
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardNo(boardNo);
		boardVo.setTitle(title);
		boardVo.setContent(content);
		boardVo.setRegId(regId);
		boardService.modifyBoard(boardVo, boardFileList);

		response.sendRedirect("/formBoardDetail?boardNo=" + boardNo);
	}

}
