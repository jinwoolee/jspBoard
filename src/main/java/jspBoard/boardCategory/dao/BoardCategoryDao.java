package jspBoard.boardCategory.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jspBoard.boardCategory.model.BoardCategoryVo;

/**
 * 게시판 카테고리 dao 구현체
 * BoardCategoryDao.java
 * 
 * @author jw
 * @since 2017. 12. 14.
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2017. 12. 14.    jw				최초 생성
 *
 * </pre>
 */
public class BoardCategoryDao implements IBoardCategoryDao {

	/** 
	 * Method   : getBoardCategoryList
	 * 최초작성일  : 2017. 12. 14. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param sqlSession
	 * @return 
	 * Method 설명 : 게시판 카테고리 조회 
	 */
	@Override
	public List<BoardCategoryVo> getBoardCategoryList(SqlSession sqlSession) {
		return sqlSession.selectList("jspBoard.boardCategory.dao.getBoardCategoryList", "test");
	}

	/** 
	 * Method   : insertCategory
	 * 최초작성일  : 2017. 12. 14. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param sqlSession
	 * @param boardCategoryVo
	 * @return 
	 * Method 설명 : 게시판 카테고리 입력
	 */
	@Override
	public int insertCategory(SqlSession sqlSession, BoardCategoryVo boardCategoryVo) {
		return sqlSession.insert("jspBoard.boardCategory.dao.insertCategory", boardCategoryVo);
	}

	/** 
	 * Method   : activeBoardCategory
	 * 최초작성일  : 2017. 12. 14. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param sqlSession
	 * @param boardCategoryVo
	 * @return 
	 * Method 설명 : 게시판 카테고리 활성화 설정
	 */
	@Override
	public int activeBoardCategory(SqlSession sqlSession, BoardCategoryVo boardCategoryVo) {
		return sqlSession.update("jspBoard.boardCategory.dao.activeBoardCategory", boardCategoryVo);
	}

	/** 
	 * Method   : getBoardCategory
	 * 최초작성일  : 2017. 12. 14. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param boardCategoryVo
	 * @return 
	 * Method 설명 : 게시판 카테고리 조회
	 */
	@Override
	public BoardCategoryVo getBoardCategory(SqlSession sqlSession, BoardCategoryVo boardCategoryVo) {
		return sqlSession.selectOne("jspBoard.boardCategory.dao.getBoardCategory", boardCategoryVo);
	}

}
