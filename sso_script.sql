CREATE database testdb DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

#��ɫ��Ϣ��
DROP TABLE IF EXISTS SSO_ROLE ;
CREATE TABLE SSO_ROLE(
ROLE_ID                                           BIGINT default 0 NOT NULL, #��ɫid
ROLE_NAME                                         VARCHAR(80) NOT NULL, #��ɫ����
CONSTRAINT SSO_ROLE_PK PRIMARY KEY(ROLE_ID)   );

#�û��˵���Ϣ��
DROP TABLE IF EXISTS SSO_MENU ;
CREATE TABLE SSO_MENU(
MENU_ID                                           BIGINT default 0 NOT NULL, #�˵�id
MENU_NAME                                         VARCHAR(40) NOT NULL, #�˵�����
FORWARD_URL                                       VARCHAR(255) NOT NULL, #�˵���ת����
CONSTRAINT SSO_MENU_PK PRIMARY KEY(MENU_ID)   );

#�û���Ϣ��
DROP TABLE IF EXISTS SSO_USER ;
CREATE TABLE SSO_USER(
USER_ID                                           BIGINT default 0 NOT NULL, #�û�ID
USER_NAME                                         VARCHAR(80) NOT NULL, #�û�����
PASSWORD                                          VARCHAR(255) NULL, #����
STATUS                                            CHAR(1) NOT NULL, #״̬
ORG_NAME                                          VARCHAR(255) NULL, #��������
ROLE_ID                                           BIGINT default 0 NOT NULL, #��ɫid
ENTERPRISE_ID                                     VARCHAR(38) NOT NULL, #��ҵ�ͻ�ID
MOBILE                                            VARCHAR(11) NULL, #�ֻ���
LOGIN_CERT                                        VARCHAR(255) NULL, #������ϵͳ��¼ƾ֤
TP_SYS_NAME                                       VARCHAR(255) NULL, #������ϵͳ����
CONSTRAINT SSO_USER_PK PRIMARY KEY(USER_ID)   );

#��ɫ�˵���ϵ��
DROP TABLE IF EXISTS SSO_ROLE_MENU ;
CREATE TABLE SSO_ROLE_MENU(
MENU_ID                                           BIGINT default 0 NOT NULL, #�˵�id
ROLE_ID                                           BIGINT default 0 NOT NULL, #��ɫid
CONSTRAINT SSO_ROLE_MENU_PK PRIMARY KEY(MENU_ID,ROLE_ID)   );


