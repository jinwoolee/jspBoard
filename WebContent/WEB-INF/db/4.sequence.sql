--게시물 번호
DROP SEQUENCE seq_board;
CREATE SEQUENCE seq_board START WITH 1 INCREMENT BY 1 CACHE 20 NOCYCLE;

--게시물 첨부파일 번호
DROP SEQUENCE seq_boardFile;
CREATE SEQUENCE seq_boardFile START WITH 1 INCREMENT BY 1 CACHE 20 NOCYCLE;