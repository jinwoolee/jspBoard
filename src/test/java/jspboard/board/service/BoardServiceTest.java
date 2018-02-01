package jspboard.board.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jspboard.board.model.BoardVo;
import jspboard.board.service.BoardService;
import jspboard.board.service.BoardServiceImpl;
import jspboard.test.InitDbUtil;

@SuppressWarnings("unchecked")
public class BoardServiceTest extends InitDbUtil{
	private	Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);
	private	BoardService boardService;
	
	@Before
	public void setUp() {
		boardService = new BoardServiceImpl();
	}
	
	//게시물 페이징 조회 테스트 (총 게시물 14건, 페이지 1)
	@Test
	public void getBoardPagingListPage1Test() {
		/***Given***/
		//1번 게시판의 1페이지, 페이지 사이즈 10
		BoardVo boardVo = new BoardVo(1, 1, 10);

		/***When***/
		//게시판 리스트
		Map<String, Object> resultMap = boardService.getBoardPagingList(boardVo);
		List<BoardVo> boardList = (List<BoardVo>)resultMap.get("boardList");
		
		//게시물 총 건수
		Integer boardTotalCnt = (Integer)resultMap.get("boardTotalCnt");
		logger.debug("totalCnt : {}", boardTotalCnt);
		
		/***Then***/
		assertEquals(10, boardList.size());
		assertEquals(new Integer(13), boardList.get(9).getBoardNo());	//테스트 데이터 조회한 게시판 계층 쿼리의 마지막 게시물은 13번
		
		assertEquals(14, boardTotalCnt.intValue());						//총 게시물은 14건		
	}
	
	//게시글 삭제
	@Test
	public void deleteBoardTest() {
		/***given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardNo(1);
		
		/***when***/
		int deleteCnt = boardService.deleteBoard(boardVo);
		
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
		int insertCnt = boardService.insertBoard(boardVo);

		/***then***/
		assertEquals(1, insertCnt);
	}
}
