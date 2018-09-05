#��ҵ�û�ע����Ϣ��
DROP TABLE IF EXISTS MSA_REG_INFO ;
CREATE TABLE MSA_REG_INFO(
REG_ENTERPRISE_ID                                 VARCHAR(38) NOT NULL, #ע����ҵ��ϢID
STATUS                                            CHAR(1) NOT NULL, #ע����Ϣ״̬
REG_DATE                                          CHAR(8) NOT NULL, #ע������
REG_TIME                                          CHAR(6) NOT NULL, #ע��ʱ��
RANDOM_CODE                                       VARCHAR(256) NULL, #�����
LOGIN_NAME                                        VARCHAR(160) NOT NULL, #��¼��
ENTERPRISE_NAME                                   VARCHAR(160) NOT NULL, #��ҵ�ͻ�����
LINK_MAN                                          VARCHAR(40) NOT NULL, #��ϵ��
ORG_TEL                                           VARCHAR(40) NOT NULL, #��ϵ�绰
EMAIL                                             VARCHAR(40) NOT NULL, #Email��ַ
POST_CODE                                         VARCHAR(6) NULL, #��������
ORG_ADDR                                          VARCHAR(256) NULL, #��ϵ��ַ
REMARK                                            VARCHAR(80) NULL, #��ע
PRODUCT_VERSION                                   CHAR(2) NOT NULL, #��Ʒ�汾
START_DATE                                        CHAR(8) NULL, #��ʼʹ������
BACK_TE_NAME                                      VARCHAR(80) NULL, #��̨����Ա����
CONSTRAINT MSA_REG_INFO_PK PRIMARY KEY(REG_ENTERPRISE_ID)   );


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
MOBILE                                            VARCHAR(20) NULL, #�ֻ���
SEND_DATE                                         CHAR(8) NULL, #��������
SEND_TIME                                         CHAR(6) NULL, #����ʱ��
CONTENT                                           VARCHAR(256) NULL, #��������
SMS_BATCH                                         BIGINT default 0 NOT NULL, #�������κ�
SMS_STATUS                                        CHAR(1) NOT NULL, #����״̬
MAPPING_SMS_ID                                    VARCHAR(38) NULL, #��Ӧ��Ӫ�̶���ID
CONSTRAINT MSA_SMS_INFO_PK PRIMARY KEY(SMS_ID)   );

#���ŷ��ͻ��ܱ�
DROP TABLE IF EXISTS MSA_SMS_SUM ;
CREATE TABLE MSA_SMS_SUM(
SMS_BATCH                                         BIGINT default 0 NOT NULL, #�������κ�
TOTAL_COUNT                                       DECIMAL(10) default 0 NOT NULL, #������
SEND_DATE                                         CHAR(8) NULL, #��������
SEND_TIME                                         CHAR(6) NULL, #����ʱ��
TOTAL_FAILED                                      DECIMAL(10) default 0 NOT NULL, #ʧ������
CONSTRAINT MSA_SMS_SUM_PK PRIMARY KEY(SMS_BATCH)   );