package jspboard.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import jspboard.board.dao.BoardDao;
import jspboard.board.dao.BoardFileDao;
import jspboard.board.dao.IBoardDao;
import jspboard.board.dao.IBoardFileDao;
import jspboard.board.model.BoardFileVo;
import jspboard.board.model.BoardVo;
import jspboard.mybatis.SqlMapSessionFactory;

/**
 * @author jw
 *
 */
public class BoardServiceImpl implements BoardService {

	private IBoardDao boardDao = new BoardDao();
	private IBoardFileDao boardFileDao = new BoardFileDao();

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

		resultMap.put("boardList", boardList);
		resultMap.put("boardTotalCnt", boardTotalCnt);

		sqlSession.close();
		return resultMap;
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
		int modifyCnt = boardDao.modifyBoard(sqlSession, boardVo);
		
		if(boardFileList != null) {
	  		for(BoardFileVo boardFileVo : boardFileList) {
	  			boardFileVo.setBoardNo(boardVo.getBoardNo());
	  			boardFileDao.insertBoardFile(sqlSession, boardFileVo);
	  		}
		}
		
		sqlSession.commit();
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
		int deleteCnt = boardDao.deleteBoard(sqlSession, boardVo);
		boardFileDao.deleteBoardFile(sqlSession, boardVo.getBoardNo());
		sqlSession.commit();
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

		int insertCnt = sqlSession.insert("jspboard.board.dao.insertBoard", boardVo);
		
		if(boardFileList != null) {
	  		for(BoardFileVo boardFileVo : boardFileList) {
	  			boardFileVo.setBoardNo(boardVo.getBoardNo());
	  			boardFileDao.insertBoardFile(sqlSession, boardFileVo);
	  		}
		}
		
		sqlSession.commit();
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
		int deleteCnt = boardFileDao.deleteBoardFile(sqlSession, fileNo);
		sqlSession.commit();
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
