package jspboard.board.service;

import java.util.Map;

import jspboard.board.model.BoardVo;

public interface BoardService {

	/**
	  * @FileName : BoardService.java
	  * @Project : jspBoard
	  * @Date : 2018. 1. 29.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param sqlSession
	  * @param boardVo
	  * @return
	  * @프로그램 설명 : 게시판 리스트 조회
	  */
	Map<String, Object> getBoardPagingList(BoardVo boardVo);

	/**
	  * @FileName : BoardService.java
	  * @Project : jspBoard
	  * @Date : 2018. 1. 29.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param boardVo
	  * @return
	  * @프로그램 설명 : 게시판 상세조회
	  */
	BoardVo getBoardDetail(BoardVo boardVo);

	/**
	  * @FileName : BoardService.java
	  * @Project : jspBoard
	  * @Date : 2018. 1. 29.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param boardVo
	  * @프로그램 설명 :게시판 수정
	  */
	void modifyBoard(BoardVo boardVo);

	/**
	  * @FileName : BoardService.java
	  * @Project : jspBoard
	  * @Date : 2018. 1. 29.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param boardVo
	  * @return
	  * @프로그램 설명 : 게시글 삭제
	  */
	int deleteBoard(BoardVo boardVo);

	/**
	  * @FileName : BoardService.java
	  * @Project : jspBoard
	  * @Date : 2018. 1. 30.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param boardVo
	  * @return
	  * @프로그램 설명 : 게시글 입력
	  */
	int insertBoard(BoardVo boardVo);

}
