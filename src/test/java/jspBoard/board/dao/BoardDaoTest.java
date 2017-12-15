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
}
