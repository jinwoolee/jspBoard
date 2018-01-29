package jspBoard.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jspBoard.board.model.BoardVo;

/**
 * 게시판 dao interface
 * IBoardDao.java
 * 
 * @author jw
 * @since 2017. 12. 15.
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2017. 12. 15.    jw				최초 생성
 *
 * </pre>
 */
public interface IBoardDao {

	/** 
	 * Method   : getBoardPagingList
	 * 최초작성일  : 2017. 12. 15. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param boardVo
	 * @return 
	 * Method 설명 : 게시물 페이징 조회
	 */
	List<BoardVo> getBoardPagingList(SqlSession sqlSession, BoardVo boardVo);

	/**
	  * @FileName : IBoardDao.java
	  * @Project : jspBoard
	  * @Date : 2018. 1. 29.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param boardVo
	  * @return
	  * @프로그램 설명 : 게시물 전체 건수 조회
	  */
	Integer getBoardTotalCnt(SqlSession sqlSession, BoardVo boardVo);

	/** 
	 * Method   : getBoardDetail
	 * 최초작성일  : 2018. 1. 29. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param boardVo
	 * @return 
	 * Method 설명 : 게시물 상세조회 
	 */
	BoardVo getBoardDetail(SqlSession sqlSession, BoardVo boardVo);

	/** 
	 * Method   : modifyBoard
	 * 최초작성일  : 2018. 1. 29. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param sqlSession
	 * @param boardVo
	 * @return 
	 * Method 설명 : 게시글 수정
	 */
	int modifyBoard(SqlSession sqlSession, BoardVo boardVo);

}
