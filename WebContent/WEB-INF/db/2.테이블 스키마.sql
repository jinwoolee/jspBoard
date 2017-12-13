/*게시판 카테고리*/
ALTER TABLE boardCategory
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_boardCategory;

/* 게시판 카테고리 */
DROP TABLE boardCategory 
	CASCADE CONSTRAINTS;

/* 게시판 카테고리 */
CREATE TABLE boardCategory (
	no NUMBER NOT NULL, /* 게시판 카테고리 번호 */
	code VARCHAR2(50) NOT NULL, /* 카테고리 코드 */
	memo VARCHAR2(200), /* 카테고리 설명 */
	reg_id VARCHAR2(50) NOT NULL /* 작성자 */
);

COMMENT ON TABLE boardCategory IS '게시판 카테고리';

COMMENT ON COLUMN boardCategory.no IS '게시판 카테고리 번호';

COMMENT ON COLUMN boardCategory.code IS '카테고리 코드';

COMMENT ON COLUMN boardCategory.memo IS '카테고리 설명';

COMMENT ON COLUMN boardCategory.reg_id IS '작성자';

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