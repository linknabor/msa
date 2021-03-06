CREATE database msasso DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use msasso;

#角色信息表
DROP TABLE IF EXISTS SSO_ROLE ;
CREATE TABLE SSO_ROLE(
ROLE_ID                                           BIGINT default 0 NOT NULL, #角色id
ROLE_NAME                                         VARCHAR(80) NOT NULL, #角色名称
CONSTRAINT SSO_ROLE_PK PRIMARY KEY(ROLE_ID)   );

#用户菜单信息表
DROP TABLE IF EXISTS SSO_MENU ;
CREATE TABLE SSO_MENU(
MENU_ID                                           BIGINT default 0 NOT NULL, #菜单ID
MENU_NAME                                         VARCHAR(40) NOT NULL, #菜单名称
MENU_CODE                                         VARCHAR(40) NULL, #菜单编码
MENU_LEVEL                                        CHAR(1) NULL, #菜单级别
PARENT_ID                                         BIGINT default 0 NOT NULL, #父菜单ID
MENU_POS                                          DECIMAL(10) default 0 NOT NULL, #菜单位置编号
ENTRANCE_URL                                      VARCHAR(255) NOT NULL, #入口链接
MENU_DESC                                         VARCHAR(255) NULL, #菜单描述
CONSTRAINT SSO_MENU_PK PRIMARY KEY(MENU_ID)   );

#用户信息表
DROP TABLE IF EXISTS SSO_USER ;
CREATE TABLE SSO_USER(
USER_ID                                           BIGINT default 0 NOT NULL, #用户ID
USER_NAME                                         VARCHAR(80) NOT NULL, #用户名称
REAL_NAME                                         VARCHAR(256) NULL, #真实姓名
LOGIN_NAME                                        VARCHAR(256) NULL, #登录名
PASSWORD                                          VARCHAR(255) NULL, #密码
STATUS                                            CHAR(1) NOT NULL, #状态
ROLE_ID                                           BIGINT default 0 NOT NULL, #角色id
ROLE_NAME                                         VARCHAR(80) NULL, #角色名称
ORG_ID                                            BIGINT default 0 NOT NULL, #机构ID
ORG_NAME                                          VARCHAR(255) NULL, #机构名称
MOBILE                                            VARCHAR(11) NULL, #手机号
LOGIN_CERT                                        VARCHAR(255) NULL, #第三方系统登录凭证
TP_SYS_NAME                                       VARCHAR(255) NULL, #第三方系统名称
CREATE_DATE                                       CHAR(8) NULL, #创建日期
CREATE_TIME                                       CHAR(6) NULL, #创建时间
CITY_ID                                           BIGINT default 0 NOT NULL, #城市ID
CITY_NAME                                         VARCHAR(256) NULL, #城市名称
CONSTRAINT SSO_USER_PK PRIMARY KEY(USER_ID)   );

#角色菜单关系表
DROP TABLE IF EXISTS SSO_ROLE_MENU ;
CREATE TABLE SSO_ROLE_MENU(
MENU_ID                                           BIGINT default 0 NOT NULL, #菜单id
ROLE_ID                                           BIGINT default 0 NOT NULL, #角色id
CONSTRAINT SSO_ROLE_MENU_PK PRIMARY KEY(MENU_ID,ROLE_ID)   );


#城市信息表
DROP TABLE IF EXISTS MSA_BASE_CITY ;
CREATE TABLE MSA_BASE_CITY(
CITY_ID                                           BIGINT default 0 NOT NULL, #城市ID
CITY_STATUS                                       CHAR(1) NOT NULL, #状态
CITY_NAME                                         VARCHAR(256) NOT NULL, #城市名称
CITY_CODE                                         VARCHAR(5) NULL, #城市代码
REMARK                                            VARCHAR(512) NULL, #备注
PROVINCE_ID                                       BIGINT default 0 NULL, #省份ID
CONSTRAINT MSA_BASE_CITY_PK PRIMARY KEY(CITY_ID)   );

#组织机构表
DROP TABLE IF EXISTS SSO_ORG_INFO ;
CREATE TABLE SSO_ORG_INFO(
ORG_ID                                            BIGINT default 0 NOT NULL, #机构ID
ORG_STATUS                                        CHAR(1) NOT NULL, #机构状态
LOGIN_NAME                                        VARCHAR(80) NOT NULL, #登录名
ORG_NAME                                          VARCHAR(80) NOT NULL, #机构名称
ORG_TYPE                                          CHAR(2) NOT NULL, #机构类别
LINK_MAN                                          VARCHAR(40) NULL, #联系人
LINK_PHONE                                        VARCHAR(40) NULL, #联系电话
ORG_ADDR                                          VARCHAR(512) NULL, #办公地址
REMARK                                            VARCHAR(512) NULL, #备注
CONSTRAINT SSO_ORG_INFO_PK PRIMARY KEY(ORG_ID)   );

#机构角色关联关系表
DROP TABLE IF EXISTS SSO_ORG_ROLE ;
CREATE TABLE SSO_ORG_ROLE(
ORG_ID                                            BIGINT default 0 NOT NULL, #机构ID
ROLE_ID                                           BIGINT default 0 NOT NULL, #角色id
CONSTRAINT SSO_ORG_ROLE_PK PRIMARY KEY(ORG_ID,ROLE_ID)   );


