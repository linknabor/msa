#��ҵǷ����Ϣ��
DROP TABLE IF EXISTS OPS_ARREARAGE_INFO ;
CREATE TABLE OPS_ARREARAGE_INFO(
ARREARAGE_INFO                                    BIGINT default 0 NOT NULL, #Ƿ����ϢID
MOBILE                                            VARCHAR(20) NULL, #�ֻ���
CUST_NAME                                         VARCHAR(40) NULL, #ҵ������
CUST_ADDR                                         VARCHAR(256) NULL, #��ҵ��ַ
ARREARAGE_AMT                                     DECIMAL(16,2) default 0 NOT NULL, #Ƿ�ѽ��
IMPORT_DATE                                       CHAR(8) NULL, #��������
IMPORT_TIME                                       CHAR(6) NULL, #����ʱ��
IMPORT_BATCH                                      BIGINT default 0 NOT NULL, #��������
CONSTRAINT OPS_ARREARAGE_INFO_PK PRIMARY KEY(ARREARAGE_INFO)   );

#������Ϣ��
DROP TABLE IF EXISTS MSA_SMS_INFO ;
CREATE TABLE MSA_SMS_INFO(
SMS_ID                                            BIGINT default 0 NOT NULL, #����ID
SEND_DATE                                         CHAR(8) NULL, #��������
SEND_TIME                                         CHAR(6) NULL, #����ʱ��
CONTENT                                           VARCHAR(256) NULL, #��������
MAPPING_SMS_ID                                    VARCHAR(38) NULL, #��Ӧ��Ӫ�̶���ID
CONSTRAINT MSA_SMS_INFO_PK PRIMARY KEY(SMS_ID)   );


