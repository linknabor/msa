#项目参数模版表
DROP TABLE IF EXISTS MSA_TEMPLET_SECT_PARA ;
CREATE TABLE MSA_TEMPLET_SECT_PARA(
PARA_NAME                                         VARCHAR(80) NOT NULL, #参数名称
SECT_ID                                           BIGINT default 0 NOT NULL, #项目ID
PARA_VALUE                                        VARCHAR(256) NULL, #参数值
PARA_TYPE                                         CHAR(2) NOT NULL, #参数类型
REMARK                                            VARCHAR(256) NULL, #备注
CONSTRAINT MSA_TEMPLET_SECT_PARA_PK PRIMARY KEY(PARA_NAME)   );

#企业参数模板表
DROP TABLE IF EXISTS MSA_TEMPLET_ENP_PARA ;
CREATE TABLE MSA_TEMPLET_ENP_PARA(
PARA_NAME                                         VARCHAR(40) NOT NULL, #参数名称
ENTERPRISE_ID                                     BIGINT default 0 NOT NULL, #企业ID
PARA_VALUE                                        VARCHAR(256) NOT NULL, #参数值
PARA_TYPE                                         CHAR(2) NOT NULL, #参数类型
REMARK                                            VARCHAR(256) NULL, #备注
CONSTRAINT MSA_TEMPLET_ENP_PARA_PK PRIMARY KEY(PARA_NAME)   );

#企业参数配置表
DROP TABLE IF EXISTS MSA_CFG_ENP_PARA ;
CREATE TABLE MSA_CFG_ENP_PARA(
PARA_ID                                           BIGINT default 0 NOT NULL, #参数ID
PARA_NAME                                         VARCHAR(40) NOT NULL, #参数名称
PARA_VALUE                                        VARCHAR(256) NULL, #参数值
PARA_TYPE                                         CHAR(2) NOT NULL, #参数类别
PARA_STATUS                                       CHAR(1) NOT NULL, #参数状态
ENTERPRISE_ID                                     VARCHAR(38) NOT NULL, #企业客户ID
REMARK                                            VARCHAR(256) NULL, #备注
CONSTRAINT MSA_CFG_ENP_PARA_PK PRIMARY KEY(PARA_ID)   );

#项目参数配置表
DROP TABLE IF EXISTS MSA_CFG_SECT_PARA ;
CREATE TABLE MSA_CFG_SECT_PARA(
PARA_ID                                           BIGINT default 0 NOT NULL, #参数ID
PARA_NAME                                         VARCHAR(40) NOT NULL, #参数名称
PARA_VALUE                                        VARCHAR(256) NULL, #参数值
PARA_TYPE                                         CHAR(2) NOT NULL, #参数类别
PARA_STATUS                                       CHAR(1) NOT NULL, #参数状态
SECT_ID                                           BIGINT default 0 NOT NULL, #物业项目ID
REMARK                                            VARCHAR(256) NULL, #备注
CONSTRAINT MSA_CFG_SECT_PARA_PK PRIMARY KEY(PARA_ID)   );


#企业客户信息表
DROP TABLE IF EXISTS MSA_BASE_ENTERPRISE ;
CREATE TABLE MSA_BASE_ENTERPRISE(
ENTERPRISE_ID                                     BIGINT default 0 NOT NULL, #企业客户ID
CUST_STATE                                        CHAR(1) NULL, #客户状态
CUST_NAME                                         VARCHAR(80) NULL, #客户名称
CUST_ADDR                                         VARCHAR(256) NULL, #客户地址
ENTERPRISE_TYPE                                   CHAR(2) NULL, #企业客户类型
CUST_TEL                                          VARCHAR(40) NULL, #联系方式
REMARK                                            VARCHAR(512) NULL, #备注
PROVINCE_ID                                       BIGINT default 0 NOT NULL, #省份ID
CITY_ID                                           BIGINT default 0 NOT NULL, #城市ID
REGION_ID                                         BIGINT default 0 NOT NULL, #行政区域ID
ORIGIN_ID                                         VARCHAR(40) NULL, #源系统ID
ORIGIN_SYS                                        BIGINT default 0 NULL, #源系统
CONSTRAINT MSA_BASE_ENTERPRISE_PK PRIMARY KEY(ENTERPRISE_ID)   );

#物业项目信息表
DROP TABLE IF EXISTS MSA_BASE_SECT ;
CREATE TABLE MSA_BASE_SECT(
SECT_ID                                           BIGINT default 0 NOT NULL, #物业项目ID
STATUS                                            CHAR(1) NOT NULL, #状态
SECT_TYPE                                         CHAR(2) NOT NULL, #项目类型
PRO_TYPE                                          CHAR(1) NULL, #项目性质
IS_FLAG                                           CHAR(1) NULL, #是否上线
ACTIVITY                                          CHAR(1) NULL, #活跃度
SECT_NAME                                         VARCHAR(256) NOT NULL, #名称
SECT_ADDR                                         VARCHAR(256) NOT NULL, #地址
SECT_ROAD                                         VARCHAR(80) NULL, #路
SECT_STREET                                       VARCHAR(80) NULL, #弄
SECT_SUB_STREET                                   VARCHAR(80) NULL, #支弄
SECT_NO                                           VARCHAR(80) NULL, #号
REMARK                                            VARCHAR(512) NULL, #备注
PROVINCE_ID                                       BIGINT default 0 NOT NULL, #省份ID
REGION_ID                                         BIGINT default 0 NOT NULL, #行政区域ID
CITY_ID                                           BIGINT default 0 NOT NULL, #城市ID
ZIP_CODE                                          VARCHAR(6) NULL, #邮政编码
CNST_AREA                                         VARCHAR(20) NULL, #建筑面积
LAND_AREA                                         VARCHAR(20) NULL, #占地面积
SHOPS_AREA                                        VARCHAR(20) NULL, #商铺面积
PUBLIC_AREA                                       VARCHAR(20) NULL, #公建面积
GREEN_AREA                                        VARCHAR(20) NULL, #绿化面积
TOT_BUILDS                                        VARCHAR(20) NULL, #总楼宇数
TOT_HOUS                                          VARCHAR(20) NULL, #总住宅数
TOT_SHOPS                                         VARCHAR(20) NULL, #总商铺数
TOT_ONG_PARKS                                     VARCHAR(20) NULL, #地面车位数
TOT_UNG_PARKS                                     VARCHAR(20) NULL, #室内车位数
OFFICE_ADDR                                       VARCHAR(256) NULL, #小区管理处地址
OFFICE_TEL                                        VARCHAR(40) NULL, #小区报修电话
RELATED_SECT_NO                                   VARCHAR(40) NULL, #关联小区编号
CONSTRAINT MSA_BASE_SECT_PK PRIMARY KEY(SECT_ID)   );

#企业项目关系表
DROP TABLE IF EXISTS MSA_ENTERPRISE_SECT ;
CREATE TABLE MSA_ENTERPRISE_SECT(
ENTERPRISE_ID                                     BIGINT default 0 NOT NULL, #企业客户ID
SECT_ID                                           BIGINT default 0 NOT NULL, #物业项目ID
CONSTRAINT MSA_ENTERPRISE_SECT_PK PRIMARY KEY(ENTERPRISE_ID,SECT_ID)   );




