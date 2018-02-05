package jspboard.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jspboard.board.model.BoardFileVo;

public interface IBoardFileDao {

	/**
	 * Method : getBoardFileList 최초작성일 : 2018. 2. 2. 작성자 : jw 변경이력 :
	 * 
	 * @param sqlSession
	 * @param boardNo
	 * @return Method 설명 : 게시물 첨부파일 조회(리스트)
	 */
	List<BoardFileVo> getBoardFileList(SqlSession sqlSession, int boardNo);

	/** 
	 * Method   : getBoardFile
	 * 최초작성일  : 2018. 2. 5. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param sqlSession
	 * @param fileNo
	 * @return 
	 * Method 설명 : 게시물 첨부파일 조회
	 */
	BoardFileVo getBoardFile(SqlSession sqlSession, int fileNo);
	
	/**
	 * Method : insertBoardFile 최초작성일 : 2018. 2. 2. 작성자 : jw 변경이력 :
	 * 
	 * @param boardFileVo
	 * @return Method 설명 : 게시물 첨부파일 입력
	 */
	int insertBoardFile(SqlSession sqlSession, BoardFileVo boardFileVo);

	/**
	 * @FileName : IBoardFileDao.java
	 * @Project : jspBoard
	 * @Date : 2018. 2. 2.
	 * @작성자 : jw
	 * @변경이력 :
	 * @param boardFileVo
	 * @return
	 * @프로그램 설명 : 게시물 첨부파일 삭제
	 */
	int deleteBoardFile(SqlSession sqlSession, int boardNo);

}
