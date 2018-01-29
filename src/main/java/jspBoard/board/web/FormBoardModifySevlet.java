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
 * Servlet implementation class FormBoardModifySevlet
 */
@WebServlet("/formBoardModify")
public class FormBoardModifySevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBoardDao boardDao;
       
    public FormBoardModifySevlet() {
        super();
        boardDao = new BoardDao();
    }

    //게시글 상세 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardNo(boardNo);
		
		SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
		BoardVo resultVo = boardDao.getBoardDetail(sqlSession, boardVo);
		request.setAttribute("boardVo", resultVo);
		
		sqlSession.close();
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/formBoardModify.jsp");
		rd.forward(request, response);
	}

	//게시글 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//게시글 파라미터
		int boardNo		=	Integer.parseInt(request.getParameter("boardNo"));
		String title	=	request.getParameter("title");
		String content	=	request.getParameter("content");
		String regId	=	"brown";
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardNo(boardNo);
		boardVo.setTitle(title);
		boardVo.setContent(content);
		boardVo.setRegId(regId);
		boardService.modifyBoard(boardVo);
		
		response.sendRedirect("/formBoardDetail?boardNo="+boardNo);
	}

}
