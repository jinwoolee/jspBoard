package jspBoard.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import jspBoard.board.dao.BoardDao;
import jspBoard.board.dao.IBoardDao;
import jspBoard.board.model.BoardVo;

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
	public Map<String, Object> getBoardPagingList(SqlSession sqlSession, BoardVo boardVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//게시물 건수 조회
		List<BoardVo> boardList = boardDao.getBoardPagingList(sqlSession, boardVo);
		
		//게시물 전체 건수 조회
		Integer boardTotalCnt = boardDao.getBoardTotalCnt(sqlSession, boardVo);
		
		resultMap.put("boardList", boardList);
		resultMap.put("boardTotalCnt", boardTotalCnt);
		
		return resultMap;
	}

}
