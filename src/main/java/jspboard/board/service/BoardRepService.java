package jspboard.board.service;

import jspboard.board.model.BoardRepVo;

/**
 * 게시글 댓글 서비스
 * BoardRepService.java
 * 
 * @author jw
 * @since 2018. 2. 6.
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2018. 2. 6.    jw				최초 생성
 *
 * </pre>
 */
public interface BoardRepService {

  /** 
   * Method   : insertBoardRep
   * 최초작성일  : 2018. 2. 6. 
   * 작성자 : jw
   * 변경이력 : 
   * @param boardRepVo
   * @return 
   * Method 설명 : 게시글 댓글 입력
   */
  int insertBoardRep(BoardRepVo boardRepVo);

  /** 
   * Method   : deleteBoardRep
   * 최초작성일  : 2018. 2. 6. 
   * 작성자 : jw
   * 변경이력 : 
   * @param repNo
   * @return 
   * Method 설명 : 게시글 댓글 삭제
   */
  int deleteBoardRep(int repNo);

  /** 
   * Method   : modifyBoardRep
   * 최초작성일  : 2018. 2. 6. 
   * 작성자 : jw
   * 변경이력 : 
   * @param boardRepVo
   * @return 
   * Method 설명 : 게시글 댓글 수정
   */
  int modifyBoardRep(BoardRepVo boardRepVo);

}
