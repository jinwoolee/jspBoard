
--select * from notexistsBoard where rownum =1;

DELETE boardrep;
DELETE boardfile;-- where boardno between 1 and 15;
DELETE board;-- where boardno between 1 and 15;
DELETE boardCategory;-- where categoryNo in (1,2,3);
DELETE member;-- where userid in ('brown', 'sally', 'cony', 'moon');

DELETE msg;

--------------------------------초기 데이터 생성 START-------------------------------------------
INSERT INTO member (userId, userNm, userAlias, addr, addr2, zipcode, usergb) VALUES ('brown', '브라운', '곰탱이', '', '', '', 'ADMIN');
INSERT INTO member (userId, userNm, userAlias, addr, addr2, zipcode, usergb) VALUES ('cony', '코니', '토끼', '', '', '', 'ADMIN');
INSERT INTO member (userId, userNm, userAlias, addr, addr2, zipcode, usergb) VALUES ('sally', '샐리', '병아리', '', '', '', 'ADMIN');
INSERT INTO member (userId, userNm, userAlias, addr, addr2, zipcode, usergb) VALUES ('moon', '문', '이클립스', '', '', '', 'ADMIN');

INSERT INTO boardCategory (categoryNo, code, memo, actyn, regId, regDt) VALUES (1, 'board001', '공지사항', 'Y', 'brown', sysdate);
INSERT INTO boardCategory (categoryNo, code, memo, actyn, regId, regDt) VALUES (2, 'board002', '경조사',  'Y', 'sally', sysdate);
INSERT INTO boardCategory (categoryNo, code, memo, actyn, regId, regDt) VALUES (3, 'board003', '자유게시판',  'Y', 'cony', sysdate);

INSERT INTO board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) VALUES (1, 0, 1, '1번 글입니다.', '1번글 내용입니다.', 'N', 0, 0, 'brown', sysdate);
INSERT INTO board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) VALUES (2, 0, 1, '2번 글입니다.', '2번글 내용입니다.', 'N', 0, 0, 'cony', sysdate);
INSERT INTO board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) VALUES (3, 0, 1, '3번 글입니다.', '3번글 내용입니다.', 'N', 0, 0, 'sally', sysdate);
INSERT INTO board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) VALUES (4, 0, 1, '4번 글입니다.', '4번글 내용입니다.', 'N', 0, 0, 'moon', sysdate);
INSERT INTO board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) VALUES (5, 4, 1, '5번 글은 4번글의 하위 글입니다.', '5번글 내용입니다.', 'N', 1, 0, 'brown', sysdate); --lv1
INSERT INTO board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) VALUES (6, 5, 1, '6번 글은 5번글(4번글의 하위)의 하위 글입니다.', '6번글 내용입니다.', 'N', 1, 0, 'sally', sysdate); --lv2
INSERT INTO board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) VALUES (7, 5, 1, '7번 글은 5번글의 하위 글입니다.', '7번글 내용입니다.', 'N', 2, 0, 'brown', sysdate); --lv2
INSERT INTO board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) VALUES (8, 0, 1, '8번 글입니다.', '8번글 내용입니다.', 'N', 0, 0, 'cony', sysdate);
INSERT INTO board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) VALUES (9, 0, 1, '9번 글입니다.', '9번글 내용입니다.', 'N', 0, 0, 'brown', sysdate);
INSERT INTO board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) VALUES (10, 4, 1, '10번 글은 4번의 하위 글입니다.', '10번글 내용입니다.', 'N', 2, 0, 'sally', sysdate);
INSERT INTO board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) VALUES (11, 0, 1, '11번 글입니다.', '11번글 내용입니다.', 'N', 0, 0, 'sally', sysdate);
INSERT INTO board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) VALUES (12, 0, 1, '12번 글입니다.', '12번글 내용입니다.', 'N', 0, 0, 'brown', sysdate);
INSERT INTO board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) VALUES (13, 7, 1, '13번은 7번글의 하위 글입니다.', '13번글 내용입니다.', 'N', 1, 0, 'sally', sysdate);
INSERT INTO board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) VALUES (14, 6, 1, '14번은 6번글의 하위 글입니다.', '14번글 내용입니다.', 'N', 1, 0, 'moon', sysdate);

INSERT INTO boardfile (fileno, boardno, fileorgnm, filenm, filepath, filetype, filesize) VALUES (1, 1, 'brown.png', 'brown.png', '/uploadFolder/', 'image/png', 5123);
INSERT INTO boardfile (fileno, boardno, fileorgnm, filenm, filepath, filetype, filesize) VALUES (2, 1, 'sally.png', 'sally.png', '/uploadFolder/', 'image/png', 5123);
INSERT INTO boardfile (fileno, boardno, fileorgnm, filenm, filepath, filetype, filesize) VALUES (3, 1, 'cony.png', 'cony.png', '/uploadFolder/', 'image/png', 5123);

INSERT INTO boardfile (fileno, boardno, fileorgnm, filenm, filepath, filetype, filesize) VALUES (4, 12, 'brown.png', 'brown.png', '/uploadFolder/', 'image/png', 5123);
INSERT INTO boardfile (fileno, boardno, fileorgnm, filenm, filepath, filetype, filesize) VALUES (5, 12, 'sally.png', 'sally.png', '/uploadFolder/', 'image/png', 5123);
INSERT INTO boardfile (fileno, boardno, fileorgnm, filenm, filepath, filetype, filesize) VALUES (6, 12, 'cony.png', 'cony.png', '/uploadFolder/', 'image/png', 5123);

INSERT INTO boardrep (repNo, boardNo, content, delYn, regid, regdt) VALUES (1, 1, '첫번째 댓글입니다.', 'N', 'brown', sysdate);
INSERT INTO boardrep (repNo, boardNo, content, delYn, regid, regdt) VALUES (2, 1, '두번째 댓글입니다.', 'N', 'cony', sysdate);

INSERT INTO boardrep (repNo, boardNo, content, delYn, regid, regdt) VALUES (3, 12, '첫번째 댓글입니다.', 'N', 'brown', sysdate);
INSERT INTO boardrep (repNo, boardNo, content, delYn, regid, regdt) VALUES (4, 12, '두번째 댓글입니다.', 'N', 'cony', sysdate);

--------------------------------초기 데이터 생성 END-------------------------------------------


--테스트 입력시 생성된 데이터 삭제
--DELETE boardCategory where categoryNo in (5);	--boarcCategory 입력테스트


--sequence
DROP SEQUENCE seq_board;
CREATE SEQUENCE seq_board START WITH 15 INCREMENT BY 1 CACHE 20 NOCYCLE;

DROP SEQUENCE seq_boardFile;
CREATE SEQUENCE seq_boardFile START WITH 7 INCREMENT BY 1 CACHE 20 NOCYCLE;

DROP SEQUENCE seq_board_rep;
CREATE SEQUENCE seq_board_rep START WITH 5 INCREMENT BY 1 CACHE 20 NOCYCLE;