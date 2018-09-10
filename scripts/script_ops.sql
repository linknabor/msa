#��Ŀ����ģ���
DROP TABLE IF EXISTS MSA_TEMPLET_SECT_PARA ;
CREATE TABLE MSA_TEMPLET_SECT_PARA(
PARA_NAME                                         VARCHAR(80) NOT NULL, #��������
SECT_ID                                           BIGINT default 0 NOT NULL, #��ĿID
PARA_VALUE                                        VARCHAR(256) NULL, #����ֵ
PARA_TYPE                                         CHAR(2) NOT NULL, #��������
REMARK                                            VARCHAR(256) NULL, #��ע
CONSTRAINT MSA_TEMPLET_SECT_PARA_PK PRIMARY KEY(PARA_NAME)   );

#��ҵ����ģ���
DROP TABLE IF EXISTS MSA_TEMPLET_ENP_PARA ;
CREATE TABLE MSA_TEMPLET_ENP_PARA(
PARA_NAME                                         VARCHAR(40) NOT NULL, #��������
ENTERPRISE_ID                                     BIGINT default 0 NOT NULL, #��ҵID
PARA_VALUE                                        VARCHAR(256) NOT NULL, #����ֵ
PARA_TYPE                                         CHAR(2) NOT NULL, #��������
REMARK                                            VARCHAR(256) NULL, #��ע
CONSTRAINT MSA_TEMPLET_ENP_PARA_PK PRIMARY KEY(PARA_NAME)   );

#��ҵ�������ñ�
DROP TABLE IF EXISTS MSA_CFG_ENP_PARA ;
CREATE TABLE MSA_CFG_ENP_PARA(
PARA_ID                                           BIGINT default 0 NOT NULL, #����ID
PARA_NAME                                         VARCHAR(40) NOT NULL, #��������
PARA_VALUE                                        VARCHAR(256) NULL, #����ֵ
PARA_TYPE                                         CHAR(2) NOT NULL, #�������
PARA_STATUS                                       CHAR(1) NOT NULL, #����״̬
ENTERPRISE_ID                                     VARCHAR(38) NOT NULL, #��ҵ�ͻ�ID
REMARK                                            VARCHAR(256) NULL, #��ע
CONSTRAINT MSA_CFG_ENP_PARA_PK PRIMARY KEY(PARA_ID)   );

#��Ŀ�������ñ�
DROP TABLE IF EXISTS MSA_CFG_SECT_PARA ;
CREATE TABLE MSA_CFG_SECT_PARA(
PARA_ID                                           BIGINT default 0 NOT NULL, #����ID
PARA_NAME                                         VARCHAR(40) NOT NULL, #��������
PARA_VALUE                                        VARCHAR(256) NULL, #����ֵ
PARA_TYPE                                         CHAR(2) NOT NULL, #�������
PARA_STATUS                                       CHAR(1) NOT NULL, #����״̬
SECT_ID                                           BIGINT default 0 NOT NULL, #��ҵ��ĿID
REMARK                                            VARCHAR(256) NULL, #��ע
CONSTRAINT MSA_CFG_SECT_PARA_PK PRIMARY KEY(PARA_ID)   );


#��ҵ�ͻ���Ϣ��
DROP TABLE IF EXISTS MSA_BASE_ENTERPRISE ;
CREATE TABLE MSA_BASE_ENTERPRISE(
ENTERPRISE_ID                                     BIGINT default 0 NOT NULL, #��ҵ�ͻ�ID
CUST_STATE                                        CHAR(1) NULL, #�ͻ�״̬
CUST_NAME                                         VARCHAR(80) NULL, #�ͻ�����
CUST_ADDR                                         VARCHAR(256) NULL, #�ͻ���ַ
ENTERPRISE_TYPE                                   CHAR(2) NULL, #��ҵ�ͻ�����
CUST_TEL                                          VARCHAR(40) NULL, #��ϵ��ʽ
REMARK                                            VARCHAR(512) NULL, #��ע
PROVINCE_ID                                       BIGINT default 0 NOT NULL, #ʡ��ID
CITY_ID                                           BIGINT default 0 NOT NULL, #����ID
REGION_ID                                         BIGINT default 0 NOT NULL, #��������ID
ORIGIN_ID                                         VARCHAR(40) NULL, #ԴϵͳID
ORIGIN_SYS                                        BIGINT default 0 NULL, #Դϵͳ
CONSTRAINT MSA_BASE_ENTERPRISE_PK PRIMARY KEY(ENTERPRISE_ID)   );

#��ҵ��Ŀ��Ϣ��
DROP TABLE IF EXISTS MSA_BASE_SECT ;
CREATE TABLE MSA_BASE_SECT(
SECT_ID                                           BIGINT default 0 NOT NULL, #��ҵ��ĿID
STATUS                                            CHAR(1) NOT NULL, #״̬
SECT_TYPE                                         CHAR(2) NOT NULL, #��Ŀ����
PRO_TYPE                                          CHAR(1) NULL, #��Ŀ����
IS_FLAG                                           CHAR(1) NULL, #�Ƿ�����
ACTIVITY                                          CHAR(1) NULL, #��Ծ��
SECT_NAME                                         VARCHAR(256) NOT NULL, #����
SECT_ADDR                                         VARCHAR(256) NOT NULL, #��ַ
SECT_ROAD                                         VARCHAR(80) NULL, #·
SECT_STREET                                       VARCHAR(80) NULL, #Ū
SECT_SUB_STREET                                   VARCHAR(80) NULL, #֧Ū
SECT_NO                                           VARCHAR(80) NULL, #��
REMARK                                            VARCHAR(512) NULL, #��ע
PROVINCE_ID                                       BIGINT default 0 NOT NULL, #ʡ��ID
REGION_ID                                         BIGINT default 0 NOT NULL, #��������ID
CITY_ID                                           BIGINT default 0 NOT NULL, #����ID
ZIP_CODE                                          VARCHAR(6) NULL, #��������
CNST_AREA                                         VARCHAR(20) NULL, #�������
LAND_AREA                                         VARCHAR(20) NULL, #ռ�����
SHOPS_AREA                                        VARCHAR(20) NULL, #�������
PUBLIC_AREA                                       VARCHAR(20) NULL, #�������
GREEN_AREA                                        VARCHAR(20) NULL, #�̻����
TOT_BUILDS                                        VARCHAR(20) NULL, #��¥����
TOT_HOUS                                          VARCHAR(20) NULL, #��סլ��
TOT_SHOPS                                         VARCHAR(20) NULL, #��������
TOT_ONG_PARKS                                     VARCHAR(20) NULL, #���泵λ��
TOT_UNG_PARKS                                     VARCHAR(20) NULL, #���ڳ�λ��
OFFICE_ADDR                                       VARCHAR(256) NULL, #С��������ַ
OFFICE_TEL                                        VARCHAR(40) NULL, #С�����޵绰
RELATED_SECT_NO                                   VARCHAR(40) NULL, #����С�����
CONSTRAINT MSA_BASE_SECT_PK PRIMARY KEY(SECT_ID)   );

#��ҵ��Ŀ��ϵ��
DROP TABLE IF EXISTS MSA_ENTERPRISE_SECT ;
CREATE TABLE MSA_ENTERPRISE_SECT(
ENTERPRISE_ID                                     BIGINT default 0 NOT NULL, #��ҵ�ͻ�ID
SECT_ID                                           BIGINT default 0 NOT NULL, #��ҵ��ĿID
CONSTRAINT MSA_ENTERPRISE_SECT_PK PRIMARY KEY(ENTERPRISE_ID,SECT_ID)   );




