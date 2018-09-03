CREATE database msasso DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use msasso;

#��ɫ��Ϣ��
DROP TABLE IF EXISTS SSO_ROLE ;
CREATE TABLE SSO_ROLE(
ROLE_ID                                           BIGINT default 0 NOT NULL, #��ɫid
ROLE_NAME                                         VARCHAR(80) NOT NULL, #��ɫ����
CONSTRAINT SSO_ROLE_PK PRIMARY KEY(ROLE_ID)   );

#�û��˵���Ϣ��
DROP TABLE IF EXISTS SSO_MENU ;
CREATE TABLE SSO_MENU(
MENU_ID                                           BIGINT default 0 NOT NULL, #�˵�ID
MENU_NAME                                         VARCHAR(40) NOT NULL, #�˵�����
MENU_CODE                                         VARCHAR(40) NULL, #�˵�����
MENU_LEVEL                                        CHAR(1) NULL, #�˵�����
PARENT_ID                                         BIGINT default 0 NOT NULL, #���˵�ID
MENU_POS                                          DECIMAL(10) default 0 NOT NULL, #�˵�λ�ñ��
ENTRANCE_URL                                      VARCHAR(255) NOT NULL, #�������
MENU_DESC                                         VARCHAR(255) NULL, #�˵�����
CONSTRAINT SSO_MENU_PK PRIMARY KEY(MENU_ID)   );

#�û���Ϣ��
DROP TABLE IF EXISTS SSO_USER ;
CREATE TABLE SSO_USER(
USER_ID                                           BIGINT default 0 NOT NULL, #�û�ID
USER_NAME                                         VARCHAR(80) NOT NULL, #�û�����
REAL_NAME                                         VARCHAR(256) NULL, #��ʵ����
LOGIN_NAME                                        VARCHAR(256) NULL, #��¼��
PASSWORD                                          VARCHAR(255) NULL, #����
STATUS                                            CHAR(1) NOT NULL, #״̬
ROLE_ID                                           BIGINT default 0 NOT NULL, #��ɫid
ROLE_NAME                                         VARCHAR(80) NULL, #��ɫ����
ORG_ID                                            BIGINT default 0 NOT NULL, #����ID
ORG_NAME                                          VARCHAR(255) NULL, #��������
MOBILE                                            VARCHAR(11) NULL, #�ֻ���
LOGIN_CERT                                        VARCHAR(255) NULL, #������ϵͳ��¼ƾ֤
TP_SYS_NAME                                       VARCHAR(255) NULL, #������ϵͳ����
CREATE_DATE                                       CHAR(8) NULL, #��������
CREATE_TIME                                       CHAR(6) NULL, #����ʱ��
CONSTRAINT SSO_USER_PK PRIMARY KEY(USER_ID)   );

#��ɫ�˵���ϵ��
DROP TABLE IF EXISTS SSO_ROLE_MENU ;
CREATE TABLE SSO_ROLE_MENU(
MENU_ID                                           BIGINT default 0 NOT NULL, #�˵�id
ROLE_ID                                           BIGINT default 0 NOT NULL, #��ɫid
CONSTRAINT SSO_ROLE_MENU_PK PRIMARY KEY(MENU_ID,ROLE_ID)   );


