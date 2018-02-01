package jspboard.boardCategory.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import jspboard.boardCategory.dao.BoardCategoryDao;
import jspboard.boardCategory.dao.IBoardCategoryDao;
import jspboard.boardCategory.model.BoardCategoryVo;
import jspboard.mybatis.SqlMapSessionFactoryTest;
import jspboard.test.InitDbUtil;

public class BoardCategoryDaoTest extends InitDbUtil {
	private Logger logger = LoggerFactory.getLogger(BoardCategoryDaoTest.class);
	private IBoardCategoryDao boardCategoryDao;

	@Before
	public void setUp() {
		boardCategoryDao = new BoardCategoryDao();
	}

	// 게시판 카테고리 조회 테스트
	@Test
	public void getBoardCategoryListTest() {
		/*** Given ***/

		/*** When ***/
		List<BoardCategoryVo> boardCategoryList = boardCategoryDao.getBoardCategoryList(sqlSession);
		for (BoardCategoryVo vo : boardCategoryList)
			logger.debug(vo.toString());

		/*** Then ***/
		assertEquals(3, boardCategoryList.size());
	}

	// 게시판 카테고리 입력 테스트
	@Test
	public void insertBoardCategoryTest() {
		/*** Given ***/
		BoardCategoryVo vo = new BoardCategoryVo(5, "board005", "junit테스트 입력", "Y", "brown");

		/*** When ***/
		int insertCnt = boardCategoryDao.insertCategory(sqlSession, vo);

		/*** Then ***/
		assertEquals(1, insertCnt);
	}

	// 게시판 카테고리 활성화/비활성화 테스트
	@Test
	public void activeBoardCategoryTest() {
		/*** Given ***/
		BoardCategoryVo vo = new BoardCategoryVo();
		vo.setCategoryNo(1);
		vo.setActYn("N");

		/*** When ***/
		int modifyCnt = boardCategoryDao.activeBoardCategory(sqlSession, vo);

		/*** Then ***/
		assertEquals(1, modifyCnt);
	}

	// 게시판 카테고리 조회 Test
	@Test
	public void getBoardCategoryTest() {
		/*** Given ***/
		BoardCategoryVo boardCategoryVo = new BoardCategoryVo();
		boardCategoryVo.setCategoryNo(1);

		/*** When ***/
		BoardCategoryVo resultVo = boardCategoryDao.getBoardCategory(sqlSession, boardCategoryVo);

		/*** Then ***/
		assertEquals("board001", resultVo.getCode());
		assertEquals(new Integer(1), resultVo.getCategoryNo());
	}

}
