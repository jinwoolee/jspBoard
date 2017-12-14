/* 게시판 카테고리 */
CREATE TABLE boardCategory (
	no NUMBER NOT NULL, /* 게시판 카테고리 번호 */
	code VARCHAR2(50) NOT NULL, /* 카테고리 코드 */
	memo VARCHAR2(200), /* 카테고리 설명 */
	ACTYN VARCHAR2(1) DEFAULT 'Y' NOT NULL, /* 활성화여부 */
	regId VARCHAR2(50) NOT NULL, /* 작성자 */
	regDt DATE NOT NULL /* 작성일시 */
);

COMMENT ON TABLE boardCategory IS '게시판 카테고리';

COMMENT ON COLUMN boardCategory.no IS '게시판 카테고리 번호';

COMMENT ON COLUMN boardCategory.code IS '카테고리 코드';

COMMENT ON COLUMN boardCategory.memo IS '카테고리 설명';

COMMENT ON COLUMN boardCategory.ACTYN IS '활성화여부';

COMMENT ON COLUMN boardCategory.regId IS '작성자';

COMMENT ON COLUMN boardCategory.regDt IS '작성일시';

CREATE UNIQUE INDEX PK_boardCategory
	ON boardCategory (
		no ASC
	);

ALTER TABLE boardCategory
	ADD
		CONSTRAINT PK_boardCategory
		PRIMARY KEY (
			no
		);

/* 게시판 */
CREATE TABLE board (
	boardNo NUMBER NOT NULL, /* 게시글 번호 */
	pboardNo NUMBER, /* 부모 게시글 번호 */
	no NUMBER NOT NULL, /* 게시판 카테고리 번호 */
	title VARCHAR(200) NOT NULL, /* 제목 */
	content CLOB NOT NULL, /* 내용 */
	ord NUMBER DEFAULT 0 NOT NULL, /* 그룹순서 */
	delYn VARCHAR2(1) DEFAULT 'N' NOT NULL, /* 삭제여부 */
	regid VARCHAR2(50) NOT NULL, /* 작성자 */
	regdt DATE NOT NULL /* 작성일시 */
);

COMMENT ON TABLE board IS '게시판';

COMMENT ON COLUMN board.boardNo IS '게시글 번호';

COMMENT ON COLUMN board.pboardNo IS '부모 게시글 번호';

COMMENT ON COLUMN board.no IS '게시판 카테고리 번호';

COMMENT ON COLUMN board.title IS '제목';

COMMENT ON COLUMN board.content IS '내용';

COMMENT ON COLUMN board.ord IS '그룹순서';

COMMENT ON COLUMN board.delYn IS '삭제여부';

COMMENT ON COLUMN board.regid IS '작성자';

COMMENT ON COLUMN board.regdt IS '작성일시';

CREATE UNIQUE INDEX PK_board
	ON board (
		boardNo ASC
	);

ALTER TABLE board
	ADD
		CONSTRAINT PK_board
		PRIMARY KEY (
			boardNo
		);

ALTER TABLE board
	ADD
		CONSTRAINT FK_boardCategory_TO_board
		FOREIGN KEY (
			no
		)
		REFERENCES boardCategory (
			no
		);

ALTER TABLE board
	ADD
		CONSTRAINT FK_board_TO_board
		FOREIGN KEY (
			pboardNo
		)
		REFERENCES board (
			boardNo
		);