package jspBoard.board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import jspBoard.board.dao.BoardDao;
import jspBoard.board.dao.IBoardDao;
import jspBoard.board.model.BoardVo;
import jspBoard.mybatis.SqlMapSessionFactory;

/**
 * Servlet implementation class FormBoardDetailServlet
 */
@WebServlet("/formBoardDetail")
public class FormBoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBoardDao boardDao;
	
    public FormBoardDetailServlet() {
        super();
        boardDao = new BoardDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardNo(boardNo);
		
		SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
		BoardVo resultVo = boardDao.getBoardDetail(sqlSession, boardVo);
		request.setAttribute("boardVo", resultVo);
		
		sqlSession.close();
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/formBoardDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
