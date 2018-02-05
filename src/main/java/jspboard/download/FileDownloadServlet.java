package jspboard.download;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.board.model.BoardFileVo;
import jspboard.board.service.BoardService;
import jspboard.board.service.BoardServiceImpl;

/**
 * 파일 다운로드 서블릿
 * FileDownloadServlet.java
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
@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService;

    public FileDownloadServlet() {
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
	 * Method 설명 : 파일 다운로드
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int fileNo = Integer.valueOf(request.getParameter("fileNo"));
	  BoardFileVo boardFileVo = boardService.getBoardFile(fileNo);

	  response.setHeader("Content-Disposition","attachment;filename=" + boardFileVo.getFileOrgNm());
    response.setContentType("application/octet-stream");
    response.setContentLength((int)boardFileVo.getFileSize());
    
	  ServletOutputStream sos = response.getOutputStream();
	  File file = new File(getServletContext().getRealPath(boardFileVo.getFilePath() + boardFileVo.getFileNm()));
	  FileInputStream fis = new FileInputStream(file);
	  BufferedInputStream bis = new BufferedInputStream(fis);
	  byte[] buffer = new byte[512];
	  int len = 0;
	  while( (len = bis.read(buffer)) != -1 ) {
	    sos.write(buffer);
	  }
	  bis.close();
	  fis.close();
	  sos.close();

	}
}
