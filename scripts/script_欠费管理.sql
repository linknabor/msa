#物业欠费信息表
DROP TABLE IF EXISTS OPS_ARREARAGE_INFO ;
CREATE TABLE OPS_ARREARAGE_INFO(
ARREARAGE_INFO                                    BIGINT default 0 NOT NULL, #欠费信息ID
MOBILE                                            VARCHAR(20) NULL, #手机号
CUST_NAME                                         VARCHAR(40) NULL, #业主姓名
CUST_ADDR                                         VARCHAR(256) NULL, #物业地址
ARREARAGE_AMT                                     DECIMAL(16,2) default 0 NOT NULL, #欠费金额
IMPORT_DATE                                       CHAR(8) NULL, #导入日期
IMPORT_TIME                                       CHAR(6) NULL, #导入时间
IMPORT_BATCH                                      BIGINT default 0 NOT NULL, #导入批次
CONSTRAINT OPS_ARREARAGE_INFO_PK PRIMARY KEY(ARREARAGE_INFO)   );

#短信信息表
DROP TABLE IF EXISTS MSA_SMS_INFO ;
CREATE TABLE MSA_SMS_INFO(
SMS_ID                                            BIGINT default 0 NOT NULL, #短信ID
SEND_DATE                                         CHAR(8) NULL, #发送日期
SEND_TIME                                         CHAR(6) NULL, #发送时间
CONTENT                                           VARCHAR(256) NULL, #短信内容
MAPPING_SMS_ID                                    VARCHAR(38) NULL, #对应运营商短信ID
CONSTRAINT MSA_SMS_INFO_PK PRIMARY KEY(SMS_ID)   );


