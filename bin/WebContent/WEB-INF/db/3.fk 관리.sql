--게시물 자기참조(부모) 삭제
alter table board drop constraint FK_board_TO_board; 
	