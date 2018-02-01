package jspboard.board.web;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jspboard.board.model.BoardVo;
import jspboard.board.service.BoardService;
import jspboard.board.service.BoardServiceImpl;

@MultipartConfig(maxFileSize = 10 * 1024 * 1024, maxRequestSize = 100 * 1024 * 1024)
@WebServlet("/formBoard")
public class FormBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService;

	public FormBoardServlet() {
		super();
		boardService = new BoardServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/formBoard.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시글 파라미터
		String pBoardNoStr = request.getParameter("pBboardNo");
		int pBboardNo = (pBoardNoStr == null || pBoardNoStr.equals("")) ? 0 : Integer.parseInt(pBoardNoStr);

		String categoryNoStr = request.getParameter("categoryNo");
		int categoryNo = (categoryNoStr == null || categoryNoStr.equals("")) ? 1 : Integer.parseInt(categoryNoStr);

		String delYn = "N";
		int ord = 0;
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String regId = "brown";

		// parts
		Collection<Part> parts = request.getParts();
		
		String uploadPath = getServletContext().getRealPath("/uploadFolder");
		
		for (Part part : parts) {
			if("uploadFile".equals(part.getName())) {
				InputStream is = part.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				char[] buff = new char[512];
				
				File f = new File(uploadPath + File.separator + part.getName());
				FileWriter fw = new FileWriter(f);
				
				while(isr.read(buff) != -1) {
					fw.write(buff);
				}
				
				fw.close();
				isr.close();
				is.close();
			}
		}

		BoardVo boardVo = new BoardVo();
		boardVo.setPboardNo(pBboardNo);
		boardVo.setCategoryNo(categoryNo);
		boardVo.setDelYn(delYn);
		boardVo.setOrd(ord);
		boardVo.setTitle(title);
		boardVo.setContent(content);
		boardVo.setReadCnt(0);
		boardVo.setRegId(regId);

		boardService.insertBoard(boardVo);
		response.sendRedirect("/formBoardList?boardNo=" + boardVo.getBoardNo());
	}
}
