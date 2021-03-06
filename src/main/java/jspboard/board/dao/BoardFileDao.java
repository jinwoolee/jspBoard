package jspboard.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jspboard.board.model.BoardFileVo;

public class BoardFileDao implements IBoardFileDao {

	/**
	 * Method : getBoardFileList 최초작성일 : 2018. 2. 2. 작성자 : jw 변경이력 :
	 * 
	 * @param sqlSession
	 * @param boardNo
	 * @return Method 설명 : 게시물 첨부파일 리스트 조회
	 */
	@Override
	public List<BoardFileVo> getBoardFileList(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectList("jspboard.board.dao.getBoardFileList", boardNo);
	}

  /** 
   * Method   : getBoardFile
   * 최초작성일  : 2018. 2. 5. 
   * 작성자 : jw
   * 변경이력 : 
   * @param sqlSession
   * @param fileNo
   * @return 
   * Method 설명 : 게시물 첨부 조회
   */
  @Override
  public BoardFileVo getBoardFile(SqlSession sqlSession, int fileNo) {
    return sqlSession.selectOne("jspboard.board.dao.getBoardFile", fileNo);
  }
  
	/**
	 * Method : insertBoardFile 최초작성일 : 2018. 2. 2. 작성자 : jw 변경이력 :
	 * 
	 * @param boardFileVo
	 * @return Method 설명 : 게시물 첨부파일 입력
	 */
	@Override
	public int insertBoardFile(SqlSession sqlSession, BoardFileVo boardFileVo) {
		return sqlSession.insert("jspboard.board.dao.insertBoardFile", boardFileVo);
	}

	/**
	  * @FileName : BoardFileDao.java
	  * @Project : jspBoard
	  * @Date : 2018. 2. 2.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param boardFileVo
	  * @return
	  * @프로그램 설명 : 게시물 첨부파일 삭제 
	  */
	@Override
	public int deleteBoardFile(SqlSession sqlSession, int fileNo) {
		return sqlSession.delete("jspboard.board.dao.deleteBoardFile", fileNo);
	}
}
