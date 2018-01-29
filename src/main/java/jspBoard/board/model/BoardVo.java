package jspBoard.board.model;

import java.util.Date;

/**
 * 게시물 vo
 * BoardVo.java
 * 
 * @author jw
 * @since 2017. 12. 15.
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2017. 12. 15.    jw				최초 생성
 *
 * </pre>
 */
public class BoardVo {
	private Integer boardNo;	//게시글 번호
	private Integer pboardNo;	//부모 게시글 번호
	private Integer categoryNo;	//게시판 카테고리 번호
	private String title;		//제목
	private String content;		//내용
	private Integer ord;		//그룹순서
	private String delYn;		//삭제여부
	private Integer readCnt;	//조회수
	private String regId;		//작성자
	private Date regDt;			//작성일시
	
	private	Integer	lv;			//계층 level
	private	Integer	rn;			//행 번호
	
	private	Integer	page;		//페이지
	private	Integer	pageSize;	//페이지 사이즈
	
	public BoardVo(int categoryNo, int page, int pageSize) {
		this.categoryNo	=	categoryNo;
		this.page		=	page;
		this.pageSize	=	pageSize;
	}
	public BoardVo() {
		
	}
	public Integer getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}
	public Integer getPboardNo() {
		return pboardNo;
	}
	public void setPboardNo(Integer pboardNo) {
		this.pboardNo = pboardNo;
	}
	public Integer getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Integer categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getOrd() {
		return ord;
	}
	public void setOrd(Integer ord) {
		this.ord = ord;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public Integer getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(Integer readCnt) {
		this.readCnt = readCnt;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regdt) {
		this.regDt = regdt;
	}
	public Integer getLv() {
		return lv;
	}
	public void setLv(Integer lv) {
		this.lv = lv;
	}
	public Integer getRn() {
		return rn;
	}
	public void setRn(Integer rn) {
		this.rn = rn;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "BoardVo [boardNo=" + boardNo + ", pboardNo=" + pboardNo + ", categoryNo=" + categoryNo + ", title="
				+ title + ", content=" + content + ", ord=" + ord + ", delYn=" + delYn + ", readCnt=" + readCnt
				+ ", regId=" + regId + ", regDt=" + regDt + "]";
	}
	
}
