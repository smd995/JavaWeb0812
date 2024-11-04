CREATE TABLE tbl_member (
                            mid VARCHAR(50) PRIMARY KEY,
                            mpw VARCHAR(50) NOT NULL,
                            mname VARCHAR(100) NOT NULL
);

INSERT INTO tbl_member VALUES ('user00','1111','사용자 0');
INSERT INTO tbl_member VALUES ('user01','1111','사용자 1');
INSERT INTO tbl_member VALUES ('user02','1111','사용자 2');

SELECT mid, mpw, mname FROM tbl_member WHERE mid = 'user00' AND mpw = '1111';