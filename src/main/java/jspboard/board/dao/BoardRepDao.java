package jspboard.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jspboard.board.model.BoardRepVo;

public class BoardRepDao implements IBoardRepDao {

  /** 
   * Method   : getBoardRepList
   * 최초작성일  : 2018. 2. 6. 
   * 작성자 : jw
   * 변경이력 : 
   * @param sqlSession
   * @param boardNo
   * @return 
   * Method 설명 : 게시물 댓글 조회
   */
  @Override
  public List<BoardRepVo> getBoardRepList(SqlSession sqlSession, int boardNo) {
    return sqlSession.selectList("jspboard.board.dao.getBoardRepList", boardNo);
  }

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
  @Override
  public int insertBoardRep(SqlSession sqlSession, BoardRepVo boardRepVo) {
    return sqlSession.insert("jspboard.board.dao.insertBoardRep", boardRepVo);
  }

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
  @Override
  public int deleteBoardRep(SqlSession sqlSession, int repNo) {
    return sqlSession.update("jspboard.board.dao.deleteBoardRep", repNo);
  }

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
  @Override
  public int modifyBoardRep(SqlSession sqlSession, BoardRepVo boardRepVo) {
    return sqlSession.update("jspboard.board.dao.modifyBoardRep", boardRepVo);
  }
}
