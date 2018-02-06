package jspboard.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jspboard.board.model.BoardRepVo;
import jspboard.test.InitDbUtil;

public class BoardRepDaoTest extends InitDbUtil{

  private IboardRepDao boardRepDao;
  
  @Before
  public void boardRepDaoSetup() {
    boardRepDao = new BoardRepDao();
  }

  //게시물 댓글 조회
  @Test
  public void getboardRepListTest() {
    /***Given***/
    int boardNo = 1;

    /***When***/
    List<BoardRepVo> boardRepList = boardRepDao.getBoardRepList(sqlSession, boardNo);

    /***Then***/
    assertEquals(2, boardRepList.size());
  }
  
  //게시물 댓글 입력
  @Test
  public void insertBoardRepTest() {
    /***Given***/
    BoardRepVo boardRepVo = new BoardRepVo();
    boardRepVo.setBoardNo(1);
    boardRepVo.setContent("게시글 댓글입니다.");
    boardRepVo.setDelYn("N");
    boardRepVo.setRegId("brown");
    
    /***When***/
    int insertCnt = boardRepDao.insertBoardRep(sqlSession, boardRepVo);

    /***Then***/
    assertEquals(1, insertCnt);
  }
  
  //게시물 댓글 삭제
  @Test
  public void deleteBoardRepTest() {
    /***Given***/
    int repNo = 1;

    /***When***/
    int deleteCnt = boardRepDao.deleteBoardRep(sqlSession, repNo);

    /***Then***/
    assertEquals(1, deleteCnt);
  }
  
  //게시물 댓글 수정
  @Test
  public void modifyBoardRepTest() {
    /***Given***/
    BoardRepVo boardRepVo = new BoardRepVo();
    boardRepVo.setRepNo(1);
    boardRepVo.setContent("게시글 댓글 수정입니다.");

    /***When***/
    int modifyCnt = boardRepDao.modifyBoardRep(sqlSession, boardRepVo);
    
    /***Then***/
    assertEquals(1, modifyCnt);
  }
}
