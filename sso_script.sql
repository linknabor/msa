CREATE database testdb DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
#用户信息表
DROP TABLE IF EXISTS SSO_USER ;
CREATE TABLE SSO_USER(
ID                                                BIGINT default 0 NOT NULL, #ID
USER_NAME                                         VARCHAR(80) NOT NULL, #用户名称
PASSWORD                                          VARCHAR(255) NULL, #密码
STATUS                                            CHAR(1) NOT NULL, #状态
ORG_ID                                            BIGINT default 0 NOT NULL, #所属机构ID
ORG_NAME                                          VARCHAR(255) NULL, #机构名称
ROLE_ID                                           BIGINT default 0 NOT NULL, #角色id
CONSTRAINT SSO_USER_PK PRIMARY KEY(ID)   );

#用户菜单信息表
DROP TABLE IF EXISTS SSO_MENU ;
CREATE TABLE SSO_MENU(
ID                                                BIGINT default 0 NOT NULL, #菜单id
MENU_NAME                                         VARCHAR(40) NOT NULL, #菜单名称
FORWARD_URL                                       VARCHAR(255) NOT NULL, #菜单跳转链接
CONSTRAINT SSO_MENU_PK PRIMARY KEY(ID)   );

#角色菜单关系表
DROP TABLE IF EXISTS SSO_ROLE_MENU ;
CREATE TABLE SSO_ROLE_MENU(
SSO_MENU_ID                                       BIGINT default 0 NOT NULL, #菜单id
ID                                                BIGINT default 0 NOT NULL, #角色id
CONSTRAINT SSO_ROLE_MENU_PK PRIMARY KEY(SSO_MENU_ID,ID)   );

#角色信息表
DROP TABLE IF EXISTS SSO_ROLE ;
CREATE TABLE SSO_ROLE(
ID                                                BIGINT default 0 NOT NULL, #角色id
角色名称                                              VARCHAR(80) NOT NULL, #角色名称
CONSTRAINT SSO_ROLE_PK PRIMARY KEY(ID)   );


