package jspBoard.board.web;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

public class FormBoardListServletMockTest {

	@Test
	public void doGetTest() throws Exception{
		/***Given***/
		HttpServletRequest	request		=	mock(HttpServletRequest.class);
		HttpServletResponse	response	=	mock(HttpServletResponse.class);

		/***When***/
		new FormBoardServlet().doGet(request, response);;

		/***Then***/
	}

}
