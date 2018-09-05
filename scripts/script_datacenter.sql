CREATE database msadatacenter DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use msadatacenter;

#������Ϣ��
DROP TABLE IF EXISTS MSA_BASE_SHOPS ;
CREATE TABLE MSA_BASE_SHOPS(
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #��ҵ��ԪID
SHOPS_TYPE                                        CHAR(2) NULL, #��������
SHOPS_AREA                                        VARCHAR(20) NULL, #���ڽ������
SHOPS_PHONE                                       VARCHAR(40) NULL, #�̶��绰
CONSTRAINT MSA_BASE_SHOPS_PK PRIMARY KEY(MNG_CELL_ID)   );

#�ͻ�������ʼ�ɷ����ڱ�
DROP TABLE IF EXISTS MSA_BASE_CUST_CAR_FEE_START_DATE ;
CREATE TABLE MSA_BASE_CUST_CAR_FEE_START_DATE(
CAR_ID                                            BIGINT default 0 NOT NULL, #����ID
FEE_START_DATE                                    CHAR(8) NOT NULL, #�ɷѿ�ʼ����
PAYMENT_DATE                                      CHAR(8) NULL, #�ɷ���Ч����
CONSTRAINT MSA_BASE_CUST_CAR_FEE_START_DATE_PK PRIMARY KEY(CAR_ID)   );

#�ͻ���Ϣ��
DROP TABLE IF EXISTS MSA_BASE_CUST ;
CREATE TABLE MSA_BASE_CUST(
CUST_ID                                           BIGINT default 0 NOT NULL, #�ͻ�ID
CUST_STATUS                                       CHAR(1) NOT NULL, #״̬
CUST_NAME                                         VARCHAR(160) NOT NULL, #�ͻ�����
CUST_TYPE                                         CHAR(2) NOT NULL, #�ͻ�����
CODE_TYPE                                         CHAR(2) NULL, #֤������
CUST_CODE                                         VARCHAR(80) NULL, #֤������/��֯��������
TEL_NO                                            VARCHAR(40) NULL, #��ϵ�绰
ACCT_BANK                                         VARCHAR(160) NULL, #������������
ACCT_NAME                                         VARCHAR(160) NULL, #�����˻�����
ACCT_NO                                           VARCHAR(64) NULL, #�����˺�
REMARK                                            VARCHAR(512) NULL, #��ע
CUST_ACCT_NO                                      BIGINT default 0 NOT NULL, #�ͻ��˺�
IS_CERTIFI                                        CHAR(1) default '0' NOT NULL, #�Ƿ�����֤
RELATED_CUST_NO                                   VARCHAR(40) NULL, #�����ͻ���Ϣ���
CONSTRAINT MSA_BASE_CUST_PK PRIMARY KEY(CUST_ID)   );

#���ݿͻ�������ϵ��
DROP TABLE IF EXISTS MSA_CELL_CUST ;
CREATE TABLE MSA_CELL_CUST(
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #��ҵ��ԪID
CUST_ID                                           BIGINT default 0 NOT NULL, #�ͻ�ID
CUST_KIND                                         CHAR(2) NOT NULL, #�ͻ�����
CONSTRAINT MSA_CELL_CUST_PK PRIMARY KEY(MNG_CELL_ID,CUST_ID)   );

#������ҵ��ϵ��
DROP TABLE IF EXISTS MSA_CUST_CAR ;
CREATE TABLE MSA_CUST_CAR(
CUST_ID                                           BIGINT default 0 NOT NULL, #�ͻ�ID
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #��ҵ��ԪID
CAR_ID                                            BIGINT default 0 NOT NULL, #����ID
CONSTRAINT MSA_CUST_CAR_PK PRIMARY KEY(CUST_ID,MNG_CELL_ID,CAR_ID)   );

#ͣ����ϵ��
DROP TABLE IF EXISTS MSA_PARK_CAR ;
CREATE TABLE MSA_PARK_CAR(
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #��ҵ��ԪID
CUST_ID                                           BIGINT default 0 NOT NULL, #�ͻ�ID
CAR_ID                                            BIGINT default 0 NOT NULL, #����ID
CONSTRAINT MSA_PARK_CAR_PK PRIMARY KEY(MNG_CELL_ID,CUST_ID,CAR_ID)   );

#�̻���Ϣ��
DROP TABLE IF EXISTS MSA_MCH_INFO ;
CREATE TABLE MSA_MCH_INFO(
MCH_INFO_ID                                       BIGINT default 0 NOT NULL, #�̻���ϢID
MCH_ID                                            VARCHAR(256) NOT NULL, #�̻���
MCH_NAME                                          VARCHAR(80) NOT NULL, #�̻�����
MCH_TYPE                                          CHAR(1) NOT NULL, #�̻�����
MCH_STATUS                                        CHAR(1) NOT NULL, #�̻�״̬
SECRET                                            VARCHAR(256) NULL, #�̻���Կ
APPID                                             VARCHAR(20) NULL, #Ӧ��ID
PLAT_CHANNEL                                      CHAR(1) NULL, #֧��ƽ̨
BANK_ACCT                                         VARCHAR(32) NULL, #���н����˻�
ACCT_NAME                                         VARCHAR(256) NULL, #�����˻�����
BANK_NAME                                         VARCHAR(256) NULL, #�����˻�������
CREATE_DATE                                       CHAR(8) NULL, #��������
CREATE_TIME                                       CHAR(6) NULL, #����ʱ��
MCH_SUBJECT                                       VARCHAR(255) NULL, #�̻�����
SUBJECT_ID                                        VARCHAR(255) NULL, #����ID
PARENT_MCH_INFO_ID                                BIGINT default 0 NOT NULL, #�̻���ϢID
CONSTRAINT MSA_MCH_INFO_PK PRIMARY KEY(MCH_INFO_ID)   );

#�̻��������ʹ�ϵ��
DROP TABLE IF EXISTS MSA_MCH_RATE ;
CREATE TABLE MSA_MCH_RATE(
MCH_INFO_ID                                       BIGINT default 0 NOT NULL, #�̻���ϢID
PAY_METHOD                                        CHAR(2) NOT NULL, #֧������
PAY_RATE                                          DECIMAL(5,2) NULL, #֧������
CONSTRAINT MSA_MCH_RATE_CHK3 CHECK(PAY_RATE<=100.00),
CONSTRAINT MSA_MCH_RATE_PK PRIMARY KEY(MCH_INFO_ID,PAY_METHOD)   );

#֧��������Ϣ��
DROP TABLE IF EXISTS MSA_MCH_CFG_PAY ;
CREATE TABLE MSA_MCH_CFG_PAY(
PAY_METHOD                                        CHAR(2) NOT NULL, #֧������
PAY_SCENARIOS                                     CHAR(2) default '00' NOT NULL, #֧������
INFO_ID                                           VARCHAR(38) NOT NULL, #��ϢID
MCH_INFO_ID                                       BIGINT default 0 NOT NULL, #�̻���ϢID
CONSTRAINT MSA_MCH_CFG_PAY_PK PRIMARY KEY(PAY_METHOD,PAY_SCENARIOS,INFO_ID,MCH_INFO_ID)   );

#�̻���������ʹ�ϵ��
DROP TABLE IF EXISTS MSA_MCH_MULTI_RATE ;
CREATE TABLE MSA_MCH_MULTI_RATE(
MCH_INFO_ID                                       BIGINT default 0 NOT NULL, #�̻���ϢID
PAY_METHOD                                        CHAR(2) NOT NULL, #֧������
METHOD_WAY                                        VARCHAR(10) NOT NULL, #������ʽ
PAY_RATE                                          DECIMAL(5,2) NULL, #֧������
CONSULT_THRESHOLD                                 VARCHAR(20) NULL, #���ʽ����ֵ
CONSTRAINT MSA_MCH_MULTI_RATE_CHK4 CHECK(PAY_RATE<=100.00),
CONSTRAINT MSA_MCH_MULTI_RATE_PK PRIMARY KEY(MCH_INFO_ID,PAY_METHOD,METHOD_WAY)   );



#ϵͳ���ò�����
DROP TABLE IF EXISTS MSA_CFG_SYS_PARA ;
CREATE TABLE MSA_CFG_SYS_PARA(
PARA_ID                                           BIGINT default 0 NOT NULL, #����ID
PARA_NAME                                         VARCHAR(40) NOT NULL, #��������
PARA_VALUE                                        VARCHAR(40) NOT NULL, #����ֵ
PARA_TYPE                                         CHAR(1) NOT NULL, #��������
REMARK                                            VARCHAR(512) NULL, #��ע
CONSTRAINT MSA_CFG_SYS_PARA_PK PRIMARY KEY(PARA_ID)   );


#ʡ����Ϣ��
DROP TABLE IF EXISTS MSA_BASE_PROVINCE ;
CREATE TABLE MSA_BASE_PROVINCE(
PROVINCE_ID                                       BIGINT default 0 NOT NULL, #ʡ��ID
PROVINCE_STATUS                                   CHAR(1) NOT NULL, #״̬
PROVINCE_NAME                                     VARCHAR(256) NOT NULL, #ʡ������
PROVINCE_SHORT_NAME                               VARCHAR(40) NULL, #ʡ�ݼ��
REMARK                                            VARCHAR(512) NULL, #��ע
CONSTRAINT MSA_BASE_PROVINCE_PK PRIMARY KEY(PROVINCE_ID)   );

#������Ϣ��
DROP TABLE IF EXISTS MSA_BASE_CITY ;
CREATE TABLE MSA_BASE_CITY(
CITY_ID                                           BIGINT default 0 NOT NULL, #����ID
CITY_STATUS                                       CHAR(1) NOT NULL, #״̬
CITY_NAME                                         VARCHAR(256) NOT NULL, #��������
CITY_CODE                                         VARCHAR(5) NULL, #���д���
REMARK                                            VARCHAR(512) NULL, #��ע
PROVINCE_ID                                       BIGINT default 0 NULL, #ʡ��ID
CONSTRAINT MSA_BASE_CITY_PK PRIMARY KEY(CITY_ID)   );


#����������Ϣ��
DROP TABLE IF EXISTS MSA_BASE_REGION ;
CREATE TABLE MSA_BASE_REGION(
REGION_ID                                         BIGINT default 0 NOT NULL, #��������ID
REGION_STATUS                                     CHAR(1) NOT NULL, #״̬
REGION_NAME                                       VARCHAR(256) NOT NULL, #������������
REMARK                                            VARCHAR(512) NULL, #��ע
CITY_ID                                           BIGINT default 0 NULL, #����ID
CONSTRAINT MSA_BASE_REGION_PK PRIMARY KEY(REGION_ID)   );


#��ҵ�ͻ���Ϣ��
DROP TABLE IF EXISTS MSA_BASE_ENTERPRISE ;
CREATE TABLE MSA_BASE_ENTERPRISE(
ENTERPRISE_ID                                     VARCHAR(38) NOT NULL, #��ҵ�ͻ�ID
CUST_STATE                                        CHAR(1) NULL, #�ͻ�״̬
CUST_NAME                                         VARCHAR(80) NULL, #�ͻ�����
CUST_ADDR                                         VARCHAR(256) NULL, #�ͻ���ַ
ENTERPRISE_TYPE                                   CHAR(2) NULL, #��ҵ�ͻ�����
CUST_TEL                                          VARCHAR(40) NULL, #��ϵ��ʽ
REMARK                                            VARCHAR(512) NULL, #��ע
PROVINCE_ID                                       BIGINT default 0 NOT NULL, #ʡ��ID
CITY_ID                                           BIGINT default 0 NOT NULL, #����ID
REGION_ID                                         BIGINT default 0 NOT NULL, #��������ID
ORIGIN_ID                                         VARCHAR(40) NULL, #ԭϵͳID
ORIGIN_SYS                                        BIGINT default 0 NULL, #Դϵͳ
CONSTRAINT MSA_BASE_ENTERPRISE_PK PRIMARY KEY(ENTERPRISE_ID)   );



#��ҵ��Ŀ��Ϣ��
DROP TABLE IF EXISTS MSA_BASE_SECT ;
CREATE TABLE MSA_BASE_SECT(
SECT_ID                                           BIGINT default 0 NOT NULL, #��ҵ��ĿID
STATUS                                            CHAR(1) NOT NULL, #״̬
SECT_TYPE                                         CHAR(2) NOT NULL, #��Ŀ����
PRO_TYPE                                          CHAR(1) NULL, #��Ŀ����
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


#ҵ��������Ϣ��
DROP TABLE IF EXISTS MSA_BASE_CUST_CAR ;
CREATE TABLE MSA_BASE_CUST_CAR(
CAR_ID                                            BIGINT default 0 NOT NULL, #����ID
CAR_STATUS                                        CHAR(1) NOT NULL, #״̬
CAR_NO                                            VARCHAR(20) NOT NULL, #���ƺ�
CAR_COLOUR                                        CHAR(2) NULL, #��ɫ
CAR_TYPE                                          CHAR(2) NULL, #����
CAR_OWNER_TYPE                                    CHAR(2) NULL, #��������
REMARK                                            VARCHAR(512) NULL, #��ע
CAR_BRAND_ID                                      BIGINT default 0 NULL, #��������ID
CAR_TYPE_ID                                       BIGINT default 0 NULL, #�����ͺ�ID
PARK_TYPE                                         CHAR(2) NOT NULL, #ͣ��
CARPORT_TYPE                                      CHAR(2) NULL, #ͣ�ų�λ����
IS_PREPAID                                        CHAR(1) default '0' NULL, #�Ƿ�Ϊ��ֵ�û�
CUST_ID                                           BIGINT default 0 NOT NULL, #�ͻ�ID
CUST_NAME                                         VARCHAR(160) NOT NULL, #�ͻ�����
CARD_NO                                           VARCHAR(80) NULL, #����
CONSTRAINT MSA_BASE_CUST_CAR_PK PRIMARY KEY(CAR_ID)   );



#��ҵ��Ŀ��ϵ��
DROP TABLE IF EXISTS MSA_ENTERPRISE_SECT ;
CREATE TABLE MSA_ENTERPRISE_SECT(
ENTERPRISE_ID                                     VARCHAR(38) NOT NULL, #��ҵ�ͻ�ID
SECT_ID                                           BIGINT default 0 NOT NULL, #��ҵ��ĿID
CONSTRAINT MSA_ENTERPRISE_SECT_PK PRIMARY KEY(ENTERPRISE_ID,SECT_ID)   );


#סլ��Ϣ��
DROP TABLE IF EXISTS MSA_BASE_HOUSE ;
CREATE TABLE MSA_BASE_HOUSE(
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #��ҵ��ԪID
HOUSE_MODEL                                       CHAR(2) NULL, #����
HOUSE_WARD                                        CHAR(2) NULL, #����
HOUSE_AREA                                        VARCHAR(20) NULL, #���ڽ������
HOUSE_PHONE                                       VARCHAR(40) NULL, #�̶��绰
CONSTRAINT MSA_BASE_HOUSE_PK PRIMARY KEY(MNG_CELL_ID)   );

#��λ/����Ϣ��
DROP TABLE IF EXISTS MSA_BASE_CARPORT ;
CREATE TABLE MSA_BASE_CARPORT(
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #��ҵ��ԪID
CARPORT_TYPE                                      CHAR(2) NULL, #��λ����
CONSTRAINT MSA_BASE_CARPORT_PK PRIMARY KEY(MNG_CELL_ID)   );

#���λ��Ϣ��
DROP TABLE IF EXISTS MSA_BASE_AD_LOCATE ;
CREATE TABLE MSA_BASE_AD_LOCATE(
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #��ҵ��ԪID
AD_LOCATE_TYPE                                    CHAR(2) NULL, #���λ����
CONSTRAINT MSA_BASE_AD_LOCATE_PK PRIMARY KEY(MNG_CELL_ID)   );

#��ҵ��Ԫ��Ϣ��
DROP TABLE IF EXISTS MSA_BASE_CELL ;
CREATE TABLE MSA_BASE_CELL(
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #��ҵ��ԪID
STATUS                                            CHAR(1) NOT NULL, #״̬
CELL_NO                                           VARCHAR(80) NOT NULL, #���
CELL_NAME                                         VARCHAR(40) NULL, #����
CELL_ADDR                                         VARCHAR(256) NULL, #��ַ
CNST_AREA                                         DECIMAL(16,2) default 0 NOT NULL, #�������
CELL_FLOOR                                        VARCHAR(6) default '0' NOT NULL, #¥��
MNG_CELL_TYPE                                     CHAR(2) NOT NULL, #��ҵ����
MNG_CELL_KIND                                     CHAR(1) NOT NULL, #��ҵ����
REMARK                                            VARCHAR(256) NULL, #��ע
LIFT_FLAG                                         CHAR(1) NOT NULL, #���ݱ�־
PROPERTY_KIND                                     CHAR(1) NOT NULL, #��Ȩ����
BUILD_TYPE                                        CHAR(1) NOT NULL, #��������
BUILD_USAGE                                       CHAR(2) NOT NULL, #������;
RELATED_HOU_NO                                    VARCHAR(40) NULL, #�������ݱ��
SECT_ID                                           BIGINT default 0 NOT NULL, #��ҵ��ĿID
CONSTRAINT MSA_BASE_CELL_PK PRIMARY KEY(MNG_CELL_ID)   );

