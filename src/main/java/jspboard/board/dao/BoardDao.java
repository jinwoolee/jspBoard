package jspboard.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jspboard.board.model.BoardVo;

/**
 * 게시판 dao 구현체 BoardDao.java
 * 
 * @author jw
 * @since 2017. 12. 15.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2017. 12. 15.    jw				최초 생성
 *
 *      </pre>
 */
public class BoardDao implements IBoardDao {

	/**
	 * Method : getBoardPagingList 최초작성일 : 2017. 12. 15. 작성자 : jw 변경이력 :
	 * 
	 * @param boardVo
	 * @return Method 설명 : 게시물 페이징 조회
	 */
	@Override
	public List<BoardVo> getBoardPagingList(SqlSession sqlSession, BoardVo boardVo) {
	  List<BoardVo> boardVoList = sqlSession.selectList("jspboard.board.dao.getBoardPagingList", boardVo);
	  for(BoardVo vo : boardVoList) {
	    for(int i = 1; i < vo.getLv(); i++) {
	      if(i == 1)
	        vo.setTitle("&nbsp;&nbsp;&nbsp;<img src=\"/img/ioc-reply.gif\">" + vo.getTitle());
	      else
	        vo.setTitle("&nbsp;&nbsp;&nbsp;" + vo.getTitle());
	    }
	  }
		return boardVoList;
	}

	/**
	 * @FileName : BoardDao.java
	 * @Project : jspBoard
	 * @Date : 2018. 1. 29.
	 * @작성자 : jw
	 * @변경이력 :
	 * @param boardVo
	 * @return
	 * @프로그램 설명 : 게시물 전체건수 조회
	 */
	@Override
	public Integer getBoardTotalCnt(SqlSession sqlSession, BoardVo boardVo) {
		return sqlSession.selectOne("jspboard.board.dao.getBoardTotalCnt", boardVo);
	}

	/**
	 * Method : getBoardDetail 최초작성일 : 2018. 1. 29. 작성자 : jw 변경이력 :
	 * 
	 * @param sqlSession
	 * @param boardVo
	 * @return Method 설명 : 게시물 상세조회
	 */
	@Override
	public BoardVo getBoardDetail(SqlSession sqlSession, BoardVo boardVo) {
		return sqlSession.selectOne("jspboard.board.dao.getBoardDetail", boardVo);
	}

	/**
	 * Method : modifyBoard 최초작성일 : 2018. 1. 29. 작성자 : jw 변경이력 :
	 * 
	 * @param sqlSession
	 * @param boardVo
	 * @return Method 설명 : 게시글 수정
	 */
	@Override
	public int modifyBoard(SqlSession sqlSession, BoardVo boardVo) {
		return sqlSession.update("jspboard.board.dao.modifyBoard", boardVo);
	}

	/**
	 * @FileName : BoardDao.java
	 * @Project : jspBoard
	 * @Date : 2018. 1. 29.
	 * @작성자 : jw
	 * @변경이력 :
	 * @param sqlSession
	 * @param boardVo
	 * @return
	 * @프로그램 설명 : 게시글 삭제
	 */
	@Override
	public int deleteBoard(SqlSession sqlSession, BoardVo boardVo) {
		return sqlSession.delete("jspboard.board.dao.deleteBoard", boardVo);
	}

	/**
	 * @FileName : BoardDao.java
	 * @Project : jspBoard
	 * @Date : 2018. 1. 30.
	 * @작성자 : jw
	 * @변경이력 :
	 * @param boardVo
	 * @return
	 * @프로그램 설명 : 게시글 입력
	 */
	@Override
	public int insertBoard(SqlSession sqlSession, BoardVo boardVo) {
		return sqlSession.insert("jspboard.board.dao.insertBoard", boardVo);
	}
}
