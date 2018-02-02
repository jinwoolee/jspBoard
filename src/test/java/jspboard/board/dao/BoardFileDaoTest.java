package jspboard.board.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jspboard.board.model.BoardFileVo;
import jspboard.test.InitDbUtil;

public class BoardFileDaoTest extends InitDbUtil{

  private IBoardFileDao boardFileDao;
  
  @Before
  public void daoSetup() {
    boardFileDao = new BoardFileDao();
  }
  
  //게시물 첨부파일 리스트 조회
  @Test
  public void getBoardFileListTest() {
    /***Given***/
    int boardNo = 1;

    /***When***/
    List<BoardFileVo> boardFileList = boardFileDao.getBoardFileList(sqlSession, boardNo);

    /***Then***/
    assertEquals(3, boardFileList.size());
  }
  
  //게시물 첨부파일 입력
  @Test
  public void insertBoardFile() {
    /***Given***/
    BoardFileVo boardFileVo = new BoardFileVo();
    boardFileVo.setBoardNo(1);
    boardFileVo.setFileNm("sally.png");
    boardFileVo.setFileOrgNm("sally.png");
    boardFileVo.setFilePath("/uploadFolder/");
    boardFileVo.setFileType("image/png");
    boardFileVo.setFileSize(2308);
    
    /***When***/
    int insertCnt = boardFileDao.insertBoardFile(sqlSession, boardFileVo);
    
    /***Then***/
    assertEquals(1, insertCnt);
  }
}
