package jspboard.board.service;

import java.util.List;
import java.util.Map;

import jspboard.board.model.BoardFileVo;
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
	 * @param boardFileList 
	 * @프로그램 설명 :게시판 수정
	 */
	int modifyBoard(BoardVo boardVo, List<BoardFileVo> boardFileList);

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
	 * @param boardFileList 
	 * @return
	 * @프로그램 설명 : 게시글 입력
	 */
	int insertBoard(BoardVo boardVo, List<BoardFileVo> boardFileList);

	/**
	  * @FileName : BoardService.java
	  * @Project : jspBoard
	  * @Date : 2018. 2. 5.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param boardNo
	  * @return
	  * @프로그램 설명 : 게시글 첨부파일 삭제 
	  */
	int deleteBoardFile(int fileNo);

  /** 
   * Method   : getBoardFile
   * 최초작성일  : 2018. 2. 5. 
   * 작성자 : jw
   * 변경이력 : 
   * @param fileNo
   * @return 
   * Method 설명 : 게시글 첨부파일 조회
   */
  BoardFileVo getBoardFile(int fileNo);

}
