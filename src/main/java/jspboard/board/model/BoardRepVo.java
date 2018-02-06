package jspboard.board.model;

import java.util.Date;

public class BoardRepVo {
  private  int     repNo;      //댓글 번호
  private  int     boardNo;    //게시글 번호
  private  String  content;    //댓글내용
  private  String  delYn;      //삭제여부
  private  String  regId;      //등록자 아이디
  private  Date    regDt;      //등록일시
  
  public int getRepNo() {
    return repNo;
  }
  public void setRepNo(int repNo) {
    this.repNo = repNo;
  }
  public int getBoardNo() {
    return boardNo;
  }
  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getDelYn() {
    return delYn;
  }
  public void setDelYn(String delYn) {
    this.delYn = delYn;
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
    return "BoardRepVo [repNo=" + repNo + ", boardNo=" + boardNo + ", content=" + content
        + ", delYn=" + delYn + ", regId=" + regId + ", regDt=" + regDt + "]";
  }
}
