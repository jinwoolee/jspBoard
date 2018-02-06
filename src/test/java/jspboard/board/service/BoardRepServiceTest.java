package jspboard.board.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jspboard.board.model.BoardRepVo;
import jspboard.test.InitDbUtil;

public class BoardRepServiceTest extends InitDbUtil{

  private BoardRepService boardRepService;
  
  @Before
  public void boardRepServiceSetup() {
    boardRepService = new BoardRepServiceImpl();
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
    int insertCnt = boardRepService.insertBoardRep(boardRepVo);

    /***Then***/
    assertEquals(1, insertCnt);
  }

  //게시물 댓글 삭제
  @Test
  public void deleteBoardRepTest() {
    /***Given***/
    int repNo = 1;

    /***When***/
    int deleteCnt = boardRepService.deleteBoardRep(repNo);

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
    int modifyCnt = boardRepService.modifyBoardRep(boardRepVo);

    /***Then***/
    assertEquals(1, modifyCnt);
  }
}
