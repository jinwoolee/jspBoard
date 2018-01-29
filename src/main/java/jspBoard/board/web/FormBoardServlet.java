package jspBoard.board.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import jspBoard.board.model.BoardVo;
import jspBoard.board.service.BoardService;
import jspBoard.board.service.BoardServiceImpl;
import jspBoard.mybatis.SqlMapSessionFactory;

/**
 * Servlet implementation class FormBoardServlet
 */
@WebServlet("/formBoard")
public class FormBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FormBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//게시판 분류 확인
		Integer categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		categoryNo = categoryNo == null ? 1 : categoryNo;
		
		BoardVo boardVo = new BoardVo(categoryNo, 1, 10);
	
		BoardService boardService = new BoardServiceImpl();
		SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
		
		Map<String, Object> resultMap = boardService.getBoardPagingList(sqlSession, boardVo);
		request.setAttribute("boardList", resultMap.get("boardList"));
		
		//게시판 페이징 처리
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/formBoardList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
