package jspboard.boardCategory.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jspboard.boardCategory.model.BoardCategoryVo;

/**
 * 보드 카테고리 dao 인터페이스 IBoardCategoryDao.java
 * 
 * @author jw
 * @since 2017. 12. 14.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2017. 12. 14.    jw				최초 생성
 *
 *      </pre>
 */
public interface IBoardCategoryDao {

	/**
	 * Method : getBoardCategoryList 최초작성일 : 2017. 12. 14. 작성자 : jw 변경이력 :
	 * 
	 * @param sqlSession
	 * @return Method 설명 : 게시판 카테고리 전체 조회
	 */
	List<BoardCategoryVo> getBoardCategoryList(SqlSession sqlSession);

	/**
	 * Method : insertCategory 최초작성일 : 2017. 12. 14. 작성자 : jw 변경이력 :
	 * 
	 * @param sqlSession
	 * @param boardCategoryVo
	 * @return Method 설명 : 게시판 카테고리 입력
	 */
	int insertCategory(SqlSession sqlSession, BoardCategoryVo boardCategoryVo);

	/**
	 * Method : activeBoardCategory 최초작성일 : 2017. 12. 14. 작성자 : jw 변경이력 :
	 * 
	 * @param sqlSession
	 * @param boardCategoryVo
	 * @return Method 설명 : 게시판 카테고리 활성화 설정
	 */
	int activeBoardCategory(SqlSession sqlSession, BoardCategoryVo boardCategoryVo);

	/**
	 * Method : getBoardCategory 최초작성일 : 2017. 12. 14. 작성자 : jw 변경이력 :
	 * 
	 * @param boardCategoryVo
	 * @return Method 설명 : 게시판 카테고리 조회
	 */
	BoardCategoryVo getBoardCategory(SqlSession sqlSession, BoardCategoryVo boardCategoryVo);

}
