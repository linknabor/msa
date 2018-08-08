CREATE database testdb DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
#�û���Ϣ��
DROP TABLE IF EXISTS SSO_USER ;
CREATE TABLE SSO_USER(
ID                                                BIGINT default 0 NOT NULL, #ID
USER_NAME                                         VARCHAR(80) NOT NULL, #�û�����
PASSWORD                                          VARCHAR(255) NULL, #����
STATUS                                            CHAR(1) NOT NULL, #״̬
ORG_ID                                            BIGINT default 0 NOT NULL, #��������ID
ORG_NAME                                          VARCHAR(255) NULL, #��������
ROLE_ID                                           BIGINT default 0 NOT NULL, #��ɫid
CONSTRAINT SSO_USER_PK PRIMARY KEY(ID)   );

#�û��˵���Ϣ��
DROP TABLE IF EXISTS SSO_MENU ;
CREATE TABLE SSO_MENU(
ID                                                BIGINT default 0 NOT NULL, #�˵�id
MENU_NAME                                         VARCHAR(40) NOT NULL, #�˵�����
FORWARD_URL                                       VARCHAR(255) NOT NULL, #�˵���ת����
CONSTRAINT SSO_MENU_PK PRIMARY KEY(ID)   );

#��ɫ�˵���ϵ��
DROP TABLE IF EXISTS SSO_ROLE_MENU ;
CREATE TABLE SSO_ROLE_MENU(
SSO_MENU_ID                                       BIGINT default 0 NOT NULL, #�˵�id
ID                                                BIGINT default 0 NOT NULL, #��ɫid
CONSTRAINT SSO_ROLE_MENU_PK PRIMARY KEY(SSO_MENU_ID,ID)   );

#��ɫ��Ϣ��
DROP TABLE IF EXISTS SSO_ROLE ;
CREATE TABLE SSO_ROLE(
ID                                                BIGINT default 0 NOT NULL, #��ɫid
��ɫ����                                              VARCHAR(80) NOT NULL, #��ɫ����
CONSTRAINT SSO_ROLE_PK PRIMARY KEY(ID)   );


