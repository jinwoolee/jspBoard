package jspBoard.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import jspBoard.board.dao.BoardDao;
import jspBoard.board.dao.IBoardDao;
import jspBoard.board.model.BoardVo;
import jspBoard.mybatis.SqlMapSessionFactory;

public class BoardServiceImpl implements BoardService {

	private IBoardDao boardDao = new BoardDao();
	
	/**
	  * @FileName : BoardServiceImpl.java
	  * @Project : jspBoard
	  * @Date : 2018. 1. 29.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param sqlSession
	  * @param boardVo
	  * @return
	  * @프로그램 설명 : 게시판 리스트 조회 
	  */
	@Override
	public Map<String, Object> getBoardPagingList(BoardVo boardVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
		
		//게시물 건수 조회
		List<BoardVo> boardList = boardDao.getBoardPagingList(sqlSession, boardVo);
		
		//게시물 전체 건수 조회
		Integer boardTotalCnt = boardDao.getBoardTotalCnt(sqlSession, boardVo);
		
		resultMap.put("boardList", boardList);
		resultMap.put("boardTotalCnt", boardTotalCnt);
		
		sqlSession.close();
		return resultMap;
	}

	/**
	  * @FileName : BoardServiceImpl.java
	  * @Project : jspBoard
	  * @Date : 2018. 1. 29.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param boardVo
	  * @return
	  * @프로그램 설명 : 게시글 상세조회
	  */
	@Override
	public BoardVo getBoardDetail(BoardVo boardVo) {
		SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
		BoardVo vo = boardDao.getBoardDetail(sqlSession, boardVo);
		sqlSession.close();
		return vo;
	}

	/**
	  * @FileName : BoardServiceImpl.java
	  * @Project : jspBoard
	  * @Date : 2018. 1. 29.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param boardVo
	  * @프로그램 설명 : 게시글 수정 
	  */
	@Override
	public void modifyBoard(BoardVo boardVo) {
		SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
		int modifyCnt = boardDao.modifyBoard(sqlSession, boardVo);
		sqlSession.commit();
	}

	/**
	  * @FileName : BoardServiceImpl.java
	  * @Project : jspBoard
	  * @Date : 2018. 1. 29.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param boardVo
	  * @return
	  * @프로그램 설명 : 게시글 삭제
	  */
	@Override
	public int deleteBoard(BoardVo boardVo) {
		SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
		int deleteCnt = boardDao.deleteBoard(sqlSession, boardVo);
		sqlSession.commit();
		
		return deleteCnt;
	}

	/**
	  * @FileName : BoardServiceImpl.java
	  * @Project : jspBoard
	  * @Date : 2018. 1. 30.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param boardVo
	  * @return
	  * @프로그램 설명 : 게시글 입력 
	  */
	@Override
	public int insertBoard(BoardVo boardVo) {
		SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
		
		
		int insertCnt = sqlSession.insert("jspBoard.board.dao.insertBoard", boardVo);
		sqlSession.commit();
		sqlSession.close();
		
		return insertCnt;
	}
}
