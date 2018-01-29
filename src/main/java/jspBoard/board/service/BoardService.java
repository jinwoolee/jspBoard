package jspBoard.board.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import jspBoard.board.model.BoardVo;

public interface BoardService {

	/**
	  * @FileName : BoardService.java
	  * @Project : jspBoard
	  * @Date : 2018. 1. 29.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param sqlSession
	  * @param boardVo
	  * @return
	  * @프로그램 설명 : 게시판 리스트 조회
	  */
	Map<String, Object> getBoardPagingList(SqlSession sqlSession, BoardVo boardVo);

}
