package jspboard.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import jspboard.board.dao.BoardDao;
import jspboard.board.dao.BoardFileDao;
import jspboard.board.dao.BoardRepDao;
import jspboard.board.dao.IBoardDao;
import jspboard.board.dao.IBoardFileDao;
import jspboard.board.dao.IBoardRepDao;
import jspboard.board.model.BoardFileVo;
import jspboard.board.model.BoardRepVo;
import jspboard.board.model.BoardVo;
import jspboard.mybatis.SqlMapSessionFactory;

/**
 * @author jw
 *
 */
public class BoardServiceImpl implements BoardService {

	private IBoardDao boardDao = new BoardDao();
	private IBoardFileDao boardFileDao = new BoardFileDao();
	private IBoardRepDao boardRepDao = new BoardRepDao();

	/**
	 * @FileName : BoardServiceImpl.java
	 * @Project : jspBoard
	 * @Date : 2018. 1. 29.
	 * @작성자 : jw
	 * @변경이력 :
	 * @param sqlSession
	 * @param boardVo
	 * @return
	 * @프로그램 설명 : 게시판 리스트 조회
	 */
	@Override
	public Map<String, Object> getBoardPagingList(BoardVo boardVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();

		// 게시물 건수 조회
		List<BoardVo> boardList = boardDao.getBoardPagingList(sqlSession, boardVo);

		// 게시물 전체 건수 조회
		Integer boardTotalCnt = boardDao.getBoardTotalCnt(sqlSession, boardVo);

		//페이지 네비게이션
		String pageNav = makePageNav(boardTotalCnt.intValue(), boardVo.getPage().intValue());
		
		resultMap.put("boardList", boardList);
		resultMap.put("boardTotalCnt", boardTotalCnt);
		resultMap.put("pageNav", pageNav);

		sqlSession.close();
		return resultMap;
	}

	/** 
	 * Method   : makePageNav
	 * 최초작성일  : 2018. 2. 8. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param intValue
	 * @param page
	 * @return 
	 * Method 설명 : 페이지 내비게이션
	 */
	public String makePageNav(int boardTotalCnt, int page) {
	  final int NUM_OF_PAGE_AT_NAVI = 10;
	  double totalPage = Math.ceil((double)boardTotalCnt/(double)NUM_OF_PAGE_AT_NAVI);
	  
	  String pageNav = "";
	  for(int i = 1; i <= totalPage; i++) {
	    if(page == i)
	      pageNav += "<li class=\"active\" ><a href=\"javascript:page('"+i + "');\">"+ i + "</a></li>";
	    else
	      pageNav += "<li><a href=\"javascript:page('"+i + "');\">"+ i + "</a></li>";
	  }
    return pageNav;
  }

  /**
	 * @FileName : BoardServiceImpl.java
	 * @Project : jspBoard
	 * @Date : 2018. 1. 29.
	 * @작성자 : jw
	 * @변경이력 :
	 * @param boardVo
	 * @return
	 * @프로그램 설명 : 게시글 상세조회
	 */
	@Override
	public BoardVo getBoardDetail(BoardVo boardVo) {
		SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
		
		BoardVo vo = boardDao.getBoardDetail(sqlSession, boardVo);
		
		//첨부파일 조회
		List<BoardFileVo> boardFileList = boardFileDao.getBoardFileList(sqlSession, boardVo.getBoardNo());
		vo.setBoardFileList(boardFileList);
		
		//게시글 댓글 조회
		List<BoardRepVo> boardRepList = boardRepDao.getBoardRepList(sqlSession, boardVo.getBoardNo());
		vo.setBoardRepList(boardRepList);
		
		sqlSession.close();
		
		return vo;
	}

	/**
	 * @FileName : BoardServiceImpl.java
	 * @Project : jspBoard
	 * @Date : 2018. 1. 29.
	 * @작성자 : jw
	 * @변경이력 :
	 * @param boardVo
	 * @프로그램 설명 : 게시글 수정
	 */
	@Override
	public int modifyBoard(BoardVo boardVo, List<BoardFileVo> boardFileList) {
		SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
		int modifyCnt = 0;
		
		try {
		  modifyCnt = boardDao.modifyBoard(sqlSession, boardVo);
	    
	    if(boardFileList != null) {
  	      for(BoardFileVo boardFileVo : boardFileList) {
  	        boardFileVo.setBoardNo(boardVo.getBoardNo());
  	        boardFileDao.insertBoardFile(sqlSession, boardFileVo);
  	      }
  	  }
	    sqlSession.commit();
		}catch(Exception e) {
		  sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return modifyCnt;
	}

	/**
	 * @FileName : BoardServiceImpl.java
	 * @Project : jspBoard
	 * @Date : 2018. 1. 29.
	 * @작성자 : jw
	 * @변경이력 :
	 * @param boardVo
	 * @return
	 * @프로그램 설명 : 게시글 삭제
	 */
	@Override
	public int deleteBoard(BoardVo boardVo) {
	  SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
	  
	  int deleteCnt = 0;
	  try {
	    deleteCnt = boardDao.deleteBoard(sqlSession, boardVo);
	    boardFileDao.deleteBoardFile(sqlSession, boardVo.getBoardNo());
	    sqlSession.commit();
	  }catch(Exception e) {
	    sqlSession.rollback();
	  }
		sqlSession.close();

		return deleteCnt;
	}

	/**
	 * @FileName : BoardServiceImpl.java
	 * @Project : jspBoard
	 * @Date : 2018. 1. 30.
	 * @작성자 : jw
	 * @변경이력 :
	 * @param boardVo
	 * @return
	 * @프로그램 설명 : 게시글 입력
	 */
	@Override
	public int insertBoard(BoardVo boardVo, List<BoardFileVo> boardFileList) {
		SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();

		int insertCnt=0;

		try {
		  insertCnt = sqlSession.insert("jspboard.board.dao.insertBoard", boardVo);
		  if(boardFileList != null) {
          for(BoardFileVo boardFileVo : boardFileList) {
            boardFileVo.setBoardNo(boardVo.getBoardNo());
            boardFileDao.insertBoardFile(sqlSession, boardFileVo);
          }
      }
		  sqlSession.commit();
		}catch(Exception e) {
		  sqlSession.rollback();
		}
		
		sqlSession.close();

		return insertCnt;
	}

	/**
	  * @FileName : BoardServiceImpl.java
	  * @Project : jspBoard
	  * @Date : 2018. 2. 5.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param boardNo
	  * @return
	  * @프로그램 설명 : 게시글 첨부파일 삭제  
	  */
	@Override
	public int deleteBoardFile(int fileNo) {
		SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
		int deleteCnt = 0;
		
		try {
		  deleteCnt = boardFileDao.deleteBoardFile(sqlSession, fileNo);
		  sqlSession.commit();
		}catch(Exception e) {
		  sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return deleteCnt;
	}

  /** 
   * Method   : getBoardFile
   * 최초작성일  : 2018. 2. 5. 
   * 작성자 : jw
   * 변경이력 : 
   * @param fileNo
   * @return 
   * Method 설명 : 게시글 첨부파일 조회
   */
  @Override
  public BoardFileVo getBoardFile(int fileNo) {
    SqlSession sqlSession = SqlMapSessionFactory.getSqlSessionFactory().openSession();
    BoardFileVo boardFileVo = boardFileDao.getBoardFile(sqlSession, fileNo);
    sqlSession.close();

    return boardFileVo;
  }
}
