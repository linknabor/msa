#企业用户注册信息表
DROP TABLE IF EXISTS MSA_REG_INFO ;
CREATE TABLE MSA_REG_INFO(
REG_ENTERPRISE_ID                                 VARCHAR(38) NOT NULL, #注册企业信息ID
STATUS                                            CHAR(1) NOT NULL, #注册信息状态
REG_DATE                                          CHAR(8) NOT NULL, #注册日期
REG_TIME                                          CHAR(6) NOT NULL, #注册时间
RANDOM_CODE                                       VARCHAR(256) NULL, #随机码
LOGIN_NAME                                        VARCHAR(160) NOT NULL, #登录名
ENTERPRISE_NAME                                   VARCHAR(160) NOT NULL, #企业客户名称
LINK_MAN                                          VARCHAR(40) NOT NULL, #联系人
ORG_TEL                                           VARCHAR(40) NOT NULL, #联系电话
EMAIL                                             VARCHAR(40) NOT NULL, #Email地址
POST_CODE                                         VARCHAR(6) NULL, #邮政编码
ORG_ADDR                                          VARCHAR(256) NULL, #联系地址
REMARK                                            VARCHAR(80) NULL, #备注
PRODUCT_VERSION                                   CHAR(2) NOT NULL, #产品版本
START_DATE                                        CHAR(8) NULL, #开始使用日期
BACK_TE_NAME                                      VARCHAR(80) NULL, #后台操作员名称
CONSTRAINT MSA_REG_INFO_PK PRIMARY KEY(REG_ENTERPRISE_ID)   );


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
MOBILE                                            VARCHAR(20) NULL, #手机号
SEND_DATE                                         CHAR(8) NULL, #发送日期
SEND_TIME                                         CHAR(6) NULL, #发送时间
CONTENT                                           VARCHAR(256) NULL, #短信内容
SMS_BATCH                                         BIGINT default 0 NOT NULL, #短信批次号
SMS_STATUS                                        CHAR(1) NOT NULL, #短信状态
MAPPING_SMS_ID                                    VARCHAR(38) NULL, #对应运营商短信ID
CONSTRAINT MSA_SMS_INFO_PK PRIMARY KEY(SMS_ID)   );

#短信发送汇总表
DROP TABLE IF EXISTS MSA_SMS_SUM ;
CREATE TABLE MSA_SMS_SUM(
SMS_BATCH                                         BIGINT default 0 NOT NULL, #短信批次号
TOTAL_COUNT                                       DECIMAL(10) default 0 NOT NULL, #总条数
SEND_DATE                                         CHAR(8) NULL, #发送日期
SEND_TIME                                         CHAR(6) NULL, #发送时间
TOTAL_FAILED                                      DECIMAL(10) default 0 NOT NULL, #失败条数
CONSTRAINT MSA_SMS_SUM_PK PRIMARY KEY(SMS_BATCH)   );