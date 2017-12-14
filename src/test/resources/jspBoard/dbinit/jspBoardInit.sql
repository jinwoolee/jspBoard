--초기 데이터 생성
delete board where boardno between 1 and 14;
delete boardCategory where no in (1,2,3);

insert into boardCategory (no, code, memo, actyn, regId, regDt) values (1, 'board001', '공지사항', 'Y', 'brown', sysdate);
insert into boardCategory (no, code, memo, actyn, regId, regDt) values (2, 'board002', '경조사',  'Y', 'sally', sysdate);
insert into boardCategory (no, code, memo, actyn, regId, regDt) values (3, 'board003', '자유게시판',  'Y', 'cony', sysdate);

insert into board (boardNo, pBoardno, no, title, content, delYn, ord, regId, regDt) values (1, '', 1, '1번 글입니다.', '1번글 내용입니다.', 'N', 0, 'brown', sysdate);
insert into board (boardNo, pBoardno, no, title, content, delYn, ord, regId, regDt) values (2, '', 1, '2번 글입니다.', '2번글 내용입니다.', 'N', 0, 'cony', sysdate);
insert into board (boardNo, pBoardno, no, title, content, delYn, ord, regId, regDt) values (3, '', 1, '3번 글입니다.', '3번글 내용입니다.', 'N', 0, 'sally', sysdate);
insert into board (boardNo, pBoardno, no, title, content, delYn, ord, regId, regDt) values (4, '', 1, '4번 글입니다.', '4번글 내용입니다.', 'N', 0, 'moon', sysdate);
insert into board (boardNo, pBoardno, no, title, content, delYn, ord, regId, regDt) values (5, 4, 1, '5번 글은 4번글의 하위 글입니다.', '5번글 내용입니다.', 'N', 1, 'brown', sysdate); --lv1
insert into board (boardNo, pBoardno, no, title, content, delYn, ord, regId, regDt) values (6, 5, 1, '6번 글은 5번글(4번글의 하위)의 하위 글입니다.', '6번글 내용입니다.', 'N', 1, 'sally', sysdate); --lv2
insert into board (boardNo, pBoardno, no, title, content, delYn, ord, regId, regDt) values (7, 5, 1, '7번 글은 5번글의 하위 글입니다.', '7번글 내용입니다.', 'N', 2, 'brown', sysdate); --lv2
insert into board (boardNo, pBoardno, no, title, content, delYn, ord, regId, regDt) values (8, '', 1, '8번 글입니다.', '8번글 내용입니다.', 'N', 0, 'cony', sysdate);
insert into board (boardNo, pBoardno, no, title, content, delYn, ord, regId, regDt) values (9, '', 1, '9번 글입니다.', '9번글 내용입니다.', 'N', 0, 'brown', sysdate);
insert into board (boardNo, pBoardno, no, title, content, delYn, ord, regId, regDt) values (10, 4, 1, '10번 글은 4번의 하위 글입니다.', '10번글 내용입니다.', 'N', 2, 'sally', sysdate);
insert into board (boardNo, pBoardno, no, title, content, delYn, ord, regId, regDt) values (11, '', 1, '11번 글입니다.', '11번글 내용입니다.', 'N', 0, 'sally', sysdate);
insert into board (boardNo, pBoardno, no, title, content, delYn, ord, regId, regDt) values (12, '', 1, '12번 글입니다.', '12번글 내용입니다.', 'N', 0, 'brown', sysdate);
insert into board (boardNo, pBoardno, no, title, content, delYn, ord, regId, regDt) values (13, 7, 1, '13번은 7번글의 하위 글입니다.', '13번글 내용입니다.', 'N', 1, 'sally', sysdate);
insert into board (boardNo, pBoardno, no, title, content, delYn, ord, regId, regDt) values (14, 6, 1, '14번은 6번글의 하위 글입니다.', '14번글 내용입니다.', 'N', 1, 'moon', sysdate);




--테스트 입력시 생성된 데이터 삭제
delete boardCategory where no in (5);	--boarcCategory 입력테스트