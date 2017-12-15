package jspBoard.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jspBoard.board.model.BoardVo;

/**
 * 게시판 dao 구현체
 * BoardDao.java
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
public class BoardDao implements IBoardDao {

	/** 
	 * Method   : getBoardPagingList
	 * 최초작성일  : 2017. 12. 15. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param boardVo
	 * @return 
	 * Method 설명 : 게시물 페이징 조회 
	 */
	@Override
	public List<BoardVo> getBoardPagingList(SqlSession sqlSession, BoardVo boardVo) {
		return sqlSession.selectList("getBoardPagingList", boardVo);
	}

}
