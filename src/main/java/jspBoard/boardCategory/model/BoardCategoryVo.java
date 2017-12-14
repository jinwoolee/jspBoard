package jspBoard.boardCategory.model;

import java.util.Date;

/**
 * 게시판 카테고리 vo
 * BoardCategoryVo.java
 * 
 * @author jw
 * @since 2017. 12. 14.
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2017. 12. 14.    jw				최초 생성
 *
 * </pre>
 */
public class BoardCategoryVo {
	
	private	Integer	no;			//게시판 카테고리 번호
	private	String	code;		//카테고리 코드
	private	String	memo;		//카테고리 설명
	private	String	actYn;		//게시판 카테고리 활성화 여부		
	private	String	regId;		//작성자
	private	Date	regDt;		//작성일시
	
	public BoardCategoryVo(Integer no, String code, String memo, String actYn, String regId) {
		this.no		=	no;
		this.code	=	code;
		this.memo	=	memo;
		this.actYn	=	actYn;
		this.regId	=	regId;
	}

	public BoardCategoryVo() {
		
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getActYn() {
		return actYn;
	}

	public void setActYn(String actYn) {
		this.actYn = actYn;
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
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "BoardCategoryVo [no=" + no + ", code=" + code + ", memo=" + memo + ", actYn=" + actYn + ", regId="
				+ regId + ", regDt=" + regDt + "]";
	}
	
}
