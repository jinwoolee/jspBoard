/* 게시판 카테고리 */
DROP TABLE boardCategory 
	CASCADE CONSTRAINTS;

/* 게시판 */
DROP TABLE board 
	CASCADE CONSTRAINTS;

/* 게시판 첨부파일 */
DROP TABLE boardFile 
	CASCADE CONSTRAINTS;

/* 게시판 댓글 */
DROP TABLE boardRep 
	CASCADE CONSTRAINTS;

/* 전사관련자 */
DROP TABLE member 
	CASCADE CONSTRAINTS;

/* 사용자 연락처 */
DROP TABLE userContact 
	CASCADE CONSTRAINTS;

/* 메세지 */
DROP TABLE MSG 
	CASCADE CONSTRAINTS;

/* 게시판 카테고리 */
CREATE TABLE boardCategory (
	categoryNo NUMBER NOT NULL, /* 게시판 카테고리 번호 */
	code VARCHAR2(50) NOT NULL, /* 카테고리 코드 */
	memo VARCHAR2(200), /* 카테고리 설명 */
	ACTYN VARCHAR2(1) DEFAULT 'Y' NOT NULL, /* 활성화여부 */
	regDt DATE NOT NULL, /* 작성일시 */
	regId VARCHAR2(50) NOT NULL /* 작성자 */
);

COMMENT ON TABLE boardCategory IS '게시판 카테고리';

COMMENT ON COLUMN boardCategory.categoryNo IS '게시판 카테고리 번호';

COMMENT ON COLUMN boardCategory.code IS '카테고리 코드';

COMMENT ON COLUMN boardCategory.memo IS '카테고리 설명';

COMMENT ON COLUMN boardCategory.ACTYN IS '활성화여부';

COMMENT ON COLUMN boardCategory.regDt IS '작성일시';

COMMENT ON COLUMN boardCategory.regId IS '작성자';

CREATE UNIQUE INDEX PK_boardCategory
	ON boardCategory (
		categoryNo ASC
	);

ALTER TABLE boardCategory
	ADD
		CONSTRAINT PK_boardCategory
		PRIMARY KEY (
			categoryNo
		);

/* 게시판 */
CREATE TABLE board (
	boardNo NUMBER NOT NULL, /* 게시글 번호 */
	pboardNo NUMBER, /* 부모 게시글 번호 */
	categoryNo NUMBER NOT NULL, /* 게시판 카테고리 번호 */
	title VARCHAR2(200) NOT NULL, /* 제목 */
	content CLOB NOT NULL, /* 내용 */
	ord NUMBER DEFAULT 0 NOT NULL, /* 그룹순서 */
	delYn VARCHAR2(1) DEFAULT 'N' NOT NULL, /* 삭제여부 */
	readCnt INTEGER DEFAULT 0 NOT NULL, /* 조회수 */
	regid VARCHAR2(50) NOT NULL, /* 작성자 */
	regdt DATE NOT NULL /* 작성일시 */
);

COMMENT ON TABLE board IS '게시판';

COMMENT ON COLUMN board.boardNo IS '게시글 번호';

COMMENT ON COLUMN board.pboardNo IS '부모 게시글 번호';

COMMENT ON COLUMN board.categoryNo IS '게시판 카테고리 번호';

COMMENT ON COLUMN board.title IS '제목';

COMMENT ON COLUMN board.content IS '내용';

COMMENT ON COLUMN board.ord IS '그룹순서';

COMMENT ON COLUMN board.delYn IS '삭제여부';

COMMENT ON COLUMN board.readCnt IS '조회수';

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

/* 게시판 첨부파일 */
CREATE TABLE boardFile (
    fileNo NUMBER NOT NULL, /* 첨부파일번호 */
    boardNo NUMBER, /* 게시글 번호 */
    fileOrgNm VARCHAR2(200), /* 원본파일명 */
    fileNm VARCHAR2(200) NOT NULL, /* 파일명 */
    filePath VARCHAR2(200) NOT NULL, /* 파일경로 */
    fileType VARCHAR2(100) NOT NULL, /* 파일유형 */
    fileSize INTEGER DEFAULT 0 NOT NULL /* 파일사이즈 */
);

COMMENT ON TABLE boardFile IS '게시판 첨부파일';

COMMENT ON COLUMN boardFile.fileNo IS '첨부파일번호';

COMMENT ON COLUMN boardFile.boardNo IS '게시글 번호';

COMMENT ON COLUMN boardFile.fileOrgNm IS '원본파일명';

COMMENT ON COLUMN boardFile.fileNm IS '파일명';

COMMENT ON COLUMN boardFile.filePath IS '파일경로';

COMMENT ON COLUMN boardFile.fileType IS '파일유형';

COMMENT ON COLUMN boardFile.fileSize IS '파일사이즈';

CREATE UNIQUE INDEX PK_boardFile
    ON boardFile (
        fileNo ASC
    );

ALTER TABLE boardFile
    ADD
        CONSTRAINT PK_boardFile
        PRIMARY KEY (
            fileNo
        );

ALTER TABLE boardFile
    ADD
        CONSTRAINT FK_board_TO_boardFile
        FOREIGN KEY (
            boardNo
        )
        REFERENCES board (
            boardNo
        );

/* 게시판 댓글 */
CREATE TABLE boardRep (
	repNo NUMBER NOT NULL, /* 댓글번호 */
	boardNo NUMBER NOT NULL, /* 게시글 번호 */
	content VARCHAR2(1500) NOT NULL, /* 댓글내용 */
	delYn VARCHAR2(1) DEFAULT 'N' NOT NULL, /* 삭제여부 */
	regid VARCHAR2(50) NOT NULL, /* 작성자 */
	regdt DATE NOT NULL /* 작성일시 */
);

COMMENT ON TABLE boardRep IS '게시판 댓글';

COMMENT ON COLUMN boardRep.repNo IS '댓글번호';

COMMENT ON COLUMN boardRep.boardNo IS '게시글 번호';

COMMENT ON COLUMN boardRep.content IS '댓글내용';

COMMENT ON COLUMN boardRep.delYn IS '삭제여부';

COMMENT ON COLUMN boardRep.regid IS '작성자';

COMMENT ON COLUMN boardRep.regdt IS '작성일시';

CREATE UNIQUE INDEX PK_boardRep
	ON boardRep (
		repNo ASC
	);

ALTER TABLE boardRep
	ADD
		CONSTRAINT PK_boardRep
		PRIMARY KEY (
			repNo
		);

/* 전사관련자 */
CREATE TABLE member (
	userId VARCHAR2(50) NOT NULL, /* 사용자아이디 */
	userNm VARCHAR2(50) NOT NULL, /* 사용자이름 */
	userAlias VARCHAR2(50) NOT NULL, /* 닉네임 */
	addr VARCHAR2(255), /* 주소 */
	addr2 VARCHAR2(255), /* 상세주소 */
	zipcode VARCHAR2(5), /* 우편번호 */
	userGb VARCHAR2(10) DEFAULT 'USER' NOT NULL /* 사용자구분 */
);

COMMENT ON TABLE member IS '전사관련자';

COMMENT ON COLUMN member.userId IS '사용자아이디';

COMMENT ON COLUMN member.userNm IS '사용자이름';

COMMENT ON COLUMN member.userAlias IS '닉네임';

COMMENT ON COLUMN member.addr IS '주소';

COMMENT ON COLUMN member.addr2 IS '상세주소';

COMMENT ON COLUMN member.zipcode IS '우편번호';

COMMENT ON COLUMN member.userGb IS '사용자구분';

CREATE UNIQUE INDEX PK_member
	ON member (
		userId ASC
	);

ALTER TABLE member
	ADD
		CONSTRAINT PK_member
		PRIMARY KEY (
			userId
		);

/* 사용자 연락처 */
CREATE TABLE userContact (
	userId VARCHAR2(50) NOT NULL, /* 사용자아이디 */
	contactGb VARCHAR2(10) NOT NULL, /* 연락처구분코드 */
	contact VARCHAR2(50) NOT NULL /* 연락처 */
);

COMMENT ON TABLE userContact IS '사용자 연락처';

COMMENT ON COLUMN userContact.userId IS '사용자아이디';

COMMENT ON COLUMN userContact.contactGb IS '연락처구분코드';

COMMENT ON COLUMN userContact.contact IS '연락처';

CREATE UNIQUE INDEX PK_userContact
	ON userContact (
		userId ASC,
		contactGb ASC
	);

ALTER TABLE userContact
	ADD
		CONSTRAINT PK_userContact
		PRIMARY KEY (
			userId,
			contactGb
		);

/* 메세지 */
CREATE TABLE MSG (
	lang VARCHAR2(10) NOT NULL, /* 언어코드 */
	msgCd VARCHAR2(20) NOT NULL, /* 메세지코드 */
	msg VARCHAR2(1000) NOT NULL /* 메세지 */
);

COMMENT ON TABLE MSG IS '메세지';

COMMENT ON COLUMN MSG.lang IS '언어코드';

COMMENT ON COLUMN MSG.msgCd IS '메세지코드';

COMMENT ON COLUMN MSG.msg IS '메세지';

CREATE UNIQUE INDEX PK_MSG
	ON MSG (
		lang ASC,
		msgCd ASC
	);

ALTER TABLE MSG
	ADD
		CONSTRAINT PK_MSG
		PRIMARY KEY (
			lang,
			msgCd
		);

ALTER TABLE boardCategory
	ADD
		CONSTRAINT FK_member_TO_boardCategory
		FOREIGN KEY (
			regId
		)
		REFERENCES member (
			userId
		);

ALTER TABLE board
	ADD
		CONSTRAINT FK_boardCategory_TO_board
		FOREIGN KEY (
			categoryNo
		)
		REFERENCES boardCategory (
			categoryNo
		);
/*
ALTER TABLE board
	ADD
		CONSTRAINT FK_board_TO_board
		FOREIGN KEY (
			pboardNo
		)
		REFERENCES board (
			boardNo
		);*/

ALTER TABLE board
	ADD
		CONSTRAINT FK_member_TO_board
		FOREIGN KEY (
			regid
		)
		REFERENCES member (
			userId
		);

ALTER TABLE boardFile
	ADD
		CONSTRAINT FK_board_TO_boardFile
		FOREIGN KEY (
			boardNo
		)
		REFERENCES board (
			boardNo
		);

ALTER TABLE boardRep
	ADD
		CONSTRAINT FK_board_TO_boardRep
		FOREIGN KEY (
			boardNo
		)
		REFERENCES board (
			boardNo
		);

ALTER TABLE boardRep
	ADD
		CONSTRAINT FK_member_TO_boardRep
		FOREIGN KEY (
			regid
		)
		REFERENCES member (
			userId
		);

ALTER TABLE userContact
	ADD
		CONSTRAINT FK_member_TO_userContact
		FOREIGN KEY (
			userId
		)
		REFERENCES member (
			userId
		);