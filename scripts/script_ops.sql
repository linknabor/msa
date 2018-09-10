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


