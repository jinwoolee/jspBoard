/*�Խ��� ī�װ�*/
ALTER TABLE boardCategory
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_boardCategory;

/* �Խ��� ī�װ� */
DROP TABLE boardCategory 
	CASCADE CONSTRAINTS;

/* �Խ��� ī�װ� */
CREATE TABLE boardCategory (
	no NUMBER NOT NULL, /* �Խ��� ī�װ� ��ȣ */
	code VARCHAR2(50) NOT NULL, /* ī�װ� �ڵ� */
	memo VARCHAR2(200), /* ī�װ� ���� */
	reg_id VARCHAR2(50) NOT NULL /* �ۼ��� */
);

COMMENT ON TABLE boardCategory IS '�Խ��� ī�װ�';

COMMENT ON COLUMN boardCategory.no IS '�Խ��� ī�װ� ��ȣ';

COMMENT ON COLUMN boardCategory.code IS 'ī�װ� �ڵ�';

COMMENT ON COLUMN boardCategory.memo IS 'ī�װ� ����';

COMMENT ON COLUMN boardCategory.reg_id IS '�ۼ���';

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