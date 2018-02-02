package jspboard.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jspboard.board.model.BoardFileVo;

public interface IBoardFileDao {

  /** 
   * Method   : getBoardFileList
   * 최초작성일  : 2018. 2. 2. 
   * 작성자 : jw
   * 변경이력 : 
   * @param sqlSession
   * @param boardNo
   * @return 
   * Method 설명 : 게시물 첨부파일 조회
   */
  List<BoardFileVo> getBoardFileList(SqlSession sqlSession, int boardNo);

  /** 
   * Method   : insertBoardFile
   * 최초작성일  : 2018. 2. 2. 
   * 작성자 : jw
   * 변경이력 : 
   * @param boardFileVo
   * @return 
   * Method 설명 : 게시물 첨부파일 입력 
   */
  int insertBoardFile(SqlSession sqlSession, BoardFileVo boardFileVo);

}
