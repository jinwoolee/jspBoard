package jspboard.board.model;

public class BoardFileVo {
  private int     fileNo;   //파일 번호
  private int     boardNo;  //게시판번호
  private String  fileNm;   //파일명
  private String  fileOrgNm;   //원본파일명
  private String  filePath; //파일경로
  private String  fileType; //파일타입
  private int     fileSize; //파일 사이즈
  
  public BoardFileVo() {
  }
  
  public int getFileNo() {
    return fileNo;
  }

  public void setFileNo(int fileNo) {
    this.fileNo = fileNo;
  }

  public int getBoardNo() {
    return boardNo;
  }

  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }

  public String getFileNm() {
    return fileNm;
  }

  public void setFileNm(String fileNm) {
    this.fileNm = fileNm;
  }

  public String getFileOrgNm() {
    return fileOrgNm;
  }

  public void setFileOrgNm(String fileOrgNm) {
    this.fileOrgNm = fileOrgNm;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public int getFileSize() {
    return fileSize;
  }

  public void setFileSize(int fileSize) {
    this.fileSize = fileSize;
  }

  @Override
  public String toString() {
    return "BoardFileVo [fileNo=" + fileNo + ", boardNo=" + boardNo + ", fileNm=" + fileNm
        + ", fileOrgNm=" + fileOrgNm + ", filePath=" + filePath + ", fileType=" + fileType
        + ", fileSize=" + fileSize + "]";
  }
}
