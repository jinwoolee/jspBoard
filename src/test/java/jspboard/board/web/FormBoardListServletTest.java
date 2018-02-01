package jspboard.board.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import jspboard.board.model.BoardVo;
import jspboard.test.InitDbUtil;

public class FormBoardListServletTest extends InitDbUtil{
	private Logger logger = LoggerFactory.getLogger(FormBoardListServletTest.class);

	// mocking test fail ㅠ_ㅠ
	public void doGetTest() throws Exception {
		/*** Given ***/
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(printWriter);

		/*** When ***/
		new FormBoardListServlet().doGet(request, response);

		/*** Then ***/
		logger.debug("{}", stringWriter.getBuffer().toString());
	}

	@Test
	public void doGetSpringTest() throws ServletException, IOException {
		/*** Given ***/
		HttpServletRequest request = new MockHttpServletRequest();
		HttpServletResponse response = new MockHttpServletResponse();

		/*** When ***/
		new FormBoardListServlet().doGet(request, response);

		/*** Then ***/
		List<BoardVo> boardList = (List<BoardVo>) request.getAttribute("boardList");
		int boardTotalCnt = (Integer) request.getAttribute("boardTotalCnt");

		assertEquals(10, boardList.size());
		assertEquals(14, boardTotalCnt);
	}
}
