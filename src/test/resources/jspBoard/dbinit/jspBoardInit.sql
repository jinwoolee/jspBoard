
--select * from notexistsBoard where rownum =1;


--15 : 입력 테스트 데이터
delete boardfile;-- where boardno between 1 and 15;
delete board;-- where boardno between 1 and 15;
delete boardCategory;-- where categoryNo in (1,2,3);
delete member;-- where userid in ('brown', 'sally', 'cony', 'moon');

delete msg;

--------------------------------초기 데이터 생성 START-------------------------------------------
insert into member (userId, userNm, userAlias, addr, addr2, zipcode, usergb) values ('brown', '브라운', '곰탱이', '', '', '', 'ADMIN');
insert into member (userId, userNm, userAlias, addr, addr2, zipcode, usergb) values ('cony', '코니', '토끼', '', '', '', 'ADMIN');
insert into member (userId, userNm, userAlias, addr, addr2, zipcode, usergb) values ('sally', '샐리', '병아리', '', '', '', 'ADMIN');
insert into member (userId, userNm, userAlias, addr, addr2, zipcode, usergb) values ('moon', '문', '이클립스', '', '', '', 'ADMIN');

insert into boardCategory (categoryNo, code, memo, actyn, regId, regDt) values (1, 'board001', '공지사항', 'Y', 'brown', sysdate);
insert into boardCategory (categoryNo, code, memo, actyn, regId, regDt) values (2, 'board002', '경조사',  'Y', 'sally', sysdate);
insert into boardCategory (categoryNo, code, memo, actyn, regId, regDt) values (3, 'board003', '자유게시판',  'Y', 'cony', sysdate);

insert into board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) values (1, 0, 1, '1번 글입니다.', '1번글 내용입니다.', 'N', 0, 0, 'brown', sysdate);
insert into board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) values (2, 0, 1, '2번 글입니다.', '2번글 내용입니다.', 'N', 0, 0, 'cony', sysdate);
insert into board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) values (3, 0, 1, '3번 글입니다.', '3번글 내용입니다.', 'N', 0, 0, 'sally', sysdate);
insert into board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) values (4, 0, 1, '4번 글입니다.', '4번글 내용입니다.', 'N', 0, 0, 'moon', sysdate);
insert into board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) values (5, 4, 1, '5번 글은 4번글의 하위 글입니다.', '5번글 내용입니다.', 'N', 1, 0, 'brown', sysdate); --lv1
insert into board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) values (6, 5, 1, '6번 글은 5번글(4번글의 하위)의 하위 글입니다.', '6번글 내용입니다.', 'N', 1, 0, 'sally', sysdate); --lv2
insert into board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) values (7, 5, 1, '7번 글은 5번글의 하위 글입니다.', '7번글 내용입니다.', 'N', 2, 0, 'brown', sysdate); --lv2
insert into board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) values (8, 0, 1, '8번 글입니다.', '8번글 내용입니다.', 'N', 0, 0, 'cony', sysdate);
insert into board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) values (9, 0, 1, '9번 글입니다.', '9번글 내용입니다.', 'N', 0, 0, 'brown', sysdate);
insert into board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) values (10, 4, 1, '10번 글은 4번의 하위 글입니다.', '10번글 내용입니다.', 'N', 2, 0, 'sally', sysdate);
insert into board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) values (11, 0, 1, '11번 글입니다.', '11번글 내용입니다.', 'N', 0, 0, 'sally', sysdate);
insert into board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) values (12, 0, 1, '12번 글입니다.', '12번글 내용입니다.', 'N', 0, 0, 'brown', sysdate);
insert into board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) values (13, 7, 1, '13번은 7번글의 하위 글입니다.', '13번글 내용입니다.', 'N', 1, 0, 'sally', sysdate);
insert into board (boardNo, pBoardno, categoryNo, title, content, delYn, ord, readCnt, regId, regDt) values (14, 6, 1, '14번은 6번글의 하위 글입니다.', '14번글 내용입니다.', 'N', 1, 0, 'moon', sysdate);

insert into boardfile (fileno, boardno, filenm, filepath, filetype, filesize) values (1, 1, 'brown.png', 'upload/', 'png', 5123);
insert into boardfile (fileno, boardno, filenm, filepath, filetype, filesize) values (2, 1, 'sally.png', 'upload/', 'png', 5123);
insert into boardfile (fileno, boardno, filenm, filepath, filetype, filesize) values (3, 1, 'cony.png', 'upload/', 'png', 5123);

--------------------------------초기 데이터 생성 END-------------------------------------------


--테스트 입력시 생성된 데이터 삭제
--delete boardCategory where categoryNo in (5);	--boarcCategory 입력테스트


--sequence
drop SEQUENCE seq_board;
CREATE SEQUENCE seq_board  START WITH 15 INCREMENT BY 1 CACHE 20 NOCYCLE;