package jspboard.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jspboard.board.model.BoardRepVo;

public interface IboardRepDao {

  /** 
   * Method   : getBoardRepList
   * 최초작성일  : 2018. 2. 6. 
   * 작성자 : jw
   * 변경이력 : 
   * @param sqlSession
   * @param boardNo
   * @return 
   * Method 설명 : 게시물 댓글 리스트 조회
   */
  List<BoardRepVo> getBoardRepList(SqlSession sqlSession, int boardNo);

  /** 
   * Method   : insertBoardRep
   * 최초작성일  : 2018. 2. 6. 
   * 작성자 : jw
   * 변경이력 : 
   * @param sqlSession
   * @param boardRepVo
   * @return 
   * Method 설명 : 게시물 댓글 입력
   */
  int insertBoardRep(SqlSession sqlSession, BoardRepVo boardRepVo);

  /** 
   * Method   : deleteBoardRep
   * 최초작성일  : 2018. 2. 6. 
   * 작성자 : jw
   * 변경이력 : 
   * @param sqlSession
   * @param repNo
   * @return 
   * Method 설명 : 게시글 댓글 삭제
   */
  int deleteBoardRep(SqlSession sqlSession, int repNo);

  /** 
   * Method   : modifyBoardRep
   * 최초작성일  : 2018. 2. 6. 
   * 작성자 : jw
   * 변경이력 : 
   * @param sqlSession
   * @param boardRepVo
   * @return 
   * Method 설명 : 게시글 댓글 수정
   */
  int modifyBoardRep(SqlSession sqlSession, BoardRepVo boardRepVo);

}
