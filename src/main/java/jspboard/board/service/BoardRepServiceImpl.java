package jspboard.board.service;

import org.apache.ibatis.session.SqlSession;

import jspboard.board.model.BoardRepVo;
import jspboard.mybatis.SqlMapSessionFactory;

/**
 * 게시글 댓글 서비스
 * BoardRepServiceImpl.java
 * 
 * @author jw
 * @since 2018. 2. 6.
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2018. 2. 6.    jw				최초 생성
 *
 * </pre>
 */
public class BoardRepServiceImpl implements BoardRepService {

  /** 
   * Method   : insertBoardRep
   * 최초작성일  : 2018. 2. 6. 
   * 작성자 : jw
   * 변경이력 : 
   * @param boardRepVo
   * @return 
   * Method 설명 : 게시글 댓글 입력
   */
  @Override
  public int insertBoardRep(BoardRepVo boardRepVo) {
    SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
    int insertCnt = sqlSession.insert("jspboard.board.dao.insertBoardRep", boardRepVo);
    sqlSession.commit();
    sqlSession.close();
    return insertCnt;
  }

  /** 
   * Method   : deleteBoardRep
   * 최초작성일  : 2018. 2. 6. 
   * 작성자 : jw
   * 변경이력 : 
   * @param repNo
   * @return 
   * Method 설명 : 게시글 댓글 삭제
   */
  @Override
  public int deleteBoardRep(int repNo) {
    SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
    int deleteCnt = sqlSession.update("jspboard.board.dao.insertBoardRep", repNo);
    sqlSession.commit();
    sqlSession.close();
    return deleteCnt;
  }

  /** 
   * Method   : modifyBoardRep
   * 최초작성일  : 2018. 2. 6. 
   * 작성자 : jw
   * 변경이력 : 
   * @param boardRepVo
   * @return 
   * Method 설명 : 게시글 댓글 수정
   */
  @Override
  public int modifyBoardRep(BoardRepVo boardRepVo) {
    SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
    int modifyCnt = sqlSession.update("jspboard.board.dao.modifyBoardRep", boardRepVo);
    sqlSession.commit();
    sqlSession.close();
    return modifyCnt;
  }

}
