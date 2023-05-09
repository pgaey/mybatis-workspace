
DROP TABLE REPLY;
DROP TABLE BOARD;
DROP TABLE MEMBER;

DROP SEQUENCE SEQ_UNO;
DROP SEQUENCE SEQ_BNO;
DROP SEQUENCE SEQ_RNO;

--------------------------------------------------
------------------  MEMBER ���� -------------------
--------------------------------------------------

CREATE TABLE MEMBER (
  USER_NO NUMBER PRIMARY KEY,               
  USER_ID VARCHAR2(30) NOT NULL UNIQUE,   
  USER_PWD VARCHAR2(100) NOT NULL,  
  USER_NAME VARCHAR2(15) NOT NULL,    
  EMAIL VARCHAR2(100),        
  BIRTHDAY VARCHAR2(6),
  GENDER VARCHAR2(1) CHECK (GENDER IN('M', 'F')),    
  PHONE VARCHAR2(13),            
  ADDRESS VARCHAR2(100),
  ENROLL_DATE DATE DEFAULT SYSDATE,
  MODIFY_DATE DATE DEFAULT SYSDATE,
  STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N'))
);

CREATE SEQUENCE SEQ_UNO NOCACHE;

INSERT INTO MEMBER 
VALUES (SEQ_UNO.NEXTVAL, 'admin', '1234', '������', 'admin@kh.or.kr', '800918', 'F', '010-1111-2222', '����� ������ ���ﵿ', SYSDATE, SYSDATE, DEFAULT);

INSERT INTO MEMBER 
VALUES (SEQ_UNO.NEXTVAL, 'user01', 'pass01', 'ȫ�浿', 'user01@kh.or.kr', '900213', 'M', '010-3333-4444', '����� ������ ������', SYSDATE, SYSDATE, DEFAULT);


----------------------------------------------------
-------------------- BOARD ����  --------------------
----------------------------------------------------

CREATE TABLE BOARD(
  BOARD_NO NUMBER PRIMARY KEY,
  BOARD_TITLE VARCHAR2(100) NOT NULL,
  BOARD_CONTENT VARCHAR2(4000) NOT NULL,
  BOARD_WRITER NUMBER,
  COUNT NUMBER DEFAULT 0,
  CREATE_DATE DATE DEFAULT SYSDATE,
  STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')),
  FOREIGN KEY (BOARD_WRITER) REFERENCES MEMBER
);

CREATE SEQUENCE SEQ_BNO NOCACHE;

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, 'ù��° �Խ��� ���񽺸� �����ϰڽ��ϴ�.', '�ȳ��ϼ���. ù �Խ����Դϴ�.', 1, DEFAULT, '20221219', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '�ι�° �Խ��� ���񽺸� �����ϰڽ��ϴ�.', '�ȳ��ϼ���. 2 �Խ����Դϴ�.', 2, DEFAULT, '20230320', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '���� ���긮�� �Խ��� ���񽺸� �����ϰڽ��ϴ�.', '�ȳ��ϼ���. 3 �Խ����Դϴ�.', 1, DEFAULT, '20230321', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '���̹�Ƽ���� ó������?', '�ȳ��ϼ���. �Խ����Դϴ�.', 2, DEFAULT, '20230322', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '���õ�����', '���õ����͸� �����ô�.', 1, DEFAULT, '20230323', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '����¡ó�������� ���õ����� ���� �־���´�..', 'asdf', 2, DEFAULT, '20230324', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '������䤾��', '�ݰ����ϴ�.', 1, DEFAULT, '20230325', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '��ε� ȭ����!!', 'ȭ���� �սô�~', 2, DEFAULT, '20230326', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '�Խ��� ����', '�ȳ��ϼ���. �Խ����Դϴ�.', 1, DEFAULT, '20230327', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '�ȳ��Ͻʴϱ�', '���ṹ����', 2, DEFAULT, '20230328', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '�����ô�!', '�������� �� �ȳ��ҳ׿�!', 1, DEFAULT, '20230329', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '�׽�Ʈ �Խñ� �Դϴ�.', '�� ���̽ó���?', 2, DEFAULT, '20230330', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '���� �����ӿ�ũ..', '�������..', 2, DEFAULT, '20230402', DEFAULT);

INSERT INTO BOARD
VALUES(SEQ_BNO.NEXTVAL, '��� �� ����ұ��', '��Ѥ������ؤѤ��������������', 1, DEFAULT, '20230403', DEFAULT);

----------------------------------------------------
-------------------- REPLY ���� ---------------------	
----------------------------------------------------

CREATE TABLE REPLY(
  REPLY_NO NUMBER PRIMARY KEY,
  REPLY_CONTENT VARCHAR2(400),
  REF_BNO NUMBER,
  REPLY_WRITER NUMBER,
  CREATE_DATE DATE DEFAULT SYSDATE,
  STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN ('Y', 'N')),
  FOREIGN KEY (REF_BNO) REFERENCES BOARD,
  FOREIGN KEY (REPLY_WRITER) REFERENCES MEMBER
);

CREATE SEQUENCE SEQ_RNO NOCACHE;

INSERT INTO REPLY
VALUES(SEQ_RNO.NEXTVAL, 'ù��° ����Դϴ�.', 1, 2, '20221225', DEFAULT);

INSERT INTO REPLY
VALUES(SEQ_RNO.NEXTVAL, 'ù��° ����Դϴ�.', 13, 2, '20230412', DEFAULT);

INSERT INTO REPLY
VALUES(SEQ_RNO.NEXTVAL, '�ι�° ����Դϴ�.', 13, 2, '20230413', DEFAULT);

INSERT INTO REPLY
VALUES(SEQ_RNO.NEXTVAL, '������ ����Դϴ�.', 13, 2, '20230414', DEFAULT);

COMMIT;


