package jspBoard.board.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jspBoard.board.model.BoardVo;
import jspBoard.test.InitDbUtil;

public class BoardDaoTest extends InitDbUtil{
	private	Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);
	private	IBoardDao boardDao;
	
	@Before
	public void setUp() {
		boardDao = new BoardDao();
	}
	
	//게시물 페이징 조회 테스트 (총 게시물 14건, 페이지 1)
	@Test
	public void getBoardPagingListPage1Test() {
		/***Given***/
		//1번 게시판의 1페이지, 페이지 사이즈 10
		BoardVo boardVo = new BoardVo(1, 1, 10);

		/***When***/
		List<BoardVo> boardList = boardDao.getBoardPagingList(sqlSession, boardVo);
		for(BoardVo vo : boardList)
			logger.debug("{}", vo);
		
		/***Then***/
		assertEquals(10, boardList.size());
		assertEquals(new Integer(13), boardList.get(9).getBoardNo());	//테스트 데이터 조회한 게시판 계층 쿼리의 마지막 게시물은 13번		
	}
	
	//게시물 페이징 조회 테스트 (총 게시물 14건, 페이지 2)
	@Test
	public void getBoardPagingListPage2Test() {
		
		/***Given***/
		//1번 게시판의 2페이지, 페이지 사이즈 10
		BoardVo boardVo = new BoardVo(1, 2, 10);

		/***When***/
		List<BoardVo> boardList = boardDao.getBoardPagingList(sqlSession, boardVo);
		
		/***Then***/
		assertEquals(4, boardList.size());
		assertEquals(new Integer(1), boardList.get(3).getBoardNo());	//테스트 데이터 조회한 게시판 계층 쿼리의 마지막 게시물은 13번		
	}
	
	//게시물 전체 건수 조회
	@Test
	public void getBoardTotalCnt() {
		/***given***/
		BoardVo boardVo = new BoardVo(1, 1, 10);
		
		/***when***/
		Integer boardTotalCnt = boardDao.getBoardTotalCnt(sqlSession, boardVo);
		logger.debug("boardTotalCnt : {} ", boardTotalCnt);
		
		/***then***/
		assertEquals(14, boardTotalCnt.intValue());
	}
	
	//게시글 상세조회
	@Test
	public void getBoardDetailTest() {
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardNo(1);

		/***When***/
		BoardVo getResultVo = boardDao.getBoardDetail(sqlSession, boardVo);
		logger.debug("get result : {}", getResultVo);

		/***Then***/
		assertEquals(1, getResultVo.getBoardNo().intValue());
	}
	
	//게시글 수정
	@Test
	public void modifyBoardTest() {
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardNo(1);
		boardVo.setTitle("제목 수정입니다.");
		boardVo.setContent("내용 수정입니다.");
		boardVo.setRegId("brown");

		/***When***/
		int modifyCnt = boardDao.modifyBoard(sqlSession, boardVo);

		/***Then***/
		assertEquals(1, modifyCnt);
	}
	
	//게시글 삭제
	@Test
	public void deleteBoardTest() {
		/***given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardNo(1);
		
		/***when***/
		int deleteCnt = boardDao.deleteBoard(sqlSession, boardVo);
		
		/***then***/
		assertEquals(1, deleteCnt);
	}
	
	//게시글 입력
	@Test
	public void insertBoardTest() {
		/***given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardNo(15);
		boardVo.setPboardNo(0);
		boardVo.setCategoryNo(1);
		boardVo.setTitle("제목 수정입니다.");
		boardVo.setContent("내용 수정입니다.");
		boardVo.setDelYn("N");
		boardVo.setOrd(0);
		boardVo.setReadCnt(0);
		boardVo.setRegId("brown");
		
		/***when***/
		int insertCnt = boardDao.insertBoard(sqlSession, boardVo);

		/***then***/
		assertEquals(1, insertCnt);
	}
}
